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

package com.sandy.user.center.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandy.ecp.mybatis.service.AbstractService;
import com.sandy.user.center.domain.User;
import com.sandy.user.center.mapper.UserMapper;
import com.sandy.user.center.repository.UserRepository;
import com.sandy.user.center.transfer.UserTransfer;
import com.sandy.user.center.vo.UserVO;
/**
 * user center account service.
 * @author Sandy
 * @since 04th 12 2018 
 */
@Service
public class UserService extends AbstractService<UserMapper, User, Long> {

	@Autowired(required = false)
	private UserMapper userMapper;
	
	@Autowired(required = false)
	public UserRepository userRepository;
	@Autowired(required = false)
	private UserTransfer userTransfer;
	
	public UserVO queryByGId(Long id) {
		if(null ==id) {
			return null;
		}
		return userTransfer.toVO(userMapper.selectById(id));
	}
	
	public List<User> queryList() {
		List<User> list = new ArrayList<>();
		User account = userMapper.selectById(Long.MAX_VALUE);
		list.add(account);
		return list;
	}
}
