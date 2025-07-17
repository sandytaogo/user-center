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

package com.sandy.user.center.assembler;

import com.sandy.user.center.domain.Account;
import com.sandy.user.center.vo.AccountVO;

/**
 * account assembler
 * 
 * @author Sandy
 * @since 04th 12 2018
 */
public final class AccountAssembler {

	/**
	 * conversion
	 * 
	 * @param account
	 * @return AccountVO
	 */
	public static AccountVO convert(Account account) {
		if(null == account) {
			return null;
		}
		AccountVO accountVO = new AccountVO();
		accountVO.setId(account.getId());
		return accountVO;
	}
}
