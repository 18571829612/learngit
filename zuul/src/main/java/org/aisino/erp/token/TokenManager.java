package org.aisino.erp.token;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;



/**
 * Token 管理器
 * @author XZY
 * 2017-2-18-下午1:47:27
 */
@Service
public class TokenManager {
	
	/**
	 * 获取token集合
	 * @return
	 */
	public static Map<String,TokenInfo> tokenMap(){
		Map<String,TokenInfo> tm = new HashMap<String, TokenInfo>();
		
		TokenInfo t = new TokenInfo();
		String access_token = "123456";
		t.setAccess_token(access_token);
		t.setExpires_in(7200);
		tm.put(access_token, t);
		
		return tm;
	}
	
}
