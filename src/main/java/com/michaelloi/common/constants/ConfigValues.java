package com.michaelloi.common.constants;

public class ConfigValues {
    public static final String applicationName = "${spring.application.name}";
    public static final String anonymous = "Anonymous";

    public static class timeout{
        public static final String restTemplate = "55000";
    }
}
