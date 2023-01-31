package com.simplework.simplework.Service;

import com.simplework.simplework.Bean.Simpletalk;
import com.simplework.simplework.Repository.SimpletalkRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service

public class SimpletalkServiceImpl implements SimpletalkService{
    @Resource
    private SimpletalkRepository simpletalkRepository;

    @Override
    public Simpletalk insertSimpletalk(Simpletalk simpletalk) {
        return simpletalkRepository.save(simpletalk);
    }

    @Override
    public void deleteSimpletalk(Integer simpletalkid) {
        simpletalkRepository.deleteById(simpletalkid);
    }

    @Override
    public Simpletalk updateSimpletalk(Simpletalk simpletalk) {
        return simpletalkRepository.save(simpletalk);
    }

    @Override
    public List<Simpletalk> findAll() {
        return simpletalkRepository.findAll();
    }

    @Override
    public Simpletalk findBysimpletalknameContaining(Integer stname) {
        return simpletalkRepository.findBySimpletalknameContaining(stname);
    }

    @Override
    public List<Simpletalk> findallbyjobid(int jobid) {
        return simpletalkRepository.findAllByJobid(jobid);
    }

    @Override
    public List<Simpletalk> findALLlike(String search) {
        String searchcontext = "%"+search+"%";
        return simpletalkRepository.findBySimpletalknameLike(searchcontext);
    }

    @Override
    public Simpletalk findbysimpletalkid(String simpletalkid) {
        return simpletalkRepository.findBySimpletalkid(Integer.parseInt(simpletalkid));
    }

    @Override
    public int findBysimpletalknameauthoridjobid(String simpletalkname, String authorid, int jobid) {
        return simpletalkRepository.findSimpletalkidBySimpletalknameAndAuthoridAndJobid(simpletalkname,authorid,jobid);
    }

    @Override
    public List<Simpletalk> findallbyauthorid(String authorid) {
        return simpletalkRepository.findAllByAuthorid(authorid);
    }
}
