package com.wontonapp.common.validator;

import com.wontonapp.model.AccountEntity;
import com.wontonapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AccountValidator implements Validator{

    @Autowired
    AccountRepository accountRepository;

    public boolean supports(Class<?> clazz) {
        return AccountEntity.class.equals(clazz);
    }
    @Override
    public void validate(Object obj, Errors e) {
        AccountEntity accountEntity=(AccountEntity)obj;

        ValidationUtils.rejectIfEmpty(e, "name", null, "账号不能为空");
        ValidationUtils.rejectIfEmpty(e, "password", null, "密码不能为空");

        if(accountEntity==null)
            return;

//        if (accountRepository.findByAccountName(accountEntity.getName())!=null)
//            e.rejectValue("name","已存在该账号");
    }
}
