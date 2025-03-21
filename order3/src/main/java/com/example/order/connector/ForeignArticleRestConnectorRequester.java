// Connector für Artikel-Kommunikation
package com.example.order.connector;

import com.example.article.component.structure.Article;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "article-service")
public interface ForeignArticleRestConnectorRequester {

    // Ändere den Parameter von 'int' zu 'String', da du mit String-IDs arbeitest
    @GetMapping("/articles/{articleId}")
    Article getArticle(@PathVariable("articleId") String articleId);
}
