package top.wolearning.areas.userManage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wolearning.areas.userManage.entity.UserQueryConditions;
import top.wolearning.areas.userManage.entity.UserUpdate;
import top.wolearning.areas.userManage.services.UserManageService;
import top.wolearning.entity.ResultObj;
import top.wolearning.entity.UserAccount;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userManage")
public class UserManage {
    @Autowired
    private UserManageService userManageService;

    @GetMapping(value = {"/getAllUserAccount", "/findUserByCondition"})
    public ResultObj getAllUserAccount(UserQueryConditions uqc) {
        ResultObj resultObj = new ResultObj();
        List<UserAccount> list = null;
        int total = 0;
        try {
            list = userManageService.queryUsers(uqc);
            total = userManageService.selectTotalNumber(uqc);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("total", total);
            map.put("userInfo", list);
            resultObj.setData(map);
            resultObj.setMessage("查询成功");
            resultObj.setCode(0);
        } catch (Exception ex) {
            resultObj.setCode(1);
            resultObj.setMessage("查询异常");
            resultObj.setData(ex.getMessage());
        }
        return resultObj;
    }

    @GetMapping("/deleteUserAccountByName")
    public ResultObj deleteUserAccountByName(String name) {
        ResultObj resultObj = new ResultObj();
        try {
            resultObj.setData(userManageService.deleteByName(name));
            resultObj.setMessage("删除成功");
            resultObj.setCode(0);
        } catch (Exception ex) {
            resultObj.setCode(1);
            resultObj.setMessage("删除异常");
            resultObj.setData(ex.getMessage());
        }
        return resultObj;
    }

    @PostMapping("/updateUserAccountByName")
    public ResultObj updateUserAccountByName(UserUpdate userUpdate) {
       ResultObj resultObj = new ResultObj();
       try {
           userUpdate.setModifyTime(new Date(System.currentTimeMillis()));
           resultObj.setData(userManageService.updateUserAccount(userUpdate));
           resultObj.setCode(0);
           resultObj.setMessage("更新成功");
       } catch (Exception ex) {
           resultObj.setCode(1);
           resultObj.setMessage("更新异常");
           resultObj.setData(ex.getMessage());
       }
       return resultObj;
    }
}
