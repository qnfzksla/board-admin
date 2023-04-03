package com.qnfzksla.projectboardadmin.repository;

import com.qnfzksla.projectboardadmin.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount,String> {
}

