package top.wolearning.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wolearning.entity.UserAccount;
import top.wolearning.mapper.mysql.UserAccountMapper;



@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountMapper userAccountMapper;
    @Override
    public UserAccount getAccount(String userName, String password) {
        UserAccount acc=new  UserAccount();
        acc.setName(userName);
        acc.setPassword(password);
        return userAccountMapper.selectByNameAndPassword(acc);
    }
}
