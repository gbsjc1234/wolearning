package top.wolearning.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.wolearning.entity.ErrorEnum;
import top.wolearning.entity.ResultObj;
import top.wolearning.entity.UserAccount;
import top.wolearning.services.UserAccountService;
import top.wolearning.utils.EncodeAndUUID;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

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
        UserAccount acc = null;
        try{
            password = EncodeAndUUID.encodeMD5Hex(password);
            acc = userAccountService.getAccount(username, password);
        } catch(Exception ex) {
            String errorInfo = "获取用户信息失败";
            System.out.print(errorInfo);
            resultObj.setCode(-1);
            resultObj.setMessage(errorInfo);
            resultObj.setData(ex.toString());
        }
        if(acc != null) {
            resultObj.setCode(0);
            resultObj.setMessage("获取用户信息成功");
            resultObj.setData(acc);
        } else {
            String errorInfo = "用户名或密码错误";
            System.out.print(errorInfo);
            resultObj.setCode(-1);
            resultObj.setMessage("获取用户信息失败");
            resultObj.setData(errorInfo);
        }

        return resultObj;
    }

    @GetMapping("/deleteUserAccount")
    public ResultObj deleteUserAccount(String refid) {
        ResultObj resultObj = new ResultObj();
        int flag = -1;
        try {
            flag = userAccountService.deleteAccount(refid);

        } catch(Exception ex) {
            String errorInfo = "删除用户失败";
            System.out.println(errorInfo);
            resultObj.setCode(-1);
            resultObj.setMessage(errorInfo);
            resultObj.setData(ex.toString());
        }

        if (flag > 0) {
            resultObj.setCode(0);
            resultObj.setMessage("删除用户成功");
            resultObj.setData(flag);
        } else {
            String errorInfo = "删除条件有误";
            System.out.println(errorInfo);
            resultObj.setCode(-1);
            resultObj.setMessage("删除和用户失败");
            resultObj.setData(errorInfo);
        }

        return resultObj;
    }

    @PostMapping("/insertSelective")
    public ResultObj insertSelective(UserAccount userAccount) {
        ResultObj resultObj = new ResultObj();
        int flag = -1;
        try {
            userAccount.setRefid(EncodeAndUUID.getUUID());
            userAccount.setCreateTime(new Timestamp(System.currentTimeMillis()));
            if(userAccount.getPassword() != null) {
                userAccount.setPassword(EncodeAndUUID.encodeMD5Hex(userAccount.getPassword()));
            }
            flag = userAccountService.insertSelective(userAccount);

        } catch (Exception ex) {
            String errorInfo = "插入用户失败";
            System.out.println(errorInfo);
            resultObj.setCode(-1);
            resultObj.setMessage(errorInfo);
            resultObj.setData(ex.toString());
        }
        if (flag > 0) {
            resultObj.setCode(0);
            resultObj.setMessage("插入用户成功");
            resultObj.setData(flag);
        } else {
            String errorInfo = "插入条件有误";
            System.out.println(errorInfo);
            resultObj.setCode(-1);
            resultObj.setMessage("插入失败");
            resultObj.setData(errorInfo);
        }

        return resultObj;
    }

    @GetMapping("/getAccountByPK")
    public ResultObj getAccountByPK(String primaryKey) {
        ResultObj resultObj = new ResultObj();
        UserAccount userAccount = null;
        try {
            userAccount = userAccountService.getAccountByPrimaryKey(primaryKey);
        } catch (Exception ex) {
            String errorInfo = "获取用户信息失败";
            System.out.println(errorInfo);
            resultObj.setCode(-1);
            resultObj.setMessage(errorInfo);
            resultObj.setData(ex.toString());
        }

        if(userAccount != null) {
            resultObj.setCode(0);
            resultObj.setData(userAccount);
            resultObj.setMessage("获取用户信息成功");
        }else {
            String errorInfo = "无效的查找条件";
            resultObj.setMessage("获取用户信息失败");
            resultObj.setCode(-1);
            resultObj.setData(errorInfo);
        }

        return resultObj;
    }

    @PostMapping("/updateByPKSelective")
    public ResultObj updateByPKSelective(UserAccount userAccount) {
        ResultObj resultObj = new ResultObj();
        int flag= -1;
        try {
            if(userAccount.getPassword() != null) {
                userAccount.setPassword(EncodeAndUUID.encodeMD5Hex(userAccount.getPassword()));
            }
            flag = userAccountService.updateByPrimaryKeySelective(userAccount);
        } catch (Exception ex) {
            String errorInfo = "更新用户信息失败";
            System.out.println(errorInfo);
            resultObj.setCode(-1);
            resultObj.setMessage(errorInfo);
            resultObj.setData(ex.toString());
        }
        if (flag > 0) {
            resultObj.setCode(0);
            resultObj.setMessage("更新用户信息成功");
            resultObj.setData(flag);
        } else {
            String errorInfo = "更新用户条件有误";
            System.out.println(errorInfo);
            resultObj.setCode(-1);
            resultObj.setMessage("更新用户失败");
            resultObj.setData(errorInfo);
        }

        return resultObj;
    }

    @PostMapping("/updateByPK")
    public ResultObj updateByPrimaryKey(UserAccount userAccount) {
        System.out.println(userAccount.toString());
        ResultObj resultObj = new ResultObj();
        int flag = -1;
        try {
            userAccount.setPassword(EncodeAndUUID.encodeMD5Hex(userAccount.getPassword()));
            userAccount.setCreateTime(new Timestamp(System.currentTimeMillis()));
            flag = userAccountService.updateByPrimaryKey(userAccount);
        } catch (Exception ex) {
            String errorInfo = "更新用户信息失败~";
            System.out.println(errorInfo);
            resultObj.setCode(-1);
            resultObj.setMessage(errorInfo);
            resultObj.setData(ex.toString());
        }

        if (flag > 0) {
            resultObj.setCode(0);
            resultObj.setMessage("更新用户的信息成功~");
            resultObj.setData(flag);
        } else {
            String errorInfo = "更新用户信息有误~";
            System.out.println(errorInfo);
            resultObj.setCode(-1);
            resultObj.setMessage("更新用户失败");
            resultObj.setData(errorInfo);
        }
        return resultObj;
    }

    @PostMapping("/insertAccount")
    public ResultObj insertAccount(UserAccount userAccount) {
        ResultObj resultObj = new ResultObj();
        int flag = -1;
        try {
            userAccount.setRefid(EncodeAndUUID.getUUID());
            userAccount.setPassword(EncodeAndUUID.encodeMD5Hex(userAccount.getPassword()));
            userAccount.setCreateTime(new Timestamp(System.currentTimeMillis()));
            flag = userAccountService.insertAccount(userAccount);
        } catch (Exception ex) {
            String errorInfo = "用户插入失败";
            System.out.println(errorInfo);
            resultObj.setCode(-1);
            resultObj.setMessage(errorInfo);
            resultObj.setData(ex.toString());
        }
        if (flag > 0) {
            resultObj.setCode(0);
            resultObj.setMessage("用户插入成功");
            resultObj.setData(flag);
        } else {
            String errorInfo = "用户插入有误";
            System.out.println(errorInfo);
            resultObj.setCode(-1);
            resultObj.setMessage("插入失败");
            resultObj.setData(errorInfo);
        }

        return resultObj;
    }

    @PostMapping("/login")
    public ResultObj login(String username, String password) {
        ResultObj resultObj = new ResultObj();
        if (username.equals("admin") && password.equals("111111")) {
            String token = Jwts.builder().setSubject("admin")
                    .setExpiration(new Date(System.currentTimeMillis()+ 30*60*1000))
                    .signWith(SignatureAlgorithm.HS512, "JWTSecret").compact();
            resultObj.setCode(ErrorEnum.OK.getCode());
            Map<String,String> dataMap = new HashMap<String,String>();
            dataMap.put("token", token);
            resultObj.setData(dataMap);
            resultObj.setMessage("token");
        } else {
            resultObj.setCode(ErrorEnum.ERROR_GET_LIST.getCode());
            resultObj.setMessage("登陆失败");
        }
        return resultObj;
    }
}
