package com.hallak.GameApp.exceptions.structure;

import java.time.Instant;

public class CustomError {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String trace;

    public CustomError(Instant timestamp, Integer status, String error, String trace) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.trace = trace;
    }

    public CustomError() {
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }
}