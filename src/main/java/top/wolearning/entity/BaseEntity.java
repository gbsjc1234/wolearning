package top.wolearning.entity;

import java.sql.Timestamp;

public class BaseEntity {
    private String refid;
    private Timestamp createTime;
    private String createRefid;
    private Timestamp modifyTime;
    private String modifyRefid;
    private Boolean deleted;
    private Integer version;

    public String getRefid() {
        return refid;
    }

    public void setRefid(String refid) {
        this.refid = refid;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getCreateRefid() {
        return createRefid;
    }

    public void setCreateRefid(String createRefid) {
        this.createRefid = createRefid;
    }

    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyRefid() {
        return modifyRefid;
    }

    public void setModifyRefid(String modifyRefid) {
        this.modifyRefid = modifyRefid;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
