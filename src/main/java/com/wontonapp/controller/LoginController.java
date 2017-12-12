package com.wontonapp.controller;

import com.wontonapp.model.AccountEntity;
import com.wontonapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    AccountRepository accountRepository;

    @RequestMapping(value = "/admin/login")
    public String Login(){
        return "/admin/login";
    }

    @RequestMapping(value = "/admin/loginpost",method = RequestMethod.POST)
    public String LoginPost(HttpSession session,@ModelAttribute("account") AccountEntity accountEntity){

        AccountEntity account=accountRepository.findByAccountNameAndPassword(accountEntity.getName(),accountEntity.getPassword());

        if(account==null)
            return "/admin/login";

        session.setAttribute("username",accountEntity.getName());
        return "redirect:/admin/users";
    }
    /**
     * 退出系统
     * @param session
     *          Session
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/admin/logout")
    public String logout(HttpSession session) throws Exception{
        //清除Session
        session.invalidate();

        return "/admin/login";
    }

}
