package top.wolearning.areas.userManage.services;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wolearning.areas.userManage.entity.UserQueryConditions;
import top.wolearning.areas.userManage.entity.UserUpdate;
import top.wolearning.areas.userManage.mapper.mysql.UserQueryMapper;
import top.wolearning.entity.UserAccount;

import java.util.List;

@Service
public class UserManageServiceImpl implements UserManageService {
    @Autowired
    private UserQueryMapper userQueryMapper;

    @Override
    public int updateUserAccount(UserUpdate userUpdate) {
        return userQueryMapper.update_user_account(userUpdate);
    }

    @Override
    public List<UserAccount> queryUsers(UserQueryConditions uqc) {
        RowBounds rowBounds = new RowBounds(uqc.getPageIndex() - 1, uqc.getPageSize() - 1);
        return userQueryMapper.select_by_condition(uqc, rowBounds);
    }

    @Override
    public int selectTotalNumber(UserQueryConditions uqc) {
        return userQueryMapper.select_total_number(uqc);
    }

    @Override
    public int deleteByName(String name) {
        return userQueryMapper.delete_by_name(name);
    }
}
