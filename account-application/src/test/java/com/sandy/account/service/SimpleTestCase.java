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

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@DirtiesContext
@ActiveProfiles(profiles = "test")
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = SsoApplication.class)
@WebAppConfiguration
//@IntegrationTest({"debug", "server.port:0"})
public class SimpleTestCase extends AbstractJUnit4SpringContextTests {

	private volatile Logger logger = LoggerFactory.getLogger(getClass());
	
	@DataPoint
	public static Long id = 0L;
	
	/**
	 * init
	 */
	@Before
	public void init() {
		logger.info("befor");
	}
	
	/**
	 *test
	 */
	@Test
	@Ignore
	public void test() {
		logger.info("test");
	}
	
	/**
	 * destroy
	 */
	@After
	public void destroy() {
		logger.info("destroy");
	}
}
