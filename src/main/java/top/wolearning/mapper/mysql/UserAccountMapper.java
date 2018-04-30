package top.wolearning.mapper.mysql;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;
import top.wolearning.entity.UserAccount;

public interface UserAccountMapper {
    int deleteByPrimaryKey(@RequestParam String refid);

    int insert(UserAccount record);

    int insertSelective(UserAccount record);

    UserAccount selectByPrimaryKey(@RequestParam String refid);

    UserAccount selectByPrimaryKey(UserAccount account);

    int updateByPrimaryKeySelective(UserAccount record);

    int updateByPrimaryKey(UserAccount record);

    UserAccount selectByNameAndPassword(UserAccount record);
}