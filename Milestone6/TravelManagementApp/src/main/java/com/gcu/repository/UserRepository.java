package com.gcu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.gcu.model.User;

public interface UserRepository extends MongoRepository<User, Long>
{
	User findByUsername(String username);
}
