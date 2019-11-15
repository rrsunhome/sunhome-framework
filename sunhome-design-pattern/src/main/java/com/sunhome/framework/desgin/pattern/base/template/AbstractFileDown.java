package com.sunhome.framework.desgin.pattern.base.template;

import com.alibaba.fastjson.JSONObject;
import com.sunhome.framework.desgin.pattern.base.template.entiy.FileResult;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author wangqijia
 * @date 2019/11/14 17:06
 */
public abstract class AbstractFileDown implements FileDown {

    /**
     * 此方法为抽象方法，设置final 不允许被覆盖
     *
     * @param fileUrl
     * @return
     */
    @Override
    public final FileResult download(String fileUrl) {
        JSONObject result = getDownloadResult(fileUrl);
        String fileBody = "";
        if ("200".equals(result.get("code").toString())) {
            fileBody = cleanBody(result.get("body").toString());
        }

        return FileResult.builder()
                .fileBody(fileBody)
                .fileName("文件名称").build();
    }

    /**
     * 子类清洗数据，构建自己业务需要的
     *
     * @param result
     * @return
     */
    protected abstract String cleanBody(String result);


    private JSONObject getDownloadResult(String fileUrl) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(fileUrl);
        // 响应模型
        CloseableHttpResponse response = null;
        JSONObject result = new JSONObject();
        result.put("code", 100);
        try {
            response = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                result.put("code", 200);
                result.put("body", EntityUtils.toString(responseEntity));
                return result;
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        result.put("body", "文件出错");
        return result;
    }


}
