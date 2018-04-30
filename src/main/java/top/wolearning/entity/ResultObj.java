package top.wolearning.entity;

import java.sql.Timestamp;

public class ResultObj {
    private Integer code;
    private String message;
    private Object data;
    private Timestamp createTime;
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public ResultObj() {
        this.createTime = new Timestamp(System.currentTimeMillis());
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
