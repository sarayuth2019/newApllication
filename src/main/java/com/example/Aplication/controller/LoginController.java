package com.example.Aplication.controller;

import com.example.Aplication.model.bean.APIResponse;
import com.example.Aplication.model.service.UserRepository;
import com.example.Aplication.model.table.User;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/User",method = RequestMethod.GET)
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/Login")
    public Object login(User user) {
        APIResponse res = new APIResponse();
        try {
            User checkUserAndPass = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
            if (checkUserAndPass != null) {
                res.setStatus(1);
                res.setMessage("Login success");
                res.setData(checkUserAndPass);
                return res;

            } else {
                res.setStatus(0);
                res.setMessage("Login fail");
            }

        } catch (Exception err) {
            res.setData(0);
            res.setMessage("Error" + err.toString());
        }
        return res;
    }

   @GetMapping("/{id}")
    public Object IdList(User user, @PathVariable Long id) {
        APIResponse response = new APIResponse();
        Optional<User> getId = userRepository.findById(user.getId());
        response.setData(getId);
        response.setMessage("search ID complete");
        return response;
    }

    @GetMapping ("/search/username")
    public Object nameList(@Param("username") String username) {
        APIResponse res = new APIResponse();
        Optional<User> credentials = Optional.ofNullable(userRepository.findByUsername(username));
        res.setData(credentials);
        res.setMessage("search username complete");
        return res;
    }
    @PostMapping("/update/{id}")
    public Object updateUser(User user,@PathVariable Long id) {
        APIResponse response = new APIResponse();
        Optional<User> getId = userRepository.findById(user.getId());
        userRepository.save(user);
        response.setData(getId);
        response.setMessage("update complete");
        return response;
    }
    /*@PostMapping("update/name/{id}")
    public Object updateName(User user){
        APIResponse response = new APIResponse();
        Optional<User> getName = userRepository.findOne(ID);
        response.setData(getName);
        userRepository.save();
    }*/
    @PostMapping("/search/name")
    public Object test(String name){
        APIResponse response = new APIResponse();
        List<User> getName =  this.userRepository.findByName(name);
        response.setData(getName);
        response.setMessage("search name complete");
        return response;
    }
    @GetMapping("/search")
    public Object ListAll(User user){
        APIResponse response = new APIResponse();
        List<User> getAllname = userRepository.findAll();
        response.setData(getAllname);
        response.setMessage("search ListAllName complete");
        return  response;
    }

}
