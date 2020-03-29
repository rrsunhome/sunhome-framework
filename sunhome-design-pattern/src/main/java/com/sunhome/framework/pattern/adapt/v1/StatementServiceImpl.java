package com.sunhome.framework.pattern.adapt.v1;

/**
 * 封装有缺陷的接口设计
 * @author : qijia.wang
 * create at:  2020/3/29  下午8:12
 * @description:
 */
public class StatementServiceImpl implements StatementService {
    // 适配第三方提供的对象
    private LSService lsService = new LSService();

    @Override
    public void query(StatementParam param) {
        lsService.query(param.getStatementNo(), param.getBeginDate(), param.getEndDate());
    }
}
