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
package com.sandy.user.center.service;

import javax.annotation.PostConstruct;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.sandy.user.center.domain.UserMongo;
import com.sandy.user.center.repository.UserMongoRepository;
import com.sandy.user.center.vo.UserMongoVO;

@Service
public class UserMongoService {

	@Autowired(required = false)
	private UserMongoRepository userMongoRepository;
	
	@Autowired
    protected MongoTemplate mongoTemplate;
	
	@PostConstruct
	public void init() {
		System.out.println("sfsfssf");
	}
	
	public void save(UserMongoVO model) {
		UserMongo po = new UserMongo();
		po.setId(new ObjectId());
		po.setUserName(model.getUserName());
		po.setNickName(model.getNickName());
		userMongoRepository.save(po);
	}
}
