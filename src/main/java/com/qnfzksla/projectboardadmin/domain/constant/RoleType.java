package com.qnfzksla.projectboardadmin.domain.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor /**자동 생성자여서 생성자 x*/
/**이름 권한 주기*/
public enum RoleType {

    USER("ROLE_USER"),
    MANAGER("ROLE_MANAGER"),
    DEVELOPER("ROLE_LOPER"),
    ADMIN("ROLE_ADMIN");

    @Getter
    private final  String roleName;


}
