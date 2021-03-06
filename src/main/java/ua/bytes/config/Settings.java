/*
 * (C) Copyright 2019 Andrey Dorokhin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

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
