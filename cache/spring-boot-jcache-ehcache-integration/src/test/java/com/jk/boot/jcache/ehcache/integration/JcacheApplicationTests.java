package com.jk.boot.jcache.ehcache.integration;

import com.jk.boot.jcache.ehcache.integration.domain.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(
		classes = JcacheApplication.class,
		webEnvironment = RANDOM_PORT,
		properties = {
			"server.servlet.context-path=/jcache"
		}
)
class JcacheApplicationTests {
	@Autowired
	private ServletWebServerApplicationContext webServerAppCtxt;

	@Autowired
	private JCacheCacheManager jCacheCacheManager;

	@Autowired
	private CacheManager springCacheManager;

	@Autowired
	private TestRestTemplate testRestTemplate;

	private String baseUrl;

	@BeforeEach
	void init() {
		testRestTemplate = new TestRestTemplate();
		int port = webServerAppCtxt.getWebServer().getPort();
		baseUrl = "http://localhost:"+port+"/jcache/";
	}

	@Test
	void assertCacheRelatedObjects() {
		assertNotNull(jCacheCacheManager);
		assertNotNull(springCacheManager);
	}

	@Test
	void assertThatCacheIsCreated() {
		Cache springCache = springCacheManager.getCache(BookService.BOOKSTORE_CACHE_NAME);
		assertNotNull(springCache);
	}

	@Test
	void cacheCalls() {
		String url = baseUrl + "/books/1";
		ResponseEntity<Book> responseEntity = testRestTemplate.getForEntity(url, Book.class);
		assertNotNull(responseEntity);
		responseEntity.getStatusCode();

	}
}
