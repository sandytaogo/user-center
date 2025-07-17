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

import com.sandy.ecp.framework.domain.AbstractDateEntity;


/**
 * platform User Permission model
 * 
 * 执行（Execute）权限‌：对应数字1
‌ * 写（Write）权限‌：对应数字2
 * 执行,写（Execute, Write）3
‌ * 读（Read）权限‌：对应数字4
 * 执行，读（Execute，Read）权限‌：对应数字5
 * 执行，写（Execute，Write）权限‌：对应数字6
 * 执行，写, 读（Execute，Write，Read）权限‌：对应数字7
 * @author Sandy
 * @since 1.0.0 04th 12 2018
 */
public class UserPermission extends AbstractDateEntity<Long> {

	private static final long serialVersionUID = 398035508472559564L;
	
	/**
	 * 权限代码模型.
	 */
	private Integer mode;

	public Integer getMode() {
		return mode;
	}
	
	public int isAllow(int mode) {
		return this.mode | mode;
	}

	public void setMode(Integer mode) {
		this.mode = mode;
	}
	
	public static void main(String[] args) {
		System.out.println( 1 | 2 | 4);
	}
}
