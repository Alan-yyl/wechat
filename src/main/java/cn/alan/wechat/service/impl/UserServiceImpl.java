package cn.alan.wechat.service.impl;

import cn.alan.wechat.model.DistributionCode;
import cn.alan.wechat.model.UserInfo;
import cn.alan.wechat.service.UserService;
import cn.alan.wechat.service.base.BaseServiceImpl;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author 杨亚龙
 * @date 2020/4/9 12:07
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserInfo> implements UserService {
    public  static final int CODE_LENTH=5;

    @Override
    public UserInfo register(Map<String, String> userinfo) {
        //用户openID
        String openID=userinfo.get("FromUserName");
        System.out.println("openID是"+openID);
        //生成distributionCode
        String code=generateDistribution(openID);
        //写入数据库
        if (userMapper.register(openID,code)>0) {
            //插入成功
            return userMapper.findByOpenID(openID);
        }else{
            return null;
        }
    }

    /**
     * 生成邀请码
     * @param openID 用户的openID
     * @param time 用户第几次获取邀请码（用于解决邀请码冲突）
     * @return
     */
    private String generateDistribution(String openID){
        return openID.subSequence(0, CODE_LENTH).toString();
    }

    @Override
    public UserInfo findById(String id) {
        return userMapper.findByOpenID(id);
    }

    @Override
    public UserInfo findById(int id) {
        return null;
    }
}
