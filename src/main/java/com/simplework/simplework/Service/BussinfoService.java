package com.simplework.simplework.Service;

import com.simplework.simplework.Bean.Bussinfo;

import java.util.List;

public interface BussinfoService {
    /**
     * 新增
     */
    Bussinfo insertBussinfo(Bussinfo bussinfo);

    /**
     * 删除
     */
    void deleteBussinfo(String bussid);

    /**
     * 修改
     */
    Bussinfo updateBussinfo(Bussinfo bussinfo);

    /**
     * 查询所有
     */
    List<Bussinfo> findAll();

    /**
     * 查询某一个根据bussid
     */
    Bussinfo findBybussid(String bussid);

    Bussinfo findBybussidAndpassword(String bussid, String password);

    String findbussnamebybussid(String bussid);
}
