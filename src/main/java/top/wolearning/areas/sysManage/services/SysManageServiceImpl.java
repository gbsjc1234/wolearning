package top.wolearning.areas.sysManage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;
import top.wolearning.areas.sysManage.entity.ArticalClassification;
import top.wolearning.areas.sysManage.mapper.mysql.BlogClassificationMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysManageServiceImpl implements SysManageService {

    @Autowired
    private BlogClassificationMapper blogClassificationMapper;

    @Override
    public void addNodeToBlogTree(ArticalClassification articalClassification) {
        blogClassificationMapper.insertNodeToTree(articalClassification);
    }

    @Override
    public String getMaxSibling(String code) {
        int len = code.length();
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("code", code);
        map.put("length",len + 3);
        return blogClassificationMapper.queryMaxSiblingCode(map);
    }

    @Override
    public List<ArticalClassification> getAllNodes() {
        return blogClassificationMapper.selectAllNodes();
    }

    @Override
    public List<ArticalClassification> getSameNameNode(String parentCode, String name) {
        int len = parentCode.length();
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("code", parentCode);
        map.put("length",len + 3);
        map.put("name", name);
        return blogClassificationMapper.querySameNameNode(map);
    }

    @Override
    public void deleteArticalNode(String code) {
        ArticalClassification articalClassification=new ArticalClassification();
        articalClassification.setCode(code);
        articalClassification.setDeleted(true);
        blogClassificationMapper.updateNode(articalClassification);
    }

    @Override
    public void modifyArticalNode(String code, String name) {
        ArticalClassification articalClassification=new ArticalClassification();
        articalClassification.setCode(code);
        articalClassification.setName(name);
        blogClassificationMapper.updateNode(articalClassification);
    }

    @Override
    public List<ArticalClassification> getChildrenNodes(String parentCode) {
        Integer length = parentCode.length()+3;
        Map<String,Object> paraMap = new HashMap<String,Object>();
        paraMap.put("code", parentCode);
        paraMap.put("length", length);
        return blogClassificationMapper.getChildrenNodes(paraMap);
    }
}
