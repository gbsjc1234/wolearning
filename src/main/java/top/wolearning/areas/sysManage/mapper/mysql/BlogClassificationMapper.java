package top.wolearning.areas.sysManage.mapper.mysql;

import org.springframework.web.bind.annotation.RestController;
import top.wolearning.areas.sysManage.entity.ArticalClassification;

public interface BlogClassificationMapper {
    void insertNodeToTree(ArticalClassification articalClassification);
}
