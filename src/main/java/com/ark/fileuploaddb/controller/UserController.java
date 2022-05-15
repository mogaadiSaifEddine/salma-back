package com.ark.fileuploaddb.controller;


import com.ark.fileuploaddb.model.User;
import com.ark.fileuploaddb.model.projet;
import com.ark.fileuploaddb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRep ;


    @GetMapping("/")
    @ResponseBody
    public List<User> getAllUsers() {
        List<User> listUser = userRep.findAll();
        return listUser;
    }




    @DeleteMapping("/{id}")
    public  boolean deleteUser ( @PathVariable Long id ){
      try{  userRep.deleteById(id);
      return true ;}
      catch (Exception e){
          System.out.println(e);
          return  false;
      }
    }
}
