package top.wolearning.areas.sysManage.services;

import top.wolearning.areas.sysManage.entity.ArticalClassification;

import java.util.List;
import java.util.Map;

public interface SysManageService {
    void addNodeToBlogTree(ArticalClassification articalClassification);
    String getMaxSibling(String Code);
    List<ArticalClassification> getAllNodes();
    List<ArticalClassification> getSameNameNode(String parentCode, String name);

    void deleteArticalNode(String code);

    void modifyArticalNode(String code, String name);

    List<ArticalClassification> getChildrenNodes(String parentCode);
}
