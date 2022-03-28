package com.lib.repository;

import org.springframework.data.repository.CrudRepository;


import com.lib.model.User;


/*
 * UserRepository interface extends the CrudRepository it will connect to the database
 */
public interface UserRepository extends CrudRepository<User, String>
{
	
}
