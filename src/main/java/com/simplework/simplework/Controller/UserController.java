package com.simplework.simplework.Controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.simplework.simplework.Bean.Bussinfo;
import com.simplework.simplework.Bean.Simpletalk;
import com.simplework.simplework.Bean.Stuinfo;
import com.simplework.simplework.Bean.User;
import com.simplework.simplework.Mapper.BussinfoMapper;
import com.simplework.simplework.Mapper.SimpletalkMapper;
import com.simplework.simplework.Mapper.StuinfoMapper;
import com.simplework.simplework.Mapper.UserMapper;
import com.simplework.simplework.Repository.UserRepository;
import com.simplework.simplework.Utils.JwtUtils;
import com.simplework.simplework.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StuinfoMapper stuinfoMapper;
    @Autowired
    private BussinfoMapper bussinfoMapper;
    @Autowired
    private SimpletalkMapper simpletalkMapper;
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        User u = userMapper.selectbyuser(user.getUser());
        if(u == null){
            return Result.usererror();
        }
        if(!user.getPassword().equals(u.getPassword())){
            return Result.paserror();
        }
        String token = JwtUtils.generateToken(user.getUser());
        return Result.ok().data("token",token);
    }
    @GetMapping("/info")
    public Result info(String token){
        String username = JwtUtils.getClaimsByToken(token).getSubject();
        String url = "";
        return Result.ok().data("name",username).data("avatar",url);
    }
    @GetMapping("logout")
    public Result logout(){return Result.ok();}
    @GetMapping("/admins")
    public Result getadmins(@RequestParam(defaultValue = "1") int pagenum){
        Page<User> page = new Page(pagenum,10);
        IPage<User> users =  userMapper.selectPage(page,null);
        return Result.ok().data("item",users);
    }
    @GetMapping("/stus")
    public Result getstus(@RequestParam(defaultValue = "1") int pagenum){
        Page<Stuinfo> page = new Page(pagenum,10);
        IPage<Stuinfo> stus = stuinfoMapper.selectPage(page,null);
        return Result.ok().data("item",stus);
    }
    @GetMapping("/busses")
    public Result getbusses(@RequestParam(defaultValue = "1") int pagenum){
        Page<Bussinfo> page = new Page(pagenum,10);
        IPage<Bussinfo> busses = bussinfoMapper.selectPage(page,null);
        return Result.ok().data("item",busses);
    }
    @GetMapping("/simpletalks")
    public Result getsimpletalk(@RequestParam(defaultValue = "1") int pagenum){
        Page<Simpletalk> page = new Page(pagenum,10);
        IPage<Simpletalk> simpletalks = simpletalkMapper.selectPage(page,null);
        return Result.ok().data("item",simpletalks);
    }
}
