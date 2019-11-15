package com.sunhome.framework.desgin.pattern.base.template.entiy;

import lombok.Builder;
import lombok.Data;

/**
 * @author wangqijia
 * @date 2019/11/14 17:02
 */
@Data
@Builder
public class FileResult {

    private  String fileName;

    private String fileBody;
}
