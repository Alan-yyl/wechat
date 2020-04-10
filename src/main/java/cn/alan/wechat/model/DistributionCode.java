package cn.alan.wechat.model;

/**
 * @author 杨亚龙
 * @date 2020/4/9 12:22
 */
public class DistributionCode {
    private String code;
    private int time;

    public DistributionCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "DistributionCode{" +
                "code='" + code + '\'' +
                ", time=" + time +
                '}';
    }
}
