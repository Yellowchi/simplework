package com.simplework.simplework.Controller;

import com.simplework.simplework.Bean.Timetable;
import com.simplework.simplework.Service.TimetableService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/timetable")
public class TimetableController {
    @Resource
    private TimetableService timetableService;
    @PostMapping("/addclass")
    public boolean addclass(@RequestBody Timetable timetable){
        return timetableService.insertTimetable(timetable) != null;
    }
    @GetMapping("/getclass/{stuid}")
    public List<Timetable> getclass(@PathVariable int stuid){
        return timetableService.findAllBystuid(stuid);
    }
}
