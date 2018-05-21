package top.wolearning.areas.sysManage.services;

import top.wolearning.areas.sysManage.entity.ArticalClassification;

import java.util.List;

public interface SysManageService {
    void addNodeToBlogTree(ArticalClassification articalClassification);
    String getMaxSibling(String Code);
    List<ArticalClassification> getAllNodes();
}
