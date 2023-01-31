package com.simplework.simplework.Controller;

import com.simplework.simplework.Bean.Bussinfo;
import com.simplework.simplework.Bean.Simpletalk;
import com.simplework.simplework.Bean.Stuinfo;
import com.simplework.simplework.Service.BussinfoService;
import com.simplework.simplework.Service.SimpletalkService;
import com.simplework.simplework.Service.StuinfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/simpletalk")
public class SimpletalkController {
    @Resource
    private SimpletalkService simpletalkService;
    @Resource
    private StuinfoService stuinfoService;
    @Resource
    private BussinfoService bussinfoService;
    @GetMapping("/findall")
    public List<Simpletalk> findall(){
        return simpletalkService.findAll();
    }
    @GetMapping("/findbyid/{simpletalkid}")
    public Simpletalk findbyid(@PathVariable("simpletalkid")String simpletalkid){
        return simpletalkService.findbysimpletalkid(simpletalkid);
    }
    @GetMapping("/search/{search}")
    public List<Simpletalk> search(@PathVariable("search")String search){
        return simpletalkService.findALLlike(search);
    }
    @PostMapping("/add")
    public int addtalk(@RequestBody Simpletalk simpletalk){
        if (simpletalk.getItem().equals("stu")){
            Stuinfo stuinfo = stuinfoService.findBystuid(simpletalk.getAuthorid());
            simpletalk.setAuthor(stuinfo.getUsername());
        }else {
            Bussinfo bussinfo = bussinfoService.findBybussid(simpletalk.getAuthorid());
            simpletalk.setAuthor(bussinfo.getBussname());
        }
        simpletalkService.insertSimpletalk(simpletalk);
        return simpletalkService.findBysimpletalknameauthoridjobid(simpletalk.getSimpletalkname(),simpletalk.getAuthorid(),simpletalk.getJobid());
    }
    @GetMapping("/searchbyauthor/{Authorid}")
    public List<Simpletalk> searchbyauthor(@PathVariable("Authorid") String authorid){
        return simpletalkService.findallbyauthorid(authorid);
    }
}
