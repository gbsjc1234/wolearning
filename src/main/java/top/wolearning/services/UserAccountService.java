package top.wolearning.services;

import top.wolearning.entity.UserAccount;

public interface UserAccountService {
    UserAccount getAccount(String userName, String password);

    UserAccount getAccountByPrimaryKey(String primaryKey);

    int insertAccount(UserAccount record);

    int insertSelective(UserAccount record);

    int deleteAccount(String refid);

    int updateByPrimaryKeySelective(UserAccount record);

    int updateByPrimaryKey(UserAccount record);
}
