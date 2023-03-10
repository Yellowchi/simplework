package com.simplework.simplework.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.simplework.simplework.Bean.*;
import com.simplework.simplework.Mapper.*;
import com.simplework.simplework.Repository.JobRepository;
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
    @Autowired
    private JobMapper jobMapper;
    @Autowired
    private JobRepository jobRepository;

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
    /**
     * 查找管理员用户
     * @param pagenum
     * @param quary
     * @return
     */
    @GetMapping("/admins")
    public Result getadmins(@RequestParam(defaultValue = "1") int pagenum,@RequestParam(name = "quary",defaultValue = "") String quary){
        Page<User> page = new Page(pagenum,10);
        IPage<User> users = new Page<>();
        int total;
        if(quary.isEmpty()){
            users = userMapper.selectPage(page,null);
            total = userMapper.selectCount(null);
        }else {
            //设置查询条件
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.like("user",quary);
            users = userMapper.selectPage(page,queryWrapper);
            total = userMapper.selectCount(queryWrapper);
        }
        return Result.ok().data("item",users).data("total",total);
    }
    /**
     * 修改{user}的state
     * @param user
     * @param type
     * @return
     */
    @PutMapping("/admins/{user}/state/{type}")
    public Result changeadminsstate(@PathVariable(name = "user") String user,@PathVariable(name = "type") boolean type){
        userMapper.updatestatebyuser(type,user);
        return Result.ok();
    }
    /**
     * 添加管理员用户
     * @param user
     * @return
     */
    @PostMapping("/addadmins")
    public Result addadmins(@RequestBody User user){
        System.out.println(user.toString());
        userMapper.insert(user);
        return Result.ok();
    }
    /**
     * 编辑admins
     * @param user
     * @return
     */
    @PostMapping("/editadmins")
    public Result editadmins(@RequestBody User user){
        System.out.println(user.toString());
        userMapper.updateById(user);
        return Result.ok();
    }
    /**
     * 删除admins
     * @param user
     * @return
     */
    @DeleteMapping("/deladmins")
    public Result deladmins(@RequestBody User user){
        userMapper.deletebyuser(user.getUser());
        return Result.ok();
    }
    /**
     * 查找stu用户
     * @param pagenum
     * @return
     */
    @GetMapping("/stus")
    public Result getstus(@RequestParam(defaultValue = "1") int pagenum,@RequestParam(name = "quary",defaultValue = "") String quary){
        Page<Stuinfo> page = new Page(pagenum,10);
        IPage<Stuinfo> stus = new Page<>();
        int total;
        if (quary.isEmpty()){
            stus = stuinfoMapper.selectPage(page,null);
            total = stuinfoMapper.selectCount(null);
        }else {
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.like("username",quary);
            queryWrapper.like("name",quary);
            stus = stuinfoMapper.selectPage(page,queryWrapper);
            total = stuinfoMapper.selectCount(queryWrapper);
        }
        return Result.ok().data("item",stus).data("total",total);
    }
    /**
     * 添加stu用户
     * @param stuinfo
     * @return
     */
    @PostMapping("/addstus")
    public Result addstus(@RequestBody Stuinfo stuinfo){
        stuinfoMapper.insert(stuinfo);
        return Result.ok();
    }
    /**
     * 更新stu用户
     * @param stuinfo
     * @return
     */
    @PostMapping("/editstus")
    public Result editstus(@RequestBody Stuinfo stuinfo){
        stuinfoMapper.update(stuinfo,null);
        return Result.ok();
    }
    /**
     * 删除stu用户
     * @param stuinfo
     * @return
     */
    @DeleteMapping("/deletestus")
    public Result deletestus(@RequestBody Stuinfo stuinfo){
        stuinfoMapper.deletebystuid(stuinfo.getStuid());
        return Result.ok();
    }

    /**
     *查找buss用户
     * @param pagenum
     * @return
     */
    @GetMapping("/busses")
    public Result getbusses(@RequestParam(defaultValue = "1") int pagenum,@RequestParam(name = "quary") String quary){
        Page<Bussinfo> page = new Page(pagenum,10);
        IPage<Bussinfo> busses = new Page<>();
        int total;
        if(quary.isEmpty()){
            busses = bussinfoMapper.selectPage(page,null);
            total = bussinfoMapper.selectCount(null );
        }else {
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.like("bussname",quary);
            busses = bussinfoMapper.selectPage(page,queryWrapper);
            total = bussinfoMapper.selectCount(queryWrapper);
        }
        return Result.ok().data("item",busses).data("total",total);
    }

    /**
     * 添加buss用户
     * @param bussinfo
     * @return
     */
    @PostMapping("/addbusses")
    public Result addbusses(@RequestBody Bussinfo bussinfo){
        bussinfoMapper.insert(bussinfo);
        return Result.ok();
    }

    /**
     * 编辑buss用户
     * @param bussinfo
     * @return
     */
    @PostMapping("/editbusses")
    public Result editbusses(@RequestBody Bussinfo bussinfo){
        bussinfoMapper.update(bussinfo,null);
        return Result.ok();
    }

    /**
     * s删除buss用户
     * @param bussinfo
     * @return
     */
    @DeleteMapping("/deletebusses")
    public Result deletebusses(@RequestBody Bussinfo bussinfo){
        bussinfoMapper.deletebybussid(bussinfo.getBussid());
        return Result.ok();
    }

    /**
     * 查找simpletalk
     * @param pagenum
     * @param quary
     * @return
     */
    @GetMapping("/simpletalks")
    public Result getsimpletalk(@RequestParam(defaultValue = "1") int pagenum,@RequestParam(name = "quary") String quary){
        Page<Simpletalk> page = new Page(pagenum,10);
        IPage<Simpletalk> simpletalks = new Page<>();
        int total;
        if( quary.isEmpty() ){
            simpletalks = simpletalkMapper.selectPage(page,null);
            total = simpletalkMapper.selectCount(null);
        }else {
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.like("simpletalkname",quary);
            simpletalks = simpletalkMapper.selectPage(page,queryWrapper);
            total = simpletalkMapper.selectCount(queryWrapper);
        }
        return Result.ok().data("item",simpletalks).data("total",total);
    }

    /**
     * 添加simpletalk
     * @param simpletalk
     * @return
     */
    @PostMapping("/addsimpletalks")
    public Result addsimpletalks(@RequestBody Simpletalk simpletalk){
        simpletalkMapper.insert(simpletalk);
        return Result.ok();
    }

    /**
     * 更新simpletalk
     * @param simpletalk
     * @return
     */
    @PostMapping("/editsimpletalks")
    public Result editsimpletalks(@RequestBody Simpletalk simpletalk){
        simpletalkMapper.update(simpletalk,null);
        return Result.ok();
    }

    /**
     * 删除simpletalk
     * @param simpletalk
     * @return
     */
    @DeleteMapping("/deletesimpletalks")
    public Result deletesimpletalks(@RequestBody Simpletalk simpletalk){
        simpletalkMapper.deletebysimpletalkid(simpletalk.getSimpletalkid());
        return Result.ok();
    }

    /**
     * 获取job
     * @param pagenum
     * @param quary
     * @return
     */
    @GetMapping("/jobs")
    public Result getjobs(@RequestParam(defaultValue = "1") int pagenum,@RequestParam(name = "quary") String quary){
        Page<Job> page = new Page(pagenum,10);
        IPage<Job> jobs = new Page<>();
        int total;
        if( quary.isEmpty() ){
            jobs = jobMapper.selectPage(page,null);
            total = jobMapper.selectCount(null);
        }else{
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.like("jobname",quary);
            jobs = jobMapper.selectPage(page,queryWrapper);
            total = jobMapper.selectCount(queryWrapper);
        }
        return Result.ok().data("item",jobs).data("total",total);
    }

    /**
     * 添加job
     * @param job
     * @return
     */
    @PostMapping("/addjobs")
    public Result addjobs(@RequestBody Job job){
        jobMapper.insert(job);
        return Result.ok();
    }

    /**
     * 编辑job
     * @param job
     * @return
     */
    @PostMapping("/editjobs")
    public Result editjobs(@RequestBody Job job){
        jobMapper.update(job,null);
        return Result.ok();
    }

    @DeleteMapping("/deletejobs")
    public Result deletejobs(@RequestBody Job job){
        jobMapper.deletebyjobid(job.getJobid());
        return Result.ok();
    }
}
