package com.qnfzksla.projectboardadmin.service;

import com.qnfzksla.projectboardadmin.domain.AdminAccount;
import com.qnfzksla.projectboardadmin.domain.constant.RoleType;
import com.qnfzksla.projectboardadmin.dto.AdminAccountDto;
import com.qnfzksla.projectboardadmin.repository.AdminAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Transactional
@Service
public class AdminAccountService {

    private final AdminAccountRepository adminAccountRepository;
  @Transactional(readOnly = true)
    public Optional<AdminAccountDto> searchUser(String username){
        return adminAccountRepository.findById(username)
                .map(AdminAccountDto::from);

    }

    public AdminAccountDto saveUser(String username, String password, Set<RoleType> roleTypes,String email, String nickname, String memo){
      return AdminAccountDto.from(adminAccountRepository.save(AdminAccount.of(username, password, roleTypes, email, nickname, memo)));
    }
@Transactional(readOnly = true)
    public List<AdminAccountDto> users(){

      return adminAccountRepository.findAll().stream()
              .map(AdminAccountDto::from)
              .toList();
    }

    public void deleteUser(String username){

      adminAccountRepository.deleteById(username);

    }

}
