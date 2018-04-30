package top.wolearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wolearning.entity.ResultObj;
import top.wolearning.entity.UserAccount;
import top.wolearning.services.UserAccountService;

@RestController
@RequestMapping("/userAccount")
public class AccountController {

    @Autowired
    UserAccountService userAccountService;

    @GetMapping("/helloworld")
    public String helloworld() {
        return "dsakfajs";
    }

    @GetMapping("/getUserAccount")
    public ResultObj getUserAccount(String username, String password){
        ResultObj resultObj = new ResultObj();
        try{
            UserAccount acc= userAccountService.getAccount(username,password);
            resultObj.setCode(0);
            resultObj.setMessage("获取用户信息成功");
            resultObj.setData(acc);
        } catch(Exception ex) {
            String errorInfo = "获取用户信息失败";
            System.out.print(errorInfo);
            resultObj.setCode(-1);
            resultObj.setMessage(errorInfo);
            resultObj.setData(ex.toString());
        }
        return resultObj;
    }
}
