package top.wolearning.services;

import top.wolearning.entity.UserAccount;

public interface UserAccountService {
    UserAccount getAccount(String userName, String password);
}
