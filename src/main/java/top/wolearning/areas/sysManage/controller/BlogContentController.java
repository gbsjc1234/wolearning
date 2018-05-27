package top.wolearning.areas.sysManage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wolearning.areas.sysManage.entity.ArticalContent;
import top.wolearning.areas.sysManage.services.BlogContentService;
import top.wolearning.entity.ErrorEnum;
import top.wolearning.entity.ResultObj;

@RestController
@RequestMapping("/blogContent")
public class BlogContentController {
    @Autowired
    BlogContentService blogContentService;

    @PostMapping(value="/saveBlog")
    public ResultObj SaveBlogContent(@RequestBody ArticalContent content) {
        ResultObj resultObj = new ResultObj();
        try {
            blogContentService.saveBlog(content);
            resultObj.setCode(ErrorEnum.OK.getCode());
            resultObj.setMessage("内容保存成功");
        } catch (Exception ex) {
            resultObj.setCode(ErrorEnum.ERROR_INSERT.getCode());
            resultObj.setData(ex.toString());
            resultObj.setMessage("保存内容失败");
        }
        return  resultObj;
    }
}
