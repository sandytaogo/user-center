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

import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.sandy.account.domain.Account;
import com.sandy.account.startup.AccountApplication;

@DirtiesContext
@ActiveProfiles(profiles = "test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AccountApplication.class)
@PropertySource("classpath:jdbc.properties")
//@IntegrationTest({"debug", "server.port:0"})
public class AccountServiceTestCase extends AbstractTransactionalJUnit4SpringContextTests {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@DataPoint
	public static Long id = 37919548753580032L;
	
	public static String applicationName = "test-application";
	
	@Autowired
	private AccountService accountService;
	
	RestTemplate restTemplate = new TestRestTemplate().getRestTemplate();  
	
	@Test
	public void test() {
		Account account = accountService.queryById(id);
		System.err.println(account);
	}
	
	/***
	 * load balance
	 */
	@Test
	@Ignore
	public void loadBalance() {
		StringBuilder url = new StringBuilder(applicationName).append("/hi");
		String result = restTemplate.getForObject(url.toString(), String.class);
		logger.info("result {}", result);
	}
}
