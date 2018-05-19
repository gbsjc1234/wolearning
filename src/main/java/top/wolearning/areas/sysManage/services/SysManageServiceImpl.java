package top.wolearning.areas.sysManage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wolearning.areas.sysManage.entity.ArticalClassification;
import top.wolearning.areas.sysManage.mapper.mysql.BlogClassificationMapper;

@Service
public class SysManageServiceImpl implements SysManageService {

    @Autowired
    private BlogClassificationMapper blogClassificationMapper;

    @Override
    public void addNodeToBlogTree(ArticalClassification articalClassification) {
        blogClassificationMapper.insertNodeToTree(articalClassification);
    }
}
