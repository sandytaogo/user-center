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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.mongodb.client.ListIndexesIterable;
import com.sandy.user.center.startup.UserCenterApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserCenterApplication.class)
public class UserSessoinServiceTest {
	
    @Autowired
    private MongoTemplate mongoTemplate;
   /**
     * 查询集合中所有的索引
     */
    @Test
    public void getIndexAll() {
        // 获取集合中所有列表
        ListIndexesIterable<org.bson.Document> indexList = mongoTemplate.getCollection("persons").listIndexes();
        // 获取集合中全部索引信息
        for (org.bson.Document document : indexList) {
            System.out.println("索引列表：" + document);
        }
    }
}
