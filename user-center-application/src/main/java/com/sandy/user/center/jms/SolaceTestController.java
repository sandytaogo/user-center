/*
 * Copyright 2018-2030 the original author or authors.
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
package com.sandy.user.center.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solace.labs.spring.boot.autoconfigure.SolaceJmsProperties;

@RestController
@RequestMapping("/solace")
public class SolaceTestController {
	
	@Autowired
	protected SolaceJmsProperties solaceProperties;
	
	@Autowired
	@Qualifier("solJmsTemplate")
    private JmsTemplate pubJmsTemplate;

    @GetMapping
    public String send() {
        pubJmsTemplate.send("test", session -> session.createTextMessage("www.pkslow.com"));
        pubJmsTemplate.send(session -> session.createTextMessage("Larry Deng"));
        return "OK";
    }
}
