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
package com.sandy.user.center.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * platform security user center [user details] model
 * 
 * @author Sandy
 * @since 1.0.0 04th 12 2018
 */
public class AuthUserInfo extends User {
	
	
	private static final long serialVersionUID = 4342088446121743948L;

	/**
	 * Calls the more complex constructor with all boolean arguments set to {@code true}.
	 */
	public AuthUserInfo(String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this(username, password, true, true, true, true, authorities);
	}
	
	public AuthUserInfo(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}
}
