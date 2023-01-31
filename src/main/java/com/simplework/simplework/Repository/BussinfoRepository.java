package com.simplework.simplework.Repository;

import com.simplework.simplework.Bean.Bussinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BussinfoRepository extends JpaRepository<Bussinfo,String> {
    Bussinfo findByBussid(String bussid);

    Bussinfo findByBussidAndPassword(String bussid, String password);

    @Query("select bussname from Bussinfo where bussid = ?1")
    String findBussnameByBussid(String bussid);
}
