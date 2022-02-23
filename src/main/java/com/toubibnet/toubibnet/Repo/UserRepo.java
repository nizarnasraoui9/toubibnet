package com.toubibnet.toubibnet.Repo;

import com.toubibnet.toubibnet.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UserRepo extends JpaRepository<User,Long> {
}
