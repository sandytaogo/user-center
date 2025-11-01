/*
 * Copyright 2023-2035 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.company.com/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sandy.user.center.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * 服务资源访问控制配置.
 * @author Sandy
 * @since 1.0.0 16th 07 2025
 */
@Configuration
@EnableResourceServer // 标识是资源服务
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()//禁用了csrf（跨站请求伪造）功能
            .authorizeRequests()//限定签名成功的请求
            //必须认证过后才可以访问;注意：hasAnyRole 会默认加上ROLE_前缀，而hasAuthority不会加前缀
            .antMatchers("/decision/**","/govern/**").hasAnyRole("user") // 在角色过滤的时候需要注意user角色需要加角色前缀
            .antMatchers("/admin/**").hasRole("admin")
            .antMatchers("/test/**").authenticated()
            // 免验证请求
            .antMatchers("/oauth/**").permitAll();
    }

}
