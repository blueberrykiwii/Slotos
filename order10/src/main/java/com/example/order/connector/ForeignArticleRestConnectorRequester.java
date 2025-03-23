// Connector für Artikel-Kommunikation
package com.example.order.connector;

import com.example.order.dto.ArticleDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "article")
public interface ForeignArticleRestConnectorRequester {

    // Ändere den Rückgabetyp von 'Article' zu 'ArticleDTO'
    @GetMapping("/articles/{articleId}")
    ArticleDTO getArticle(@PathVariable("articleId") String articleId);
}