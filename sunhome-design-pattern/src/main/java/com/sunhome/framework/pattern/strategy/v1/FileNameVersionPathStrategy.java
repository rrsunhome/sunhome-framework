package com.sunhome.framework.pattern.strategy.v1;

import com.sunhome.framework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * {@code "path/foo-{version}.css"}.
 *
 * @author : wangqijia
 * create at:  2020/4/20  下午2:16
 */
public class FileNameVersionPathStrategy implements VersionPathStrategy {

    private static final Pattern pattern = Pattern.compile("-(\\S*)\\.");

    @Override
    public String extractVersion(String requestPath) {
        Matcher matcher = pattern.matcher(requestPath);
        if (matcher.find()) {
            String match = matcher.group(1);
            return match.contains("-") ? match.substring(match.lastIndexOf("-") + 1) : match;
        } else {
            return null;
        }
    }

    @Override
    public String removeVersion(String requestPath, String version) {
        return StringUtils.delete(requestPath, "-" + version);
    }

    @Override
    public String addVersion(String requestPath, String version) {
        String baseFilename = StringUtils.stripFilenameExtension(requestPath);
        String extension = StringUtils.getFilenameExtension(requestPath);
        return baseFilename + "-" + version + "." + extension;
    }
}
