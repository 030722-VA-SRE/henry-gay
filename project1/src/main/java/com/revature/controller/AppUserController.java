package com.revature.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.revature.model.AppUser;
import com.revature.model.Role;
import com.revature.service.AppUserService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AppUserController {

	private final AppUserService appUserService;
	
	@GetMapping("/users")
	public ResponseEntity<List<AppUser>>getUsers() {
		return ResponseEntity.ok().body(appUserService.getUsers());
	}
	
	@PostMapping("/users/save")
	public ResponseEntity<AppUser>saveUser(@RequestBody AppUser appUser) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
		return ResponseEntity.created(uri).body(appUserService.saveUser(appUser));
	}
	
	@PostMapping("/role/save")
	public ResponseEntity<Role>saveRole(@RequestBody Role role) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
		return ResponseEntity.created(uri).body(appUserService.saveRole(role));
	}
	
	@PostMapping("/role/addtouser")
	public ResponseEntity<Role>addRoleToUser(@RequestBody RoleToUserForm form) {
		appUserService.addRoleToUser(form.getUsername(), form.getRoleName());
		return ResponseEntity.ok().build();
	}
}

@Data
class RoleToUserForm {
	private String username;
	private String roleName;
}