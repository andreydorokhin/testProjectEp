package ua.bytes.config;

import java.util.ArrayList;
import java.util.Arrays;

public class Settings {
    private String baseURL = "google.com.co.in";
    private String domain = "testautomationday.com";
    ArrayList < Object > browsers = new ArrayList< Object >(Arrays.asList("chrome", "edge")); // "chrome", "edge", "mozila"

    // Getter Methods

    public String getBaseURL() {
        return baseURL;
    }

    public String getDomain() {
        return domain;
    }

    // Setter Methods

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
