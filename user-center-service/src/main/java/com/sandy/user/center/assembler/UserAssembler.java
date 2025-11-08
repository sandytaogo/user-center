/*
 * Copyright 2018-2030 the original author or authors.
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
package com.sandy.user.center.assembler;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.sandy.user.center.domain.User;
import com.sandy.user.center.vo.UserVO;
/**
 * extends Converter<UserVO, User>
 */
@Mapper(componentModel = "spring")
public interface UserAssembler {
	
	UserAssembler INSTANCE = Mappers.getMapper(UserAssembler.class);
	
	@Mapping(source = "mobile", target = "mobile")
	@Mapping(source = "nickName", target = "nickName")
	UserVO userToUserDto(User po);
	
	@Mapping(source = "mobile", target = "mobile")
	@Mapping(source = "nickName", target = "nickName")
	User userToUserPo(UserVO vo);
	
	@Mapping(source = "mobile", target = "mobile")
	@Mapping(source = "nickName", target = "nickName")
	UserVO toVo(User po);
}
