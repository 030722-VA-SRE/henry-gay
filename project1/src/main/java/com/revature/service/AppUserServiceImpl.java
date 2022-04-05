package com.revature.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.AppUser;
import com.revature.model.Role;
import com.revature.repository.RoleRepository;
import com.revature.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service @RequiredArgsConstructor @Transactional 
public class AppUserServiceImpl implements AppUserService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private static final Logger Log = LoggerFactory.getLogger(AppUserService.class);
	
	@Override
	public AppUser saveUser(AppUser appuser) {
		Log.info("Saving new user {} to the database", appuser.getName());
		return userRepository.save(appuser);
	}

	@Override
	public Role saveRole(Role role) {
		Log.info("Saving new role {} to the database", role.getName());
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		Log.info("Adding role {} to user {}", roleName, username);
		AppUser appUser = userRepository.findByUsername(username);
		Role role = roleRepository.findByName(roleName);
		appUser.getRoles().add(role);
	}

	@Override
	public AppUser getUser(String username) {
		Log.info("Fetching user {}", username);
		return userRepository.findByUsername(username);
	}

	@Override
	public List<AppUser> getUsers() {
		Log.info("Fetching all users");
		return userRepository.findAll();
	}

}
