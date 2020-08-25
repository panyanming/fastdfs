package com.ming.fastdfs.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * <p>Description: </p>
 * <p>
 * <p>Copyright:  2000-至今 北京千方科技股份有限公司.All rights reserved.</p>
 *
 * @author panyanming
 * @date 2020/8/18
 **/
@Data
public class DemoData {

    @ExcelProperty(value="学生编号",index = 0)
    private Integer sno;

    @ExcelProperty(value = "学生姓名",index = 1)
    private String sname;
}
