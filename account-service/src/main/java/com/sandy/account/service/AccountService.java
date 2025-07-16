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

package com.sandy.account.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandy.account.domain.Account;
import com.sandy.account.repository.AccountMapper;
import com.sandy.account.repository.AccountRepository;
import com.sandy.ecp.mybatis.service.AbstractService;
/**
 * service
 * 
 * @author Sandy
 * @since 04th 12 2018 
 */
@Service
public class AccountService extends AbstractService<AccountMapper, Account, Long> {

	@Autowired(required = false)
	private AccountMapper accountMapper;
	@Autowired(required = false)
	public AccountRepository accountRepository;
	
	public Account queryById(Long id) {
		if(null ==id) {
			return null;
		}
		return accountRepository.queryById(id);
	}
	
	
	public List<Account> queryList() {
		List<Account> list = new ArrayList<>();
		Account account = accountMapper.selectById(Long.MAX_VALUE);
		list.add(account);
		return list;
	}
}
