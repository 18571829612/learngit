package org.aisino.erp.filter;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 过滤器
 * 
 * @author XZY 2017-3-13-上午11:53:02
 */
public class AccessFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		// 更具url 判断 请求权限 规则如下
		String fw_url = request.getRequestURI();

		log.info(String.format("%s request to %s", request.getMethod(), request
				.getRequestURL().toString()));

		/**
		 * 根据URL实现url级权限控制 
		 * 付款回调可通过网关验证 /paycallback 
		 * 付款确认可通过网关验证 /affirm.do
		 * 微信公众号支付通过网关验证/wx/paywxjs 
		 * 查询订单通过网关验证/querypay 
		 * 条码支付通过网关验证/pay_barcode
		 */
		if (fw_url != null
				&& (fw_url.indexOf("/paycallback") > -1
						|| fw_url.indexOf("/affirm.do") > -1 
						|| fw_url.indexOf("/wx/paywxjs") > -1
						|| fw_url.indexOf("/querypay") > -1
						|| fw_url.indexOf("/pay_barcode") > -1)) {
		}else{
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			return null;
		}

		/**
		 * 验证资源 accessToken
		 */
		/*
		 * Object accessToken = request.getParameter("accessToken");
		 * Map<String,TokenInfo> tm = TokenManager.tokenMap(); if
		 * (tm.get(accessToken) == null) { log.warn("access token is empty");
		 * ctx.setSendZuulResponse(false); ctx.setResponseStatusCode(401);
		 * return null; }
		 */

		log.info("access token ok");
		return null;
	}

}
