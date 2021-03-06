package top.wolearning.areas.sysManage.mapper.mysql;

import org.springframework.web.bind.annotation.RestController;
import top.wolearning.areas.sysManage.entity.ArticalClassification;

import java.util.List;
import java.util.Map;

@RestController
public interface BlogClassificationMapper {
    void insertNodeToTree(ArticalClassification articalClassification);
    String queryMaxSiblingCode(Map map);
    List<ArticalClassification> selectAllNodes();
    List<ArticalClassification> querySameNameNode(Map map);

    void updateNode(ArticalClassification articalClassification);

    List<ArticalClassification> getChildrenNodes(Map map);
}
