package com.sunhome.framework.desgin.pattern.base.template;

import com.sunhome.framework.desgin.pattern.base.template.entiy.FileResult;

/**
 * 定义文件接口非凡
 */
public interface FileDown {

    FileResult download(String fileUrl);
}
