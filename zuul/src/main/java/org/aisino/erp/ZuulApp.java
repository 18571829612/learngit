package org.aisino.erp;

import org.aisino.erp.filter.AccessFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * 服务网关
 * 
 * @author XZY 2017-2-17-下午1:38:29
 */
//这里用了 @SpringCloudApplication 注解，之前没有提过，通过源码我们看到，它整合了 @SpringBootApplication 、 @EnableDiscoveryClient 、 @EnableCircuitBreaker
@SpringCloudApplication
@EnableZuulProxy
public class ZuulApp {
	public static void main(String[] args) {
		new SpringApplicationBuilder(ZuulApp.class).web(true).run(args);
	}
	
	@Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
	
}
