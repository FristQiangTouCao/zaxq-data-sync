package com.hongtian.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/*@XmlRootElement(name = "Register")*/
public class Register {
    @JsonProperty(value = "ZHAFXQXTBS")
    private String ZHAFXQXTBS;
    @JsonProperty(value = "Version")
    private String Version;
    @JsonProperty(value = "ZHAFXQXTBS")
    public String getZHAFXQXTBS() {
        return ZHAFXQXTBS;
    }
    @JsonProperty(value = "ZHAFXQXTBS")
    public void setZHAFXQXTBS(String ZHAFXQXTBS) {
        this.ZHAFXQXTBS = ZHAFXQXTBS;
    }
    @JsonProperty(value = "Version")
    public String getVersion() {
        return Version;
    }
    @JsonProperty(value = "Version")
    public void setVersion(String version) {
        Version = version;
    }
}
