package com.simplework.simplework.Controller;

import com.simplework.simplework.Bean.Stuinfo;
import com.simplework.simplework.Service.StuinfoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/stuinfo")
public class StuinfoController {
    @Resource
    private StuinfoService stuinfoService;
    /*@GetMapping("/login/{stuid}")
    public String login(@PathVariable String stuid){
//        System.out.println("Service"+stuinfoService.findPasswordBystuid(stuid));
        return stuinfoService.findPasswordBystuid(stuid);
    }*/
    @PostMapping("/login")
    public String login(@RequestBody Stuinfo stuinfo){
        if(stuinfoService.findBystuid(stuinfo.getStuid()) == null){
            return "用户不存在";
        }
        if(stuinfoService.findBystuidAndpassword(stuinfo.getStuid(),stuinfo.getPassword()) != null){
            return "true";
        }else{
            return "密码错误";
        }
    }
    @PostMapping("/insert")
    public boolean insertstuinfo(@RequestBody Stuinfo stuinfo){
        stuinfo.setCreatedate(new Date());
        return stuinfoService.addStuinfo(stuinfo) != null;
    }
    @PostMapping("/update")
    public void updatestuinfo(@RequestBody Stuinfo stuinfo){
        stuinfoService.updateStuinfo(stuinfo);
    }
    @GetMapping("")
    public List<Stuinfo> findall(){
        return stuinfoService.findAll();
    }
    @GetMapping("/search/{stuid}")
    public Stuinfo findBystuid(@PathVariable("stuid") String stuid){
        return stuinfoService.findBystuid(stuid);
    }
    @PostMapping("/uploadheadpic")
    public void uploadheadpic(@RequestParam(value="file") MultipartFile file,
                              @RequestParam(value = "id") String id) {
//        System.out.println(file);
        String path = "/SimpleWork/headpic";
//        String path = "";
        // 获取上传的位置（存放图片的文件夹）,如果不存在，创建文件夹
        File fileParent = new File(path);
        if (!fileParent.exists()) {
            fileParent.mkdirs();
        }
        File newFile = new File(path + "/stu/", id+".jpg");
        // 如果不存在，创建一个副本
        if (!newFile.exists()) {
            try {
                // 将io上传到副本中
                newFile.createNewFile();
                file.transferTo(newFile);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            try {
                // 将io上传到副本中
                file.transferTo(newFile);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    @PostMapping("/uploadresumes")
    public void uploadresumes(@RequestParam(value="file") MultipartFile file,
                              @RequestParam(value = "id") String id){
        String path = "/SimpleWork/Resumes";
        File fileParent = new File(path );
        if(!fileParent.exists()){
            fileParent.mkdirs();
        }
        File newFile = new File(path+"/stu/",id+".pdf");
        if(!newFile.exists()){
            try{
                newFile.createNewFile();
                file.transferTo(newFile);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
