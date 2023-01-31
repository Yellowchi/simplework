package com.simplework.simplework.Service;

import com.simplework.simplework.Bean.Simpletalk;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface SimpletalkService {

    /**
     * 新增
     */
    Simpletalk insertSimpletalk(Simpletalk simpletalk);
    /**
     * 删除
     */
    void deleteSimpletalk(Integer simpletalkid);
    /**
     * 修改
     */
    Simpletalk updateSimpletalk(Simpletalk simpletalk);
    /**
     * 查询所有
     */
    List<Simpletalk> findAll();
    /**
     * 查询某一个根据simpletalkname
     * @param stname
     */
    Simpletalk findBysimpletalknameContaining(Integer stname);

    List<Simpletalk> findallbyjobid(int jobid);

    List<Simpletalk> findALLlike(String search);

    Simpletalk findbysimpletalkid(String simpletalkid);

    int findBysimpletalknameauthoridjobid(String simpletalkname, String authorid, int jobid);

    List<Simpletalk> findallbyauthorid(String authorid);
}
