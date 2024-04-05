package com.RoamBus.services;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.RoamBus.access.exception.LoginException;
import com.RoamBus.model.Admin;
import com.RoamBus.model.CurrentUser;
import com.RoamBus.model.LoginDTO;
import com.RoamBus.model.User;
import com.RoamBus.repository.AdminDao;
import com.RoamBus.repository.CurrentUserDao;
import com.RoamBus.repository.UserDao;
import net.bytebuddy.utility.RandomString;
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private AdminDao  adao;	
	@Autowired
	private CurrentUserDao cudao;	
	@Autowired
	private UserDao udao;	
	@Override
	public String login(LoginDTO dto) throws LoginException {
		Admin a=adao.findByAdminUsername(dto.getUsername());
		User u=udao.findByUserName(dto.getUsername());
		if(u==null && a!=null) {
		    Optional<CurrentUser> cu=cudao.findById(a.getAdminId());
		if(cu.isPresent()) {
			throw new LoginException("already loggedIn");
		}
		if(a.getPassword().equals(dto.getPassword())) {
		    RandomString rs= new RandomString();
			String key =rs.make(6);
			CurrentUser newCu=new CurrentUser(a.getAdminId(), key,true, LocalDateTime.now());
			cudao.save(newCu);
			return newCu.toString();
		}
		throw new LoginException("Please enter a valid password");					
				
        }else if((a==null)&& (u!=null)) {	    	 
    	   Optional<CurrentUser> cu=cudao.findById(u.getUserLoginId());
    	   if(cu.isPresent()) {
				throw new LoginException("already loggedIn");
    	   }
    	   if(u.getPassword().equals(dto.getPassword())) {				
				RandomString rs= new RandomString();
				String key =rs.make(6);
				CurrentUser newCu=new CurrentUser(u.getUserLoginId(), key,false, LocalDateTime.now());
				cudao.save(newCu);
				return newCu.toString();				 
			}    	 
    	   throw new LoginException("Please enter a valid password");	 
       }else {
	       throw new LoginException("Please enter a valid username");
        }	
    }

	@Override
	public String logout(String key) throws LoginException {
		CurrentUser cu=cudao.findByUuid(key);		
		if(cu == null) {
			throw new LoginException("User not loggedin with this username");
		}		
		cudao.delete(cu);		
		return "Loggedout";
	}

}
