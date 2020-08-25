package com.ming.fastdfs.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * <p>Description: </p>
 * <p>
 * <p>Copyright:  2000-至今 北京千方科技股份有限公司.All rights reserved.</p>
 *
 * @author panyanming
 * @date 2020/8/20
 **/
@Data
public class TeacherData {
    @ExcelProperty(value="老师编号",index = 0)
    private Integer tno;

    @ExcelProperty(value = "老师姓名",index = 1)
    private String tname;
}
