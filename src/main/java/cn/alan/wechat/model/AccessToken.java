package cn.alan.wechat.model;

/**
 * @author 杨亚龙
 * @date 2020/4/2 0:31
 */
public class AccessToken {

    //成功的token
    private String token;
    //过期时间
    private String expiresTimeout;

    /**
     * @param token     获取到的token
     * @param expiresIn 距离token过期还有多长时间（单位是秒）
     */
    public AccessToken(String token, String expiresIn) {
        this.token = token;
        //计算出token过期时间
        this.expiresTimeout = System.currentTimeMillis() + Integer.parseInt(expiresIn) * 1000 + "";
    }

    /**
     * 判断是否过期
     *
     * @return
     */
    public boolean isExpires() {
        return System.currentTimeMillis() > Long.parseLong(this.expiresTimeout);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpiresTimeout() {
        return expiresTimeout;
    }

    public void setExpiresTimeout(String expiresTimeout) {
        this.expiresTimeout = expiresTimeout;
    }

    @Override
    public String toString() {
        return "AccessToken{" +
                "token='" + token + '\'' +
                ", expiresTimeout='" + expiresTimeout + '\'' +
                '}';
    }
}
