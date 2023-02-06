package com.simplework.simplework.Controller;

import com.simplework.simplework.Bean.User;
import com.simplework.simplework.Repository.UserRepository;
import com.simplework.simplework.Utils.JwtUtils;
import com.simplework.simplework.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        System.out.println("login");
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
}
