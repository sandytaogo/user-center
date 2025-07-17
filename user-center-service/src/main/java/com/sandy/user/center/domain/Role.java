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

import org.springframework.security.core.GrantedAuthority;

import com.sandy.ecp.framework.domain.AbstractDateEntity;

/**
 * platform Account center role model
 * 
 * @author Sandy
 * @since 1.0.0 04th 12 2018
 */
public class Role extends AbstractDateEntity<Long> implements GrantedAuthority {
	
	private static final long serialVersionUID = -8046597114900007830L;
	/**
	 * 角色名称.
	 */
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getAuthority() {
		return null;
	}
}
