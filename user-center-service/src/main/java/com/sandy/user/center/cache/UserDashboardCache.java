/*
 * Copyright 2023-2030 the original author or authors.
 *
 * Licensed under the company License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.company.com/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sandy.user.center.cache;


import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * User dashboard Cache.
 * @author Sandy
 * @since 1.0.0 04th 12 2018
 */
@Repository
public class UserDashboardCache<T> {

	@Autowired
	private CacheManager cacheManager;
	
	protected Cache cache;

	@PostConstruct
	public void init() {
		// SimpleCacheManager scm = new SimpleCacheManager();
		// EhCacheManagerFactoryBean efb = new EhCacheManagerFactoryBean();
		// efb.setConfigLocation(configLocation);
		// EhCacheCacheManager cd = new EhCacheCacheManager();
		// manager =
		// CacheManager.create(DashboardCache.class.getClassLoader().getResourceAsStream(configfile));
		// Create a cache manager
	      cache = cacheManager.getCache("user_dashboard");
	}

	/**
	 * 将数据存入Cache
	 * @param key 类似redis的Key create a key to map the data to
	 * @param value Put the element into the data store 类似redis的value，value可以是任何对象、数据类型，比如person,map,list等
	 */
	public void put(Serializable key, Serializable value) {
		// Create a data element
		cache.put(new Element(key, value));
	}

	/**
	 * 获取缓存cachename中key对应的value
	 * @param key 
	 * @return
	 */
	public Object get(Serializable key) {
		try {
			// Retrieve the data element
			Element e = cache.get(key);
			if (e == null) {
				return null;
			}
			return e.getObjectValue();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (CacheException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 清除缓存名称为cachename的缓存
	 * 
	 * @param cachename
	 */
	public  void clearCache() {
		try {
			cache.removeAll();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 移除缓存cachename中key对应的value
	 * 
	 * @param cachename
	 * @param key
	 */
	public  void remove(Serializable key) {
		cache.remove(key);
	}
}

