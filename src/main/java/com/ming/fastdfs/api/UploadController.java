package com.ming.fastdfs.api;

import com.ming.fastdfs.util.FastDFSFile;
import com.ming.fastdfs.util.FileManager;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 86189 on 2020/8/6.
 */
@Controller
@RequestMapping(value = "/upload")
public class UploadController {


    @PostMapping(value = "/uploadFile2")
    @ResponseBody
    public Object uploadFile2(@RequestParam(value = "file") MultipartFile attach) throws IOException {
        String ext = attach.getOriginalFilename().substring(attach.getOriginalFilename().lastIndexOf(".")+1);
        FastDFSFile file = new FastDFSFile(attach.getBytes(),ext);
        NameValuePair[] meta_list = new NameValuePair[4];
        meta_list[0] = new NameValuePair("fileName", attach.getOriginalFilename());
        meta_list[1] = new NameValuePair("fileLength", String.valueOf(attach.getSize()));
        meta_list[2] = new NameValuePair("fileExt", ext);
        meta_list[3] = new NameValuePair("fileAuthor", "");
        String filePath = FileManager.upload(file,meta_list);
        System.out.println(filePath);
        return null;
    }

    @PostMapping(value = "/uploadFile")
    @ResponseBody
    public Object uploadFile(@RequestParam(value = "file") MultipartFile multipartFile) throws IOException, MyException {
        String uploadFilePath = "C:\\Users\\86189\\Desktop\\图片\\2.gif";

        String filePath = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();
        System.out.println(filePath);
        // 1、加载配置文件，配置文件中的内容就是 tracker 服务的地址。
//        ClientGlobal.init(filePath);  //加载conf文件
        ClientGlobal.initByProperties("fastdfs-client.properties");
        // 2、创建一个 TrackerClient 对象。直接 new 一个。
        TrackerClient trackerClient = new TrackerClient();
        // 3、使用 TrackerClient 对象创建连接，获得一个 TrackerServer 对象。
        TrackerServer trackerServer = trackerClient.getConnection();
        // 4、创建一个 StorageServer 的引用，值为 null
        StorageServer storageServer = null;
        // 5、创建一个 StorageClient 对象，需要两个参数 TrackerServer 对象、StorageServer 的引用
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        // 6、使用 StorageClient 对象上传图片。
        //扩展名不带“.”
//        String[] strings = storageClient.upload_file(uploadFilePath, "gif",
//                null);

        // 7、返回数组。包含组名和图片的路径。
//        for (String string : strings) {
//            System.out.println(string);
//        }
        String imgUrl = "http://192.168.56.100:8888";
        try {
            byte[] bytes = multipartFile.getBytes();// 获得上传的二进制对象
            // 获得文件后缀名
            String originalFilename = multipartFile.getOriginalFilename();// a.jpg
            System.out.println(originalFilename);
            int i = originalFilename.lastIndexOf(".");
            String extName = originalFilename.substring(i + 1);
            String[] uploadInfos = storageClient.upload_file(bytes, extName, null);
            for (String uploadInfo : uploadInfos) {
                imgUrl += "/" + uploadInfo;
            }
            System.out.println(imgUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("上传完成");
        return null;
    }


    @GetMapping("/download")
    @ResponseBody
    public ResponseEntity<byte[]> downloadFile(HttpServletRequest request, HttpServletResponse response) throws IOException, MyException {
        return FileManager.download("group1", "M00/00/00/wKg4ZF8rnL2ANCvdAACcs8ywZhM748.gif","pym.gif");
    }



    public static byte[] download_file(String group_name, String remote_filename) throws IOException, MyException
    {
        final long file_offset = 0;
        final long download_bytes = 0;

        String filePath = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();
        System.out.println(filePath);
        // 1、加载配置文件，配置文件中的内容就是 tracker 服务的地址。
//        ClientGlobal.init(filePath);  //加载conf文件
        ClientGlobal.initByProperties("fastdfs-client.properties");
        // 2、创建一个 TrackerClient 对象。直接 new 一个。
        TrackerClient trackerClient = new TrackerClient();
        // 3、使用 TrackerClient 对象创建连接，获得一个 TrackerServer 对象。
        TrackerServer trackerServer = trackerClient.getConnection();
        // 4、创建一个 StorageServer 的引用，值为 null
        StorageServer storageServer = null;
        // 5、创建一个 StorageClient 对象，需要两个参数 TrackerServer 对象、StorageServer 的引用
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        return storageClient.download_file(group_name, remote_filename, file_offset, download_bytes);
    }



}
