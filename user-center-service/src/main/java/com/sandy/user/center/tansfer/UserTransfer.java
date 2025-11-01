/*
 * Copyright 2023-2035 the original author or authors.
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
package com.sandy.user.center.tansfer;

import org.springframework.beans.BeanUtils;

import com.sandy.ecp.framework.model.AbstractObjectTransfer;
import com.sandy.user.center.vo.UserVO;
import com.sandy.user.center.domain.User;

public class UserTransfer extends AbstractObjectTransfer<UserVO, User, Long> {

	@Override
	public User toPO(UserVO vo) {
		if(null == vo) {
			return null;
		}
		User po = new User();
		BeanUtils.copyProperties(vo, po);
		return po;
	}

	@Override
	public UserVO toVO(User po) {
		if(null == po) {
			return null;
		}
		UserVO vo = new UserVO();
		BeanUtils.copyProperties(po, vo);
		return vo;
	}
	
}
