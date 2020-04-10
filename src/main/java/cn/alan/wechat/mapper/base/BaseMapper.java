package cn.alan.wechat.mapper.base;

/**
 * @author 杨亚龙
 * @date 2020/4/9 12:33
 */
public interface BaseMapper<T> {
    T findByOpenID(String openID);
    T findByID(int id);
}
