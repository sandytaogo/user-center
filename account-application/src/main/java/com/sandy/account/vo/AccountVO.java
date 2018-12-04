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

package com.sandy.account.vo;

/**
 * account view object
 * 
 * @author Sandy
 * @since 04th 12 2018
 */
public class AccountVO {

	private Long id;
	private String mobile;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder(80);
		buffer.append(getClass().getName());
		buffer.append(" [id").append(getId());
		buffer.append(" ,mobile").append(mobile);
		buffer.append("]");
		return buffer.toString();
	}
	
}
