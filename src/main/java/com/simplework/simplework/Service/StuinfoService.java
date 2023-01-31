package com.simplework.simplework.Service;

import com.simplework.simplework.Bean.Stuinfo;

import javax.transaction.Transactional;
import java.util.List;

public interface StuinfoService {
    /**
     * 新增
     */
    @Transactional
    Stuinfo addStuinfo(Stuinfo stuinfo);

    /**
     * 删除
     */
    void deleteStuinfo(Integer stuid);

    /**
     * 修改
     */
    Stuinfo updateStuinfo(Stuinfo stuinfo);

    /**
     * 查询所有
     */
    List<Stuinfo> findAll();

    /**
     * 查询某一个根据stuid
     * @param stuid
     */
    Stuinfo findBystuid(String stuid);

    /**
     * 查询密码根据stuid
     * @param stuid
     * @return
     */
    String findPasswordBystuid(String stuid);

    Stuinfo findBystuidAndpassword(String stuid, String password);
}
