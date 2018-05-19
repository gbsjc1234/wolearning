package top.wolearning.areas.sysManage.controller;

import com.alibaba.druid.wall.violation.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.wolearning.areas.sysManage.entity.ArticalClassification;
import top.wolearning.areas.sysManage.services.SysManageService;
import top.wolearning.entity.ErrorEnum;
import top.wolearning.entity.ResultObj;

import javax.persistence.SqlResultSetMapping;

@RestController
@RequestMapping("/sysManage")
public class SysManage {

    @Autowired
    private SysManageService sysManageService;

    @GetMapping("/getClassificationTree")
    public ResultObj getClassificationTree() {
        return null;
    }

    @RequestMapping(value = "/addNodeToClassificationTree", method = {RequestMethod.POST})
    public ResultObj addNodeToTree(String parentCode, String name) {
        ResultObj resultObj = new ResultObj();
        try {
            String code = parentCode + "001";
            ArticalClassification articalClassification = new ArticalClassification();
            articalClassification.setCode(code);
            articalClassification.setName(name);
            sysManageService.addNodeToBlogTree(articalClassification);
            resultObj.setCode(ErrorEnum.OK.getCode());
            resultObj.setMessage("插入节点成功");
        } catch (Exception ex) {
            resultObj.setCode(ErrorEnum.ERROR_INSERT.getCode());
            resultObj.setMessage("插入节点失败");
        }
        return resultObj;
    }
}
