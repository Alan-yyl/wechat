package cn.alan.wechat.mapper;

import cn.alan.wechat.mapper.base.BaseMapper;
import cn.alan.wechat.model.UserInfo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author 杨亚龙
 * @date 2020/4/9 12:37
 */
public interface UserMapper extends BaseMapper<UserInfo> {
    //注册
    int register(@Param("openID") String openID, @Param("distributionCode") String distributionCode);
    //根据openID查找用户信息

    @Override
    UserInfo findByOpenID(String openID);
}
