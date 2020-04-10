package cn.alan.wechat.model;

/**
 * @author 杨亚龙
 * @date 2020/4/9 12:10
 */
public class UserInfo {
    private Integer ID;
    private String openID;
    private String distributionCode;

    public UserInfo(Integer ID, String openID, String distributionCode) {
        this.ID = ID;
        this.openID = openID;
        this.distributionCode = distributionCode;
    }

    public UserInfo(String openID) {
        this.openID = openID;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getOpenID() {
        return openID;
    }

    public void setOpenID(String openID) {
        this.openID = openID;
    }

    public String getDistributionCode() {
        return distributionCode;
    }

    public void setDistributionCode(String distributionCode) {
        this.distributionCode = distributionCode;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "ID='" + ID + '\'' +
                ", openID='" + openID + '\'' +
                ", distributionCode='" + distributionCode + '\'' +
                '}';
    }
}
