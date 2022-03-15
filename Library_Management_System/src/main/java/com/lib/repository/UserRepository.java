package com.lib.repository;

import org.springframework.data.repository.CrudRepository;


import com.lib.model.User;

public interface UserRepository extends CrudRepository<User, String>
{
	
}
