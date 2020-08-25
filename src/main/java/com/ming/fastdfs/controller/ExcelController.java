package com.ming.fastdfs.controller;

import com.alibaba.excel.EasyExcel;
import com.ming.fastdfs.entity.DemoData;
import com.ming.fastdfs.entity.TeacherData;
import com.ming.fastdfs.util.easyexcel.ExcelListener;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>Description: </p>
 * <p>
 * <p>Copyright:  2000-至今 北京千方科技股份有限公司.All rights reserved.</p>
 *
 * @author panyanming
 * @date 2020/8/18
 **/
@RestController
@RequestMapping("/excel")
public class ExcelController {


    @PostMapping(value = "/uploadFile3")
    @ResponseBody
    public void readExcel(@RequestParam(value = "file") MultipartFile attach) throws IOException {
        //实现excel读操作
//        String filename = "C:\\github\\学生.xlsx";
//        EasyExcel.read(filename,DemoData.class,new ExcelListener()).sheet().doRead();
        EasyExcel.read(attach.getInputStream(),DemoData.class,new ExcelListener()).sheet().doRead();
    }

    @PostMapping(value = "/uploadFile4")
    @ResponseBody
    public void readTeacherExcel(@RequestParam(value = "file") MultipartFile attach) throws IOException {
        //实现excel读操作
//        String filename = "C:\\github\\学生.xlsx";
//        EasyExcel.read(filename,DemoData.class,new ExcelListener()).sheet().doRead();
        EasyExcel.read(attach.getInputStream(),TeacherData.class,new ExcelListener()).sheet().doRead();
    }

}
