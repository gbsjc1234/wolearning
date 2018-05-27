package top.wolearning.areas.sysManage.controller;

import com.mysql.jdbc.StringUtils;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.logging.log4j.core.impl.ReusableLogEventFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.wolearning.areas.sysManage.entity.ArticalClassification;
import top.wolearning.areas.sysManage.entity.ArticalNode;
import top.wolearning.areas.sysManage.services.SysManageService;
import top.wolearning.entity.ErrorEnum;
import top.wolearning.entity.ResultObj;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sysManage")
public class SysManage {

    @Autowired
    private SysManageService sysManageService;

    @RequestMapping(value = "/addNodeToClassificationTree", method = {RequestMethod.POST})
    @ResponseBody
    public ResultObj addNodeToTree(@RequestParam String parentCode, @RequestParam String name) {
        ResultObj resultObj = new ResultObj();
        try {
            // 首先检查有没有相同名字的
            List<ArticalClassification> list = sysManageService.getSameNameNode(parentCode, name);
            if (list.size()>0) {
                resultObj.setCode(ErrorEnum.ERROR_HAS_EXIST.getCode());
                resultObj.setMessage("改节点已经存在，请更换节点名字");
                return resultObj;
            }

            String siblingMaxCode= sysManageService.getMaxSibling(parentCode);
            String code = parentCode;
            if (siblingMaxCode==null) {
                code += "001";
            } else {
                String lastThreeStr = siblingMaxCode.substring(siblingMaxCode.length() - 3);
                Integer nowCode = Integer.parseInt(lastThreeStr) + 1;
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

    @RequestMapping(value="/getAllArticalNode", method={RequestMethod.GET})
    @ResponseBody
    public ResultObj getAllArticalNode() {
        ResultObj resultObj = new ResultObj();
        try {
            List<ArticalClassification> articalClassificationList=sysManageService.getAllNodes();
            ArticalNode dataNode = new ArticalNode();
            dataNode.setTitle("文章分类");
            dataNode.setChildrenKey("000");
            if (!articalClassificationList.isEmpty())
            {
                for(ArticalClassification articalClassification: articalClassificationList) {
                    String wholeCode = articalClassification.getCode();
                    List<ArticalNode> childrenNode = dataNode.getChildren();
                    if (childrenNode==null) {
                        childrenNode = new ArrayList<ArticalNode>();
                        dataNode.setChildren(childrenNode);
                    }
                    for(int i=1;i< wholeCode.length()/3;i++) {
                        String code = wholeCode.substring(0,i*3+3);
                        if (i != wholeCode.length()/3 -1) {
                            Boolean isExist = false;
                            for (ArticalNode n: childrenNode) {
                                if ( n.getChildrenKey().equals(code)) {
                                    if (n.getChildren()==null) {
                                        n.setChildren(new ArrayList<ArticalNode>());
                                    }
                                    childrenNode = n.getChildren();
                                    isExist = true;
                                    break;
                                }
                            }
                            if (!isExist) {
                                ArticalNode newNode = new ArticalNode();
                                newNode.setChildrenKey(code);
                                newNode.setChildren(new ArrayList<ArticalNode>());
                                childrenNode.add(newNode);
                                childrenNode=newNode.getChildren();
                            }
                        } else {
                            // 首先判断有没有节点的相同的key
                            Boolean hasExist = false;
                            for (int m = 0;m < childrenNode.size();m++) {
                                if(childrenNode.get(m).getChildrenKey().equals(code)) {
                                    childrenNode.get(m).setTitle(articalClassification.getName());
                                    hasExist = true;
                                    break;
                                }
                            }
                            if (!hasExist) {
                                ArticalNode newNode = new ArticalNode();
                                newNode.setTitle(articalClassification.getName());
                                newNode.setChildrenKey(articalClassification.getCode());
                                newNode.setChildren(new ArrayList<ArticalNode>());
                                childrenNode.add(newNode);
                            }
                        }
                    }
                }
            }
            resultObj.setCode(ErrorEnum.OK.getCode());
            resultObj.setData(dataNode);
            resultObj.setMessage("获取所有的节点成功");
        } catch (Exception ex) {
            resultObj.setCode(ErrorEnum.ERROR_GET_LIST.getCode());
            resultObj.setData(ex.toString());
            resultObj.setMessage("获取所有节点失败");
        }
        return resultObj;
    }

    @PostMapping(value="deleteArticleNode")
    public ResultObj deleteArticalNode(String code) {
        //首先检查改节点下面是否存在子节点，只有子节点不存在的情况下才可以删除
        ResultObj resultObj = new ResultObj();
        try {
            String maxSibling = sysManageService.getMaxSibling(code);
            if (maxSibling !=null) {
                resultObj.setCode(ErrorEnum.ERROR_HAS_CHILDREN.getCode());
                resultObj.setMessage("改节点存在子节点，请先删除子节点");
            } else {
                sysManageService.deleteArticalNode(code);
                resultObj.setCode(ErrorEnum.OK.getCode());
                resultObj.setMessage("删除节点成功");
            }
        } catch (Exception ex) {
            resultObj.setCode(ErrorEnum.ERROR_UPDATE.getCode());
            resultObj.setMessage("删除节点失败");
            resultObj.setData(ex.toString());
        }
        return resultObj;
    }

    @PostMapping(value="alterNode")
    public ResultObj alterArticalNode(String code, String name) {
        ResultObj resultObj = new ResultObj();
        try {
            sysManageService.modifyArticalNode(code, name);
            resultObj.setCode(ErrorEnum.OK.getCode());
            resultObj.setMessage("修改节点成功");
        } catch (Exception ex) {
            resultObj.setCode(ErrorEnum.ERROR_UPDATE.getCode());
            resultObj.setMessage("修改节点失败");
            resultObj.setData(ex.toString());
        }
        return resultObj;
    }

    @RequestMapping(value="/getChildrenNodes", method={RequestMethod.GET})
    @ResponseBody
    public ResultObj getChildrenNodes(String parentCode) {
        ResultObj resultObj = new ResultObj();
        try {
            List<ArticalClassification> articalClassifications = sysManageService.getChildrenNodes(parentCode);
            resultObj.setCode(ErrorEnum.OK.getCode());
            resultObj.setData(articalClassifications);
            resultObj.setMessage("获取子类成功");
        } catch (Exception ex) {
            resultObj.setCode(ErrorEnum.ERROR_GET_LIST.getCode());
            resultObj.setData(ex.toString());
            resultObj.setMessage("获取子类失败");
        }
        return resultObj;
    }

}
