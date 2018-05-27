package top.wolearning.areas.sysManage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wolearning.areas.sysManage.entity.ArticalContent;
import top.wolearning.areas.sysManage.mapper.mysql.ArticalContentMapper;

@Service
public class BlogContentServiceImpl implements BlogContentService {

    @Autowired
    ArticalContentMapper articalContentMapper;
    @Override
    public void saveBlog(ArticalContent content) {
        articalContentMapper.insertContent(content);
    }
}
