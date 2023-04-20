package com.qnfzksla.projectboardadmin.repository;

import com.qnfzksla.projectboardadmin.domain.AdminAccount;
import com.qnfzksla.projectboardadmin.domain.constant.RoleType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("JPA 연결 테스트")
@Import(JpaRepositoryTest.TestJpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {
    
    private final AdminAccountRepository adminAccountRepository;


    public JpaRepositoryTest(@Autowired AdminAccountRepository adminAccountRepository) {
        this.adminAccountRepository = adminAccountRepository;
    }

    @DisplayName("회원 정보 select 테스트")
    @Test
    void givenAdminAcounts_whenSelecting_thenWorksFine(){

        //Given

        //When
        List<AdminAccount> adminAccounts = adminAccountRepository.findAll();

        //Then
        assertThat(adminAccounts)
                .isNotNull()
                .hasSize(4);



    }


    @DisplayName("회원 정보 insert 테스트")
    @Test
    void givenAdminAcounts_wheninserting_thenWorksFine(){

        //Given
        long previousCount = adminAccountRepository.count();
        AdminAccount adminAccount = AdminAccount.of("test","1234", Set.of(RoleType.DEVELOPER),null,null,null);



        //When
        adminAccountRepository.save(adminAccount);

        //Then
        assertThat(adminAccountRepository.count()).isEqualTo(previousCount + 1);




    }

    @DisplayName("회원 정보 update 테스트")
    @Test
    void givenAdminAccountAndRoleType_whenUpdating_thenWorksFine(){

        //Given
        AdminAccount adminAccount = adminAccountRepository.getReferenceById("uno");
        adminAccount.addRoleType(RoleType.DEVELOPER);
        adminAccount.addRoleTypes(List.of(RoleType.USER,RoleType.USER));
        adminAccount.removeRoleType(RoleType.ADMIN);



        //When
        AdminAccount updatedAccount = adminAccountRepository.saveAndFlush(adminAccount);

        //Then
        assertThat(updatedAccount)
                .hasFieldOrPropertyWithValue("userId","uno")
                .hasFieldOrPropertyWithValue("roleTypes",Set.of(RoleType.DEVELOPER,RoleType.USER));

     /**AdminAccountRepository는 SpringData JPA에서 제공하는 JpaRepository 인터페이스를 확장하는 JPA 리포지토리 인터페이스의 인스턴스입니다.
      * 이 인터페이스는 엔티티에 대한 CRUD(Create, Read, Update, Delete) 작업뿐만 아니라 데이터를 쿼리하고 조작하는 다른 방법을 제공합니다.
      *
      saveAndFlush() 메서드는 엔티티가 데이터베이스에 저장된 후 업데이트된 인스턴스를 반환합니다.
      이 경우 업데이트된 엔티티는 AdminAccount 유형의 업데이트된 Account 변수에 할당됩니다.
      *  기타 필드가 포함된 업데이트된 엔티티가 포함됩니다.
      * */


    }


    @DisplayName("회원 정보 delete 테스트")
    @Test
    void givenAdminAccounts_whenDeleting_thenWorksFine(){

        //Given
        long previousCount = adminAccountRepository.count();

        AdminAccount adminAccount = adminAccountRepository.getReferenceById("uno");



        //When
        adminAccountRepository.delete(adminAccount);

        //Then
        assertThat(adminAccountRepository.count()).isEqualTo(previousCount -1);




    }



    @EnableJpaAuditing
    @TestConfiguration
    static class TestJpaConfig {
        @Bean
        AuditorAware<String> auditorAware() {
            return () -> Optional.of("uno");
        }
    }

    /**
     * @EnableJpaAudit은 SpringBoot 응용 프로그램에 대한 JPA 감사를 활성화하는 주석입니다.
     * JPA 감사는 createdBy, createdDate, lastModifiedBy 및 lastModifiedDate와 같은 감사 관련 필드를 자동으로 입력합니다.
     * 주석을 사용하면 JPA 감사가 활성화된 엔티티를 검색할 기본 패키지를 지정할 수 있습니다.
     *
     * @TestConfiguration은 SpringBoot에서 테스트 중에만 사용되는 구성 클래스를 정의하는 데 사용되는 주석입니다.
     * 이 경우 테스트 중에 사용할 JPA에 대한 구성 클래스를 정의합니다.
     *
     * TestJpaConfig 클래스에는 AuditorAware<String>의 인스턴스를 반환하는 메서드 auditorAware()가 포함되어 있습니다.
     * 감사자 인식 인터페이스는 엔티티의 현재 감사자(즉, 엔티티를 생성하거나 마지막으로 수정한 사용자)를 제공하는 데 사용됩니다.
     * 이 경우 감사자는 "uno"로 하드 코딩됩니다.*/
}