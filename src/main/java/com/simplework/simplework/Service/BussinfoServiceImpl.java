package com.simplework.simplework.Service;

import com.simplework.simplework.Bean.Bussinfo;
import com.simplework.simplework.Repository.BussinfoRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service

public class BussinfoServiceImpl implements BussinfoService{
    @Resource
    private BussinfoRepository bussinfoRepository;

    @Override
    public Bussinfo insertBussinfo(Bussinfo bussinfo) {
        return bussinfoRepository.saveAndFlush(bussinfo);
    }

    @Override
    public void deleteBussinfo(String bussid) {
        bussinfoRepository.deleteById(bussid);
    }

    @Override
    public Bussinfo updateBussinfo(Bussinfo bussinfo) {
        return bussinfoRepository.saveAndFlush(bussinfo);
    }

    @Override
    public List<Bussinfo> findAll() {
        return bussinfoRepository.findAll();
    }

    @Override
    public Bussinfo findBybussid(String bussid) {
        return bussinfoRepository.findByBussid(bussid);
    }

    @Override
    public Bussinfo findBybussidAndpassword(String bussid, String password) {
        return bussinfoRepository.findByBussidAndPassword(bussid,password);
    }

    @Override
    public String findbussnamebybussid(String bussid) {
        return bussinfoRepository.findBussnameByBussid(bussid);
    }
}
