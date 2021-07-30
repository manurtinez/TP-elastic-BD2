package manu.pruebaelastic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import manu.pruebaelastic.model.Article;
import manu.pruebaelastic.services.ArticleService;

@SpringBootTest
class PruebaelasticApplicationTests {

	@Autowired
	ArticleService articleService;

	protected ArticleService getService() {
		return articleService;
	}

	@BeforeEach
	public void setUp() {
		this.articleService = this.getService();
	}

	@Test
	public void testCreateArticle() {
		Article art = new Article("an article");
		Article newArt = articleService.addArticle(art);
		assertNotNull(newArt.getId());
		assertEquals("an article", newArt.getTitle());
		;
	}

}
