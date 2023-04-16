package com.qnfzksla.projectboardadmin.domain.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor /**자동 생성자여서 생성자 x*/
/**이름 권한 주기*/
public enum RoleType {

    USER("ROLE_USER","사용자"),
    MANAGER("ROLE_MANAGER","운영자"),
    DEVELOPER("ROLE_LOPER","개발자"),
    ADMIN("ROLE_ADMIN","관리자");

    @Getter
    private final  String roleName;
    @Getter
    private final  String descrption;




}
