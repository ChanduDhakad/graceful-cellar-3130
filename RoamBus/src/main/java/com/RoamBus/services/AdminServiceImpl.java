package com.RoamBus.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.RoamBus.access.exception.AdminException;
import com.RoamBus.access.exception.LoginException;
import com.RoamBus.model.Admin;
import com.RoamBus.model.CurrentUser;
import com.RoamBus.repository.AdminDao;
import com.RoamBus.repository.CurrentUserDao;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adao;
	@Autowired
	private CurrentUserDao cudao;	
	
	@Override
	public Admin registerAdmin(Admin admin) throws AdminException{
		Admin a = adao.save(admin);
		return a;
	}
	
	@Override
	public Admin getAdminByName(String adminUserName) throws AdminException{
		Admin existingUser = adao.findByAdminUsername(adminUserName);
		return existingUser;
	}

	@Override
	public Admin updateAdmin(Admin admin, String key) throws AdminException, LoginException{
		CurrentUser cu = cudao.findByUuid(key);
		if (cu == null) {
			throw new LoginException("Login first");
		}
		Optional<Admin> a = adao.findById(admin.getAdminId());
		if (a.isPresent()) {
			return adao.save(admin);
		}
		throw new AdminException("You are not an admin");
	}

	@Override
	public Admin deleteAdmin(String adminUserName, String key) throws AdminException {
		Admin a = adao.findByAdminUsername(adminUserName);
		CurrentUser cu = cudao.findByUuid(key);
		if (a == null) {
			throw new AdminException("Sorry it's a wrong username");
		}
		if (cudao.findByUuid(key) != null) {
			adao.delete(a);
			cudao.delete(cu);
			return a;
		}
		throw new AdminException("Please login first");
	}

	@Override
	public Admin findAdminById(Integer adminId) throws AdminException{
		Optional<Admin> opt = adao.findById(adminId);
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new AdminException("there is no admin present with this id");
	}

	@Override
	public Admin findAdminByUserName(String adminUserName, String key) throws AdminException, LoginException{
		CurrentUser cu = cudao.findByUuid(key);
		if (cu == null) {
			throw new LoginException("Login first");
		}
		Optional<Admin> a = adao.findById(adao.findByAdminUsername(adminUserName).getAdminId());
		if (a.isPresent()) {
			return a.get();
		}
		throw new AdminException("You are not an admin");
	}
	
	@Override
	public List<Admin> findAllAdmin(String key) throws AdminException, LoginException{
		CurrentUser cu = cudao.findByUuid(key);
		if (cu == null) {
			throw new LoginException("Login first");
		}
		Optional<Admin> a = adao.findById(cu.getUserId());
		if (a.isPresent()) {
			List<Admin> alist = adao.findAll();
			if (a.isEmpty()) {
				throw new AdminException("No one present in the list yet");
			}
			return alist;
		}
		throw new AdminException("You are not an admin");

	}
}
