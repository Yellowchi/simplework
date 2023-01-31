package com.simplework.simplework.Repository;

import com.simplework.simplework.Bean.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test,Integer> {
}
