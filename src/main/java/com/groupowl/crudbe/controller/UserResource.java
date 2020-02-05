package com.groupowl.crudbe.controller;

import java.util.List;

import javax.validation.Valid;

import com.groupowl.crudbe.entities.UserEntity;
import com.groupowl.crudbe.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@CrossOrigin
@AllArgsConstructor
@RequestMapping(value = "/user")
@RestController
public class UserResource {
	private UserService service;

	@GetMapping
	public ResponseEntity<List<UserEntity>> entity() throws Exception {
		return ResponseEntity.ok(this.service.getUsers());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserEntity> user(@PathVariable(value = "id") long id) throws Exception {
		return ResponseEntity.ok(this.service.getUser(id));
	}

	@PutMapping
	public ResponseEntity<UserEntity> edit(@Valid @RequestBody UserEntity entity) throws Exception {
		this.service.updateUser(entity);
		return ResponseEntity.ok().build();
	}

	@PostMapping
	public ResponseEntity<Void> create(@Valid @RequestBody UserEntity entity) throws Exception {
		this.service.createUser(entity);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) throws Exception {
		this.service.deleteUser(id);
		return ResponseEntity.ok().build();
	}
}