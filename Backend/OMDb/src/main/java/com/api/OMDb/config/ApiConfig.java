package com.api.OMDb.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "omdb.api")
public class ApiConfig {

    private String url;
    private String key;
    
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    
    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }

}

