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

import javax.persistence.Column;

import com.sandy.ecp.framework.domain.AbstractDateEntity;

/**
 * platform Account center model
 * 
 * @author Sandy
 * @since 1.0.0 04th 12 2018
 */
public class Account extends AbstractDateEntity<Long> {

	private static final long serialVersionUID = -9164029279692125389L;

	@Column(name = "CIRCLE_ID", columnDefinition = "Long", length = 20, precision = 0, nullable = false)
	private Long circleId;
	
	@Column(name = "ROLE_IDS", columnDefinition = "String", length = 32, precision = 0, nullable = false)
	private String roleIds;
	
	@Column(name = "USER_NAME", columnDefinition = "String", length = 32, precision = 0, nullable = false)
	private String userName;
	/**
	 * 性别 0：未知、1：男、2：女
	 */
	@Column(name = "GENDER", columnDefinition = "TINYINT", length = 32, precision = 0, nullable = false)
	private Integer	gender = 0;
	
	@Column(name = "MOBILE", columnDefinition = "String", length = 32, precision = 0, nullable = false)
	private String mobile;
	
	@Column(name = "NICK_NAME", columnDefinition = "String", length = 32, precision = 0, nullable = false)
	private String nickName;
	
	@Column(name = "HEAD_PORTRAIT", columnDefinition = "String", length = 200, precision = 0, nullable = false)
	private String headPortrait;
	
	@Column(name = "EMAIL", columnDefinition = "String", length = 32, precision = 0, nullable = false)
	private String email;
	
	@Column(name = "PASSWORD", columnDefinition = "String", length = 100, precision = 0, nullable = false)
	private String password;
	
	@Column(name = "IS_LOCKED", columnDefinition = "BIT", length = 20, precision = 0, nullable = false)
	private Boolean islocked;
	
	private List<Role> roles;
	
	public Long getCircleId() {
		return circleId;
	}
	public void setCircleId(Long circleId) {
		this.circleId = circleId;
	}
	public String getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getIslocked() {
		return islocked;
	}
	public void setIslocked(Boolean islocked) {
		this.islocked = islocked;
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
		buffer.append(", userName=").append(userName);
		buffer.append(", gender=").append(gender);
		buffer.append(", mobile=").append(mobile);
		buffer.append(", password=").append(password);
		buffer.append(", isLocked=").append(islocked);
		buffer.append(", createdId=").append(getCreatedId());
		buffer.append(", createdTime=").append(getCreatedTime());
		buffer.append(", updatedId=").append(getUpdatedId());
		buffer.append(", updatedTime=").append(getUpdatedTime());
		buffer.append("]");
		return buffer.toString();
	}
}
