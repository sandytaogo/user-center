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

import java.util.List;

import com.sandy.ecp.framework.domain.AbstractDateEntity;

/**
 * platform Account center model
 * 
 * @author Sandy
 * @since 1.0.0 04th 12 2018
 */
public class Account extends AbstractDateEntity<Long> {

	private static final long serialVersionUID = -9164029279692125389L;

	private String account;
	private String mobile;
	private String password;
	private Boolean isLock;
	
	private List<Role> roles;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getIsLock() {
		return isLock;
	}
	public void setIsLock(Boolean isLock) {
		this.isLock = isLock;
	}
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder(200);
		buffer.append(getClass().getName());
		buffer.append(" [id").append(getId());
		
		buffer.append(", account=").append(account);
		buffer.append(", mobile=").append(mobile);
		buffer.append(", password=").append(password);
		buffer.append(", isLock=").append(isLock);
		
		buffer.append(", createdId=").append(getCreatedId());
		buffer.append(", createdTime=").append(getCreatedTime());
		buffer.append(", updatedId=").append(getUpdatedId());
		buffer.append(", updatedTime=").append(getUpdatedTime());
		buffer.append("]");
		return buffer.toString();
	}
}
