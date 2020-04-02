package cn.alan.wechat;

import cn.alan.wechat.Service.WxService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WechatApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void getToken(){
		System.out.println(WxService.getAccessToken());
	}
}
