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

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.sandy.ecp.framework.vo.AbstractDateVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * user center account view object.
 * 
 * @author Sandy
 * @since 1.0.0 04th 12 2018
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO extends AbstractDateVO<Long> {

	private static final long serialVersionUID = 8986970279121376438L;
	
	private String mobile;
	private String nickName;
	
	@Override
	@JsonFormat(shape = Shape.STRING)
	public Long getId() {
		return super.getId();
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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserVO other = (UserVO) obj;
		return Objects.equals(mobile, other.mobile) && Objects.equals(nickName, other.nickName);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(mobile, nickName);
		return result;
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
