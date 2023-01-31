package com.simplework.simplework.Service;

import com.simplework.simplework.Bean.Resumes;
import com.simplework.simplework.Repository.ResumesRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResumesServiceImpl implements ResumesService{
    @Resource
    private ResumesRepository resumesRepository;

    @Override
    public void insertResumes(Resumes resumes) {
        resumesRepository.saveAndFlush(resumes);
    }

    @Override
    public List<Resumes> getresumestrace(String stuid) {
        return resumesRepository.findAllByStuid(stuid);
    }
}
