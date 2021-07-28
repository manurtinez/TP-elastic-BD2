package manu.pruebaelastic;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import manu.pruebaelastic.model.Article;
import manu.pruebaelastic.services.ArticleService;

@SpringBootTest
class PruebaelasticApplicationTests {

	@Test
	void contextLoads() {
	}

	// @Autowired
	// @Qualifier("springDataJpaService")
	// ArticleService articleService;

	// protected ArticleService getService() {
	// return articleService;
	// }

	// @BeforeEach
	// public void setUp() {
	// this.articleService = this.getService();
	// }

	// @Test
	// public void testCreateArticle() {
	// Article art = new Article("un articulo");
	// assertNotNull(art.getId());
	// }

}
