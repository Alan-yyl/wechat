package cn.alan.wechat.service;

import cn.alan.wechat.model.UserInfo;
import cn.alan.wechat.service.base.BaseService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author 杨亚龙
 * @date 2020/4/9 11:50
 */
public interface UserService extends BaseService<UserInfo> {
    UserInfo register(Map<String,String> userinfo);
}
