/*
 * Copyright 2025-2035 the original author or authors.
 *
 * Licensed under the company License, Version 2.0 (the "License");
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
package com.sandy.user.center.dto;

import com.sandy.ecp.framework.vo.AbstractVO;

/**
 * 用户权限 data transfer object.
 * @author sandy. 
 * @since 1.0.0 2025-11-04 12:12:12
 */
public class UserPermissionDto extends AbstractVO<Long> {
	
	private static final long serialVersionUID = -5776380958785136678L;

	private Long userId;
	
	/**
	 * 执行（Execute）权限‌：对应数字1
	‌ * 写（Write）权限‌：对应数字2
	 * 执行,写（Execute, Write）3
	‌ * 读（Read）权限‌：对应数字4
	 * 执行，读（Execute，Read）权限‌：对应数字5
	 * 执行，写（Execute，Write）权限‌：对应数字6
	 * 执行，写, 读（Execute，Write，Read）权限‌：对应数字7
	 */
	private Integer permission;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getPermission() {
		return permission;
	}

	public void setPermission(Integer permission) {
		this.permission = permission;
	}
	
}
