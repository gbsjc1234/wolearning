package top.wolearning.areas.userManage.mapper.mysql;

import org.apache.ibatis.session.RowBounds;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RestController;
import top.wolearning.areas.userManage.entity.UserQueryConditions;
import top.wolearning.areas.userManage.entity.UserUpdate;
import top.wolearning.entity.UserAccount;

import java.util.List;

@RestController
public interface UserQueryMapper {
    List<UserAccount> select_by_condition(@Param("conditions") UserQueryConditions uqc, RowBounds rowBounds);

    int select_total_number(UserQueryConditions uqc);

    int delete_by_name(String name);

    int update_user_account(UserUpdate userUpdate);
}
