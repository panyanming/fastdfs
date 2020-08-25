package com.ming.fastdfs.util.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.ming.fastdfs.entity.DemoData;

/**
 * <p>Description: </p>
 * <p>
 * <p>Copyright:  2000-至今 北京千方科技股份有限公司.All rights reserved.</p>
 *
 * @author panyanming
 * @date 2020/8/18
 **/
public class ExcelListener extends AnalysisEventListener<DemoData> {
    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {
        System.out.println("******"+demoData);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
