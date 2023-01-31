package com.simplework.simplework.Controller;

import com.simplework.simplework.Bean.Bussinfo;
import com.simplework.simplework.Service.BussinfoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;

@RestController
@RequestMapping("/api/bussinfo")
public class BussinfoController {
    @Resource
    private BussinfoService bussinfoService;
    @PostMapping("/insert")
    public boolean insertbussinfo(@RequestBody Bussinfo bussinfo){
        return bussinfoService.insertBussinfo(bussinfo) != null;
    }
    @PostMapping("/login")
    public String login(@RequestBody Bussinfo bussinfo){
        if(bussinfoService.findBybussid(bussinfo.getBussid()) == null){
            return "用户不存在";
        }
        if(bussinfoService.findBybussidAndpassword(bussinfo.getBussid(),bussinfo.getPassword()) != null){
            return "true";
        }else{
            return "密码错误";
        }
    }
    @PostMapping("/update")
    public void update(@RequestBody Bussinfo bussinfo){
        bussinfoService.updateBussinfo(bussinfo);
    }
    @GetMapping("/search/{bussid}")
    public Bussinfo findBybussid(@PathVariable("bussid") String bussid){
        return bussinfoService.findBybussid(bussid);
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
        File newFile = new File(path + "/buss/", id+".jpg");
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
}
