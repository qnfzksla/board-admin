package com.qnfzksla.projectboardadmin.service;

import com.qnfzksla.projectboardadmin.dto.ArticleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor //자동 생상자 주입
@Service
public class ArticleManagementService {
    public List<ArticleDto> getArticles(){
        return List.of();
    }

    public ArticleDto getArticle(Long articleId){
        return null;
    }
    public void deleteArticle(Long articleId){

    }
}
