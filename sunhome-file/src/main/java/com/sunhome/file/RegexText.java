package com.sunhome.file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : wangqijia
 * create at:  2020/4/24  下午3:11
 */
public class RegexText {

    public List<String> list;

    public RegexText(String path) throws IOException {
        list = FileUtils.readLines(new File(path), Charset.defaultCharset());
    }

    /**
     * 格式化文本
     *
     * @param regex       正则表达式
     * @param replacement 替换内容
     * @return 已格式化的文本
     */
    public List<String> replace(String regex, String replacement) {
        Map<String, String> regexParams = new HashMap<>();
        regexParams.put(regex, replacement);
        return replace(regexParams);
    }

    /**
     * 格式化文本
     *
     * @param regexParams 表达式
     * @return 已格式化的文本
     */
    public List<String> replace(Map<String, String> regexParams) {
        List<String> newList = new ArrayList<>();
        for (String line : list) {
            for (Map.Entry<String, String> regex : regexParams.entrySet()) {
                line = line.replaceAll(regex.getKey(), regex.getValue());
            }
            newList.add(line);
        }
        return newList;
    }


    public List<String> extract(String regex) {
        String targetContent;

        List<String> newList = new ArrayList<>();
        for (String line : list) {
            targetContent = "";
            Matcher matcher = Pattern.compile(regex).matcher(line);
            while (matcher.find()) {
                targetContent = matcher.group();
                newList.add(targetContent);
                break;
            }
        }
        return newList;
    }
}
