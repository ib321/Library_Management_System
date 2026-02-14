package com.ib.lms.repository;

import org.springframework.data.repository.CrudRepository;


import com.ib.lms.model.User;


/*
 * UserRepository interface extends the CrudRepository it will connect to the database
 */
public interface UserRepository extends CrudRepository<User, String>
{
	
}
