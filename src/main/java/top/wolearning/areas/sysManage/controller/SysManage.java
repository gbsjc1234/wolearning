package top.wolearning.areas.sysManage.controller;

import com.alibaba.druid.wall.violation.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
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
    @ResponseBody
    public ResultObj addNodeToTree(@RequestParam String parentCode, @RequestParam String name) {
        ResultObj resultObj = new ResultObj();
        try {
            String siblingMaxCode= sysManageService.getMaxSibling(parentCode);
            String code = parentCode;
            if (siblingMaxCode==null) {
                code += "001";
            } else {
                Integer nowCode = Integer.parseInt(siblingMaxCode) + 1;
                String nowCodeStr = nowCode + "";
                if (nowCodeStr.length()==1) {
                    nowCodeStr="00"+ nowCodeStr;
                }
                if (nowCodeStr.length()==2) {
                    nowCodeStr="0"+nowCodeStr;
                }
                code +=nowCodeStr;
            }
            ArticalClassification articalClassification = new ArticalClassification();
            articalClassification.setCode(code);
            articalClassification.setName(name);
            sysManageService.addNodeToBlogTree(articalClassification);
            resultObj.setCode(ErrorEnum.OK.getCode());
            resultObj.setMessage("插入节点成功");
        } catch (Exception ex) {
            resultObj.setCode(ErrorEnum.ERROR_INSERT.getCode());
            resultObj.setMessage("插入节点失败");
            resultObj.setData(ex.toString());
        }
        return resultObj;
    }
}
