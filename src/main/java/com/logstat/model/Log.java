/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Oct 20, 2021 3:21:09 PM
 */
package com.logstat.model;

import java.time.LocalDateTime;


public class Log {
    private String ip;
    private LocalDateTime dateTime;
    private HTTPMethod method;
    private String request;
    private short responseCode;
    private int responseSize;
    private String httpVersion;
    private String referrer;
    private String userAgent;
    

    public String getIp() {
        return ip;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public HTTPMethod getMethod() {
        return method;
    }

    public String getRequest() {
        return request;
    }

    public String getHttpVersion() {
        return httpVersion;
    }

    public String getReferrer() {
        return referrer;
    }

    public short getResponseCode() {
        return responseCode;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public int getResponseSize() {
	return responseSize;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setMethod(HTTPMethod method) {
        this.method = method;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public void setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public void setResponseCode(short responseCode) {
        this.responseCode = responseCode;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public void setResponseSize(int responseSize) {
	this.responseSize = responseSize;
    }
    
    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Log [ip = ");
	builder.append(ip);
	builder.append(", Date time = ");
	builder.append(dateTime);
	builder.append(", Method = ");
	builder.append(method);
	builder.append(", Request = ");
	builder.append(request);
	builder.append(", Response code = ");
	builder.append(responseCode);
	builder.append(", Response size = ");
	builder.append(responseSize);
	builder.append(", Http version = ");
	builder.append(httpVersion);
	builder.append(", Referrer = ");
	builder.append(referrer);
	builder.append(", User agent = ");
	builder.append(userAgent);
	builder.append("]");
	return builder.toString();
    }
}
