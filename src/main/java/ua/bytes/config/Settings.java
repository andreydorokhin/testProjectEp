package ua.bytes.config;

public class Settings {
    private String baseURL;
    private String domain;
    private String browser;
    private String detectedText;

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

    public String getDetectedText() {
        return detectedText;
    }

    // Setter Methods
    public void setDetectedText(String detectedText) {
        this.detectedText = detectedText;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setBrowser(String browser)   {
        this.browser = browser;
    }

}
