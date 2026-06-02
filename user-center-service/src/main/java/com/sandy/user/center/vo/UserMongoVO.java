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
package com.sandy.user.center.vo;

import com.sandy.ecp.framework.vo.AbstractVO;

/**
 * user center account view object.
 * 
 * @author Sandy
 * @since 1.0.0 04th 12 2018
 */
public class UserMongoVO extends AbstractVO<String> {

	private static final long serialVersionUID = 3042987892717402645L;

	private String userName;
	private String nickName;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}
