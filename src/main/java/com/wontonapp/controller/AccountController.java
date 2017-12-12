package com.wontonapp.controller;

import com.wontonapp.common.validator.AccountValidator;
import com.wontonapp.model.AccountEntity;
import com.wontonapp.repository.AccountRepository;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AccountController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new AccountValidator());
    }

    @Autowired
    AccountRepository accountRepository;

    /****** start account controller ******/
    @RequestMapping(value="/admin/accounts/{id}",method = RequestMethod.GET)
    public String Account(@PathVariable("id") int userid, ModelMap modelMap){
        List<AccountEntity> accounts= accountRepository.findALLByUserid(userid);
        modelMap.addAttribute("accountList",accounts);
        modelMap.addAttribute("userid",userid);
        return "admin/account/accounts";
    }
   @RequestMapping(value = "/admin/accounts/add/{userid}")
    public ModelAndView AddAccount(@PathVariable("userid") int userId){
       ModelAndView modelAndView=new ModelAndView();
       AccountEntity accountEntity=new AccountEntity();
       accountEntity.setUserid(userId);
       modelAndView.addObject("account",accountEntity);
       modelAndView.setViewName("/admin/account/addAccount");
       return modelAndView;
    }
    @RequestMapping(value = "/admin/accounts/addpost",method = RequestMethod.POST)
    public ModelAndView AddAccountPost(@Valid @ModelAttribute("account") AccountEntity account, BindingResult br){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("account",account);

        AccountEntity accountEntity=accountRepository.findByAccountNameAndPassword(account.getName(),account.getPassword());
        if (accountEntity!=null) {
            br.addError(new FieldError("account","name","已存在该账号"));
        }
        if (br.hasFieldErrors()) {
            modelAndView.setViewName("/admin/account/addAccount");
        }else {
            accountRepository.saveAndFlush(account);
            modelAndView.setViewName("redirect:/admin/accounts/"+account.getUserid());
        }
        return modelAndView;
    }
    @RequestMapping(value="/admin/accounts/update/{id}",method = RequestMethod.GET)
    public ModelAndView UpdateAccount(@Valid @PathVariable("id") Integer id){
        ModelAndView modelAndView=new ModelAndView();
        AccountEntity accountEntity=accountRepository.findOne(id);
        modelAndView.addObject("account",accountEntity);
        modelAndView.addObject("userid",accountEntity.getUserid());
        modelAndView.setViewName("/admin/account/updateAccount");
        return  modelAndView;
    }
    @RequestMapping(value = "/admin/accounts/updatepost",method = RequestMethod.POST)
    public ModelAndView UpdateAccountPost(@Valid @ModelAttribute("account") AccountEntity account,BindingResult br){
        ModelAndView mv = new ModelAndView();
        if (br.hasFieldErrors()) {
            mv.setViewName("admin/account/updateAccount");
        }else {
            accountRepository.update(account.getName(),account.getPassword(),account.getId());
            mv.setViewName("redirect:/admin/accounts/"+account.getUserid());
        }
        return mv;
    }
    @RequestMapping(value = "/{id}/{userid}/admin/account/delete",method =RequestMethod.GET)
    public String DeleteAccount(@PathVariable("id") Integer id,@PathVariable("userid") Integer userId){
        accountRepository.delete(id);
        accountRepository.flush();
        return "redirect:/admin/accounts/"+userId;
    }
    /****** end account controller ******/
}
