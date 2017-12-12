package com.wontonapp.controller;

import com.wontonapp.common.validator.UserValidator;
import com.wontonapp.model.UserEntity;
import com.wontonapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
/**
 * @Author wulinacha
 * @Date 2017-10-26 11:48:03
 * @Des 用户管理
 */
@Controller
public class UserController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new UserValidator());
    }

    @Autowired
    UserRepository userRepository;

    /****** start user controller ******/
    @RequestMapping(value="/admin/users",method = RequestMethod.GET)
    public  String getUsers(ModelMap modelMap){
        // 查询user表中所有记录
        List<UserEntity> userList =userRepository.findAll();

        // 将所有记录传递给要返回的jsp页面，放在userList当中
        modelMap.addAttribute("userList", userList);

        // 返回pages目录下的admin/users.jsp页面
        return "admin/user/users";
   }

   @RequestMapping(value="/admin/users/add",method = RequestMethod.GET)
    public ModelAndView addUser(ModelMap modelMap){
       ModelAndView mv = new ModelAndView();
       UserEntity u = new UserEntity();
       mv.addObject("user",u);
       mv.setViewName("admin/user/addUser");
       return mv;
   }

   @RequestMapping(value="/admin/users/addPost",method = RequestMethod.POST)
    public ModelAndView addUserPost(@Valid @ModelAttribute("user") UserEntity userEntity,BindingResult br){
       ModelAndView mv = new ModelAndView();
        mv.addObject("user",userEntity);
       if (br.hasFieldErrors()) {
           mv.setViewName("admin/user/addUser");
       }else {
           userRepository.saveAndFlush(userEntity);
           mv.setViewName("redirect:/admin/users");
       }

        return mv;
   }

   @RequestMapping(value="/admin/users/show/{id}",method = RequestMethod.GET)
    public String UserDetail(@PathVariable("id") Integer userId,ModelMap modelMap){
        UserEntity userEntity=userRepository.findOne(userId);
        modelMap.addAttribute("user",userEntity);
        return "admin/user/userDetail";
   }

   @RequestMapping(value = "/admin/users/update/{id}",method = RequestMethod.GET)
    public String UpdateUser(@PathVariable("id") Integer userId,ModelMap modelMap){
        UserEntity userEntity=userRepository.findOne(userId);
        modelMap.addAttribute("user",userEntity);
        return "admin/user/updateUser";
   }
   @RequestMapping(value = "/admin/users/updatePost",method = RequestMethod.POST)
    public String UpdateUserPost(@ModelAttribute("userPost") UserEntity userpost){
        userRepository.update(userpost.getName(),userpost.getAge(),userpost.getSex(),userpost.getPhone(),userpost.getId());
        userRepository.flush();
        return "redirect:/admin/users";
   }
   @RequestMapping(value = "/admin/users/delete/{id}",method =RequestMethod.GET)
    public String DeleteUser(@PathVariable("id") Integer userId){
        userRepository.delete(userId);
        userRepository.flush();
        return "redirect:/admin/users";
   }
   /****** end user controller ******/


}


