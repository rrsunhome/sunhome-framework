package com.sunhome.framework.pattern.strategy.v1;

public interface VersionPathStrategy {

    String extractVersion(String requestPath);

    String removeVersion(String requestPath, String version);

    String addVersion(String requestPath, String version);
}
