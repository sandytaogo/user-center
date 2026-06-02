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
package com.sandy.user.center.service;

import java.util.List;

import com.sandy.user.center.dto.AuthorizePlatformDto;
import com.sandy.user.center.dto.UserDto;

/**
 * 用户个人信息.
 * @author Sandy
 * @since 1.0.0 2025-11-04 12:12:12
 */
public interface IUserService {

	/**
	 * 获取用户个人信息.
	 * @param id
	 * @return UserDto
	 */
	UserDto getUserById(Long id);
	
	/**
	 * 获取用户授权平台.
	 * @param userId
	 * @return List<AuthorizePlatformDto>
	 */
	List<AuthorizePlatformDto> getAuthorizePlatformListByUserId(Long userId);
}
