package com.qnfzksla.projectboardadmin.service;

import com.qnfzksla.projectboardadmin.dto.ArticleCommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // 자동 생성자 주입
@Service
public class ArticleCommentManagementService {

    public List<ArticleCommentDto> getArticleComments(){
        return List.of();
    }
    public ArticleCommentDto getArticleComment(Long articleCommentId){
        return null;
    }
    public void deleteArticleComment(Long articleCommentId){

    }

}
