package cn.alan.wechat.service.base;

/**
 * @author 杨亚龙
 * @date 2019/11/4 16:46
 */
public interface BaseService<T> {
    T findById(String id);
    T findById(int id);
}
