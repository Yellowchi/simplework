package com.simplework.simplework.Repository;

import com.simplework.simplework.Bean.Stuinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StuinfoRepository extends JpaRepository<Stuinfo,String> {
    Stuinfo findByStuid(String stuid);
    @Query("select password from Stuinfo where stuid = ?1")
    String findPasswordByStuid(String stuid);

    Stuinfo findByStuidAndPassword(String stuid, String password);
}
