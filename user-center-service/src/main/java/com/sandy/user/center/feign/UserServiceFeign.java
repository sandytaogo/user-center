package com.sandy.user.center.feign;

import java.util.List;

import com.sandy.user.center.dto.AuthorizePlatformDto;
import com.sandy.user.center.dto.UserDto;
import com.sandy.user.center.service.IUserService;

public class UserServiceFeign implements IUserService {

	@Override
	public UserDto getUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuthorizePlatformDto> getAuthorizePlatformListByUserId(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
