package com.simplework.simplework.Service;

import com.simplework.simplework.Bean.Timetable;

import java.util.List;

public interface TimetableService {
    /**
     * 新增
     */
    Timetable insertTimetable(Timetable timetable);
    /**
     * 删除
     */
    void deleteTimetable(Integer timetableid);
    /**
     * 修改
     */
    Timetable updateTimetable(Timetable timetable);
    /**
     * 查询所有
     */
    List<Timetable> findAll();
    /**
     * 查询狗咬狗根据stuid
     */
    Timetable findBystuid(Integer stuid);

    /**
     *
     * @param stuid
     * @return
     */
    List<Timetable> findAllBystuid(int stuid);
}
