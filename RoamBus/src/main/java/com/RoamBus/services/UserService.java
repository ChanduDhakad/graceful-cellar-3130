package com.RoamBus.services;



import java.util.List;

import com.RoamBus.access.exception.AdminException;
import com.RoamBus.access.exception.LoginException;
import com.RoamBus.exception.UserException;
import com.RoamBus.model.User;

public interface UserService {

	
 public	User addUser(User user) throws UserException;
 public	User updateUser(User user,String key) throws UserException,LoginException;
 public	User deleteUser(User user,String key) throws UserException,LoginException;
 
 public	User ViewUser(int Userid,String key) throws UserException,LoginException;
 
 public	List<User> ViewAllUser(String key) throws UserException,LoginException,AdminException;
 
 
 
}
