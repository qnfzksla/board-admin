package com.qnfzksla.projectboardadmin.dto.response;

import com.qnfzksla.projectboardadmin.domain.constant.RoleType;
import com.qnfzksla.projectboardadmin.dto.AdminAccountDto;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public record AdminAccountResponse(
        String userId,
        String roleTypes,
        String email,
        String nickname,
        String memo,
        LocalDateTime createdAt,
        String createdBy


) {
    public static AdminAccountResponse of( String userId, String roleTypes, String email, String nickname, String memo, LocalDateTime createdAt, String createdBy){
        return new AdminAccountResponse(userId, roleTypes, email, nickname, memo, createdAt, createdBy);
    }
    public static AdminAccountResponse from(AdminAccountDto dto){
        return AdminAccountResponse.of(
                dto.userId(),
                dto.roleTypes().stream()
                        .map(RoleType::getRoleName)
                        .collect(Collectors.joining(", ")),
                dto.email(),
                dto.nickname(),
                dto.memo(),
                dto.createdAt(),
                dto.createdBy()
        );
    }
}
