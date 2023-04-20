package com.qnfzksla.projectboardadmin.controller;

import com.qnfzksla.projectboardadmin.dto.response.ArticleResponse;
import com.qnfzksla.projectboardadmin.service.ArticleManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@RequestMapping("/management/articles")
@Controller /**게시글 관리 뷰*/
public class ArticleManagementController {

    private final ArticleManagementService articleManagementService;
    @GetMapping
    public String articles(Model model) {

        model.addAttribute(
                "articles",
                articleManagementService.getArticles().stream().map(ArticleResponse::withoutContent).toList()
        );

        return "management/articles";
    }

    @ResponseBody
    @GetMapping("/{articleId}")
    public ArticleResponse article(@PathVariable Long articleId) {
        return ArticleResponse.withContent(articleManagementService.getArticle(articleId));
    }

    @PostMapping("/{articleId}")
    public String deleteArticle(@PathVariable Long articleId) {
        articleManagementService.deleteArticle(articleId);

        return "redirect:/management/articles";
    }
}
