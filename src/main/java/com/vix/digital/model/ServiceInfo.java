package com.vix.digital.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ServiceInfo {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer statusCode;
    private String message;
    private long responseTimeInMillis;

    public ServiceInfo(){
    }

    public ServiceInfo(int statusCode, String message, long responseTimeInMillis){
        this.statusCode = statusCode;
        this.message = message;
        this.responseTimeInMillis = responseTimeInMillis;
    }
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getResponseTimeInMillis() {
        return responseTimeInMillis;
    }

    public void setResponseTimeInMillis(long responseTimeInMillis) {
        this.responseTimeInMillis = responseTimeInMillis;
    }


}
