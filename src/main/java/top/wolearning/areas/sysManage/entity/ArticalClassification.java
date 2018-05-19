package top.wolearning.areas.sysManage.entity;

import top.wolearning.entity.BaseEntity;

public class ArticalClassification extends BaseEntity {
    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
