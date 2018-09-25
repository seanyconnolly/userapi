package com.suirtech.automation.testservice.model;

import lombok.Data;

@Data
public class Health {

    private String status;
    private String version;

    public Health() {
        this.status = "OK";
        this.version = "1.0.1";
    }

}
