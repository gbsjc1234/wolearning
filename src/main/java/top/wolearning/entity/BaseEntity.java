package top.wolearning.entity;

import com.mysql.jdbc.StringUtils;
import java.sql.Timestamp;
import static top.wolearning.utils.EncodeAndUUID.getUUID;

public class BaseEntity {
    private String refid;
    private Timestamp createTime;
    private String createRefid;
    private Timestamp modifyTime;
    private String modifyRefid;
    private Boolean deleted;
    private Integer version;

    public String getRefid() {
        if (StringUtils.isNullOrEmpty(this.refid)) {
            return  getUUID();
        }
        else {
            return refid;
        }
    }

    public void setRefid(String refid) {
        this.refid = refid;
    }

    public Timestamp getCreateTime() {
        if (this.createTime==null) {
            return new Timestamp(System.currentTimeMillis());
        }
        else {
            return createTime;
        }
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
        if (this.modifyTime==null) {
            return new Timestamp(System.currentTimeMillis());
        }
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
