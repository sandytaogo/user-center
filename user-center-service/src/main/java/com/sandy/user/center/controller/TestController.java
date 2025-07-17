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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import com.sandy.ecp.framework.web.annotation.EcpGetMapping;

/**
 * user center test controller.
 * 
 * @author Sandy
 * @since 1.0.0 04th 12 2018
 */
@RestController
public class TestController {

	@Value("${spring.application.name}")
	private String name;

	@Value("${server.port}")
	private int port;

	@EcpGetMapping(value = "/hi")
	public String hi() {
		return "hello world ! I'm :" + name + ":" + port;
	}
}
