package com.simplework.simplework.Service;

import com.simplework.simplework.Bean.Resumes;

import java.util.List;

public interface ResumesService {
    void insertResumes(Resumes resumes);

    List<Resumes> getresumestrace(String stuid);
}
