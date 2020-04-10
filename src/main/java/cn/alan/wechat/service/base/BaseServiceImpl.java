package cn.alan.wechat.service.base;

import cn.alan.wechat.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 统一管理mapper
 * @author 杨亚龙
 * @date 2020/4/9 12:45
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
    @Autowired
    protected UserMapper userMapper;
}
