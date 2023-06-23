package com.khube.crm.enquiry.main.load.balancer;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

import com.khube.crm.enquiry.main.load.balancer.custom.ProductServiceCustomLoadBalancerConfiguration;

import feign.Feign;

@LoadBalancerClient(value = "PRODUCT-SERVICE",
					configuration = ProductServiceCustomLoadBalancerConfiguration.class)
public class ProductServiceLoadBalancer {

	@LoadBalanced
	@Bean
	public Feign.Builder findBuilder(){
		return Feign.builder();
	}
}
