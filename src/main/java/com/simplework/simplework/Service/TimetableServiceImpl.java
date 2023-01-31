package com.simplework.simplework.Service;


import com.simplework.simplework.Bean.Timetable;
import com.simplework.simplework.Repository.TimetableRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service

public class TimetableServiceImpl implements TimetableService{
    @Resource
    private TimetableRepository timetableRepository;
    @Override
    public Timetable insertTimetable(Timetable timetable) {
        return timetableRepository.saveAndFlush(timetable);
    }

    @Override
    public void deleteTimetable(Integer timetableid) {
        timetableRepository.deleteById(timetableid);
    }

    @Override
    public Timetable updateTimetable(Timetable timetable) {
        return timetableRepository.save(timetable);
    }

    @Override
    public List<Timetable> findAll() {
        return timetableRepository.findAll();
    }

    @Override
    public Timetable findBystuid(Integer stuid) {
        return timetableRepository.findByStuid(stuid);
    }

    @Override
    public List<Timetable> findAllBystuid(int stuid) {
        return timetableRepository.findAllByStuid(stuid);
    }
}
