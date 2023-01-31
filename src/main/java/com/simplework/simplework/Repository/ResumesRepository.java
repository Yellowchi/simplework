package com.simplework.simplework.Repository;

import com.simplework.simplework.Bean.Resumes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResumesRepository extends JpaRepository<Resumes,Integer> {

    List<Resumes> findAllByStuid(String stuid);
}
