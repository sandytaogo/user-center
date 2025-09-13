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

package com.sandy.user.center.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandy.ecp.framework.web.annotation.EcpDeleteMapping;
import com.sandy.ecp.framework.web.annotation.EcpGetMapping;
import com.sandy.ecp.framework.web.annotation.EcpPatchMapping;
import com.sandy.ecp.framework.web.annotation.EcpPostMapping;
import com.sandy.ecp.framework.web.annotation.EcpPutMapping;
import com.sandy.user.center.assembler.AccountAssembler;
import com.sandy.user.center.domain.Account;
import com.sandy.user.center.service.AccountService;
import com.sandy.user.center.vo.AccountVO;

/**
 * user center account controller.
 * @author Sandy
 * @since 1.0.0 04th 12 2018
 */
@RestController
@RequestMapping("account")
public class AccountController {

	@Autowired(required = false)
	private AccountService accountService;

	@EcpGetMapping
	public AccountVO get(HttpServletRequest request) {
		String idStr = request.getParameter("id");
		Long id = null;
		if (StringUtils.isNumeric(idStr)) {
			id = Long.parseLong(idStr);
		}
		Account account = accountService.queryById(id);
		return AccountAssembler.convert(account);
	}
	
	@EcpPostMapping
	public Account create(HttpServletRequest request) {
		return null;
	}
	
	@EcpPutMapping
	public Account put(HttpServletRequest request) {
		return null;
	}
	
	@EcpPatchMapping
	public Account patch(HttpServletRequest request) {
		return null;
	}
	
	@EcpDeleteMapping
	public Account delete(HttpServletRequest request) {
		return null;
	}
}
