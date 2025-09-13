package com.sandy.user.center.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sandy.user.center.domain.UserSessionMongo;

@Repository
public interface UserSessionRepository extends MongoRepository<UserSessionMongo, String> {


	
	
	
	
	
	
	
	
	
	
	
	
	
	//db.createUser({user:"admin", pwd:"123456", roles:[{rele:"root", db:"admin"}]})
}
