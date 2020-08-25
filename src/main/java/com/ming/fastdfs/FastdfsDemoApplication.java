package com.ming.fastdfs;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@SpringBootApplication
public class FastdfsDemoApplication {

	public static void main(String[] args) throws IOException, MyException {
		SpringApplication.run(FastdfsDemoApplication.class, args);

//		String uploadFilePath="C:\\Users\\86189\\Desktop\\图片\\2.gif";
//
//		String filePath = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();
//		System.out.println(filePath);
//		// 1、加载配置文件，配置文件中的内容就是 tracker 服务的地址。
//		ClientGlobal.init(filePath);
//		// 2、创建一个 TrackerClient 对象。直接 new 一个。
//		TrackerClient trackerClient = new TrackerClient();
//		// 3、使用 TrackerClient 对象创建连接，获得一个 TrackerServer 对象。
//		TrackerServer trackerServer = trackerClient.getConnection();
//		// 4、创建一个 StorageServer 的引用，值为 null
//		StorageServer storageServer = null;
//		// 5、创建一个 StorageClient 对象，需要两个参数 TrackerServer 对象、StorageServer 的引用
//		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
//		// 6、使用 StorageClient 对象上传图片。
//		//扩展名不带“.”
//		String[] strings = storageClient.upload_file(uploadFilePath, "gif",
//				null);
//		// 7、返回数组。包含组名和图片的路径。
//		for (String string : strings) {
//			System.out.println(string);
//		}
//		System.out.println("上传完成");
//		System.out.println("la la la ...");
	}

}
