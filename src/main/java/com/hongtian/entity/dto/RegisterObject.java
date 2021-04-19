package com.hongtian.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Administrator on 20-5-14.
 */
public class RegisterObject {
    @JsonProperty(value = "RegisterObject")
    private Register RegisterObject;
    @JsonProperty(value = "RegisterObject")
    public Register getRegisterObject() {
        return RegisterObject;
    }
    @JsonProperty(value = "RegisterObject")
    public void setRegisterObject(Register registerObject) {
        RegisterObject = registerObject;
    }
}
