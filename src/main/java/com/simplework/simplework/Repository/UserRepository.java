package com.simplework.simplework.Repository;

import com.simplework.simplework.Bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
