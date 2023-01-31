package com.simplework.simplework.Repository;

import com.simplework.simplework.Bean.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimetableRepository extends JpaRepository<Timetable,Integer> {
    Timetable findByStuid(Integer stuid);

    List<Timetable> findAllByStuid(int stuid);
}
