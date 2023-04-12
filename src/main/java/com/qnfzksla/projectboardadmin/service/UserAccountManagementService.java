package com.qnfzksla.projectboardadmin.service;

import com.qnfzksla.projectboardadmin.dto.UserAccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserAccountManagementService {

    public List<UserAccountDto> getUserAccounts(){
        return List.of();
    }

    public UserAccountDto getUserAccount(String userId){
        return null;
    }

    public void deleteUserAccount(String userId){

    }
}
