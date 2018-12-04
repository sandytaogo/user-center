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

package com.sandy.account.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sandy.account.domain.Account;
import com.sandy.account.util.DataSourceUtils;
import com.sandy.infrastructure.dao.IAbstractDao;

/**
 * account data access object
 * 
 * @author Sandy
 * @since 04th 12 2018
 */
@Repository("accountRepository")
public class AccountRepository implements IAbstractDao<Account> {

	private DataSource dataSource;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Account queryById(Long id) {
		Connection conn = null;
		Account account = null;
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT * FROM SYSTEM_USER WHERE ID = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet result = ps.executeQuery();
			if(result.next()) {
				account = new Account();
				account.setId(result.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSourceUtils.autoClose(conn);
		}
		return account;
	}
}
