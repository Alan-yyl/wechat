package cn.alan.wechat;

import cn.alan.wechat.mapper.UserMapper;
import cn.alan.wechat.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WechatApplicationTests {
	@Autowired
	UserMapper userMapper;

	@Test
	void contextLoads() {
	}

	@Test
	public void getToken(){
		// System.out.println(WxService.getAccessToken());
	}

	@Test
	public void insertUser(){
		int line=userMapper.register("12345687","1909");
		System.out.println(line);
	}
    @Test
    public void findUser(){
        UserInfo userInfo=userMapper.findByOpenID("12345687");
        System.out.println(userInfo);
    }
}
