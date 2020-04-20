package com.sunhome.framework.pattern.strategy.v1;

/**
 * {@code "{version}/path/foo.js"}.
 *
 * @author : wangqijia
 * create at:  2020/4/20  下午2:22
 */
public class PrefixVersionPathStrategy implements VersionPathStrategy {

    private final String prefix;

    public PrefixVersionPathStrategy(String version) {
        this.prefix = version;
    }

    @Override
    public String extractVersion(String requestPath) {
        return (requestPath.startsWith(this.prefix) ? this.prefix : null);
    }

    @Override
    public String removeVersion(String requestPath, String version) {
        return requestPath.substring(this.prefix.length());
    }

    @Override
    public String addVersion(String path, String version) {
        return (this.prefix.endsWith("/") || path.startsWith("/") ? this.prefix + path : this.prefix + "/" + path);
    }
}
