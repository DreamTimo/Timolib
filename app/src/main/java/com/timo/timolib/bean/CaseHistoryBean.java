package com.timo.timolib.bean;

/**
 * Created by Lunger on 2015/03/01
 *
 */
public class CaseHistoryBean {
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public CaseHistoryBean(String code, String status, String content, String count, String data) {
        this.code = code;
        this.status = status;
        this.content = content;
        this.count = count;
        this.data = data;
    }

    private String code;
    private String status;
    private String content;
    private String count;

    @Override
    public String toString() {
        return "CaseHistoryBean{" +
                "code='" + code + '\'' +
                ", status='" + status + '\'' +
                ", content='" + content + '\'' +
                ", count='" + count + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    private String data;
}
