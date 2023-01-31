package com.simplework.simplework.Service;

import com.simplework.simplework.Bean.Stuinfo;
import com.simplework.simplework.Repository.StuinfoRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service

public class StuinfoServiceImpl implements StuinfoService{
    @Resource
    private StuinfoRepository stuinfoRepository;


    @Override
    public Stuinfo addStuinfo(Stuinfo stuinfo) {
        return stuinfoRepository.saveAndFlush(stuinfo);
    }

    @Override
    public void deleteStuinfo(Integer stuid) {
        stuinfoRepository.deleteById(String.valueOf(stuid));
    }

    @Override
    public Stuinfo updateStuinfo(Stuinfo stuinfo) {
        return stuinfoRepository.saveAndFlush(stuinfo);
    }

    @Override
    public List<Stuinfo> findAll() {
        return stuinfoRepository.findAll();
    }

    @Override
    public Stuinfo findBystuid(String stuid) {
        return stuinfoRepository.findByStuid(stuid);
    }

    @Override
    public String findPasswordBystuid(String stuid) {
//        System.out.println(stuinfoRepository.findPasswordByStuid(stuid));
        return stuinfoRepository.findPasswordByStuid(stuid);
    }

    @Override
    public Stuinfo findBystuidAndpassword(String stuid, String password) {
        return stuinfoRepository.findByStuidAndPassword(stuid,password);
    }
}
