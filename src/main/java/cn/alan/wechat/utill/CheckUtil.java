package cn.alan.wechat.utill;

import java.util.Arrays;

/**
 * @auther 杨亚龙
 * @date 2020/3/22 1:18
 */
public class CheckUtil {
    //根据自己设定token进行修改（非常重要）
    private static final String token = "alan";
    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        String[] str = new String[]{token, timestamp, nonce};
        //排序
        Arrays.sort(str);
        //拼接字符串
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            buffer.append(str[i]);
        }
        //进行sha1加密
        String temp = SHA1.encode(buffer.toString());
        //与微信提供的signature进行匹对
        return signature.equals(temp);
    }
}

