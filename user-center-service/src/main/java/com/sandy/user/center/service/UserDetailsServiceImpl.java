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
package com.sandy.user.center.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sandy.user.center.domain.Account;
import com.sandy.user.center.domain.AuthUserInfo;
import com.sandy.user.center.mapper.AccountMapper;

/**
 * implements spring framework UserDetailsService.
 * @author Sandy
 * @since 16th 07 2025
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private AccountMapper accountMapper;
	
	public UserDetailsServiceImpl() {
		super();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (StringUtils.isEmpty(username)) {
            throw new UsernameNotFoundException("用户名不能为空!");
        }
		Account user = accountMapper.selectByMobile(username);
		if (user == null) {
			user = accountMapper.selectByAccount(username);
		}
		// 如果用户不存在则认证失败
        if(user == null) {
        	throw new UsernameNotFoundException("账号或密码错误!");
        }
		return new AuthUserInfo("test", "test", user.getRoles());
	}
}
