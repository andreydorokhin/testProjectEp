package ua.bytes.config;

public class Settings {
    private String baseURL;
    private String domain;
    private String browser;

    // Getter Methods

    public String getBaseURL() {
        return baseURL;
    }

    public String getDomain() {
        return domain;
    }

    public String getBrowser() {
        return browser;
    }


    // Setter Methods

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

}
