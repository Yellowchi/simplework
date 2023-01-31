package com.simplework.simplework.Repository;

import com.simplework.simplework.Bean.Simpletalk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SimpletalkRepository extends JpaRepository<Simpletalk,Integer> {
    Simpletalk findBySimpletalknameContaining(Integer stname);

    List<Simpletalk> findAllByJobid(int jobid);

    List<Simpletalk> findBySimpletalknameLike(String search);

    Simpletalk findBySimpletalkid(int simpletalkid);

    @Query("select simpletalkid from Simpletalk where simpletalkname = ?1 and authorid = ?2 and jobid = ?3")
    int findSimpletalkidBySimpletalknameAndAuthoridAndJobid(String simpletalkname, String authorid, int jobid);

    List<Simpletalk> findAllByAuthorid(String authorid);
}
