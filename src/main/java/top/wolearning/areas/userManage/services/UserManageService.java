package top.wolearning.areas.userManage.services;

import top.wolearning.areas.userManage.entity.UserQueryConditions;
import top.wolearning.areas.userManage.entity.UserUpdate;
import top.wolearning.entity.UserAccount;

import java.util.List;

public interface UserManageService {
    List<UserAccount> queryUsers(UserQueryConditions uqc);

    int deleteByName(String name);

    int selectTotalNumber(UserQueryConditions uqc);

    int updateUserAccount(UserUpdate userUpdate);
}
