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

package com.sandy.account.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * application startup This example uses the Spring Cloud {@code DiscoveryClient } abstraction to list all services
 * available to the application. It should deployed to a Cloud consul organization and space that
 * has other applications deployed to it.
 * 
 * @author Sandy
 * @since 04th 12 2018
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableTransactionManagement
@ComponentScan(basePackages = {
	"com.sandy.account.config" ,
	"com.sandy.account.controller",
	"com.sandy.account.service",
	"com.sandy.account.repository"
})
@PropertySource("classpath:jdbc.properties")
public class AccountApplication {
	
    public static void main(String[] args){
        SpringApplication.run(AccountApplication.class, args);
    }
}