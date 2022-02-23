package com.toubibnet.toubibnet.repository;

import com.toubibnet.toubibnet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UserRepo extends JpaRepository<User,Long> {
}
