/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sandy.user.center.startup;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.jdbc.DataSourceHealthIndicatorAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.solace.labs.spring.boot.autoconfigure.SolaceJmsAutoConfiguration;
import com.solace.spring.boot.autoconfigure.SolaceJmsAutoCloudConfiguration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * application startup This example 
 * uses the Spring Cloud {@code DiscoveryClient } abstraction to list all services
 * available to the application. It should deployed to a Cloud consul organization and space that
 * has other applications deployed to it.
 * 
 * @author Sandy
 * @since 1.0.0 04th 12 2018
 */
@SpringBootApplication(
	exclude = {
		SolaceJmsAutoConfiguration.class,
		SolaceJmsAutoCloudConfiguration.class,
	})
@EnableHystrix
@EnableSwagger2
@EnableDiscoveryClient
@EnableAutoConfiguration(
	exclude = {
		DataSourceHealthIndicatorAutoConfiguration.class,
	}
)
@EnableTransactionManagement
@ComponentScan(basePackages = {
	"com.sandy.user.center.config",
	"com.sandy.user.center.controller",
	"com.sandy.user.center.service",
	"com.sandy.user.center.transfer",
	"com.sandy.user.center.assembler",
	"com.sandy.user.center.repository"
})
@MapperScan({"com.sandy.user.center.mapper"})
//@EnableJpaRepositories(basePackages = {
//		"com.sandy.user",
//		"org.flowable",
//})
@EntityScan(basePackages = {
		"com.sandy.user.center",
		"org.flowable",
		"com.sandy.workflow",
})
@PropertySource("classpath:jdbc.properties")
public class UserCenterApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		//org.mongodb.driver.connection tretre = null;
		return super.configure(builder);
	}
	
    public static void main(String[] args) {
        SpringApplication.run(UserCenterApplication.class, args);
    }
}