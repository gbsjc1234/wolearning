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

    @Override
    public int deleteAccount(String refid) {
        return userAccountMapper.deleteByPrimaryKey(refid);
    }

    @Override
    public int insertSelective(UserAccount record) {
        return userAccountMapper.insertSelective(record);
    }

    @Override
    public UserAccount getAccountByPrimaryKey(String primaryKey) {
        return userAccountMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public int updateByPrimaryKeySelective(UserAccount record) {
            return userAccountMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserAccount record) {
        return userAccountMapper.updateByPrimaryKey(record);
    }

    @Override
    public int insertAccount(UserAccount record) {
        return userAccountMapper.insert(record);
    }


}
