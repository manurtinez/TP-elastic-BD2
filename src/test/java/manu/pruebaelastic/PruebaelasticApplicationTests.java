package manu.pruebaelastic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import manu.pruebaelastic.model.Author;
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

	protected ArticleService getArticleService() {
		return articleService;
	}

	@BeforeEach
	public void setUp() {
		this.articleService = this.getArticleService();
	}

	@Test
	public void testCreateArticle() {
		Article art = new Article("an article12");
		Author auth = new Author("manuelito");
		art.setAuthor(auth);
		Article newArt = articleService.addArticle(art);
		assertNotNull(newArt.getId());
		assertEquals("an article12", newArt.getTitle());
		assertEquals("manuelito", newArt.getAuthor().getName());
	}

}
