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

package com.sandy.account.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandy.account.assembler.AccountAssembler;
import com.sandy.account.domain.Account;
import com.sandy.account.service.AccountService;
import com.sandy.account.vo.AccountVO;


/**
 * account controller
 * 
 * @author Sandy
 * @since 04th 12 2018
 */
@RestController
@RequestMapping("account")
public class AccountController {

	@Autowired(required = false)
	private AccountService accountService;

	@GetMapping("get")
	public AccountVO get(HttpServletRequest request) {
		String idStr = request.getParameter("id");
		Long id = null;
		if (StringUtils.isNumeric(idStr)) {
			id = Long.parseLong(idStr);
		}
		Account account = accountService.queryById(id);
		return AccountAssembler.convert(account);
	}
	
	@PostMapping("update")
	public Account update(HttpServletRequest request) {
		return null;
	}
	
	@PatchMapping("patch")
	public Account patch(HttpServletRequest request) {
		
		return null;
	}
	
	@DeleteMapping("delete")
	public Account delete(HttpServletRequest request) {
		
		return null;
	}
}
