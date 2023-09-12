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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
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
	private ServletWebServerApplicationContext webServerApplicationContext;

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
		int port = webServerApplicationContext.getWebServer().getPort();
		baseUrl = "http://localhost:"+port+"/jcache/api/v1/";
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
	void responseForFirstRequest() {
		String url = baseUrl + "books/1";
		ResponseEntity<Book> responseEntity = testRestTemplate.getForEntity(url, Book.class);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
		responseEntity.getStatusCode();
	}

	@Test
	void cachePersistenceWithMultiplePostAndGetCalls() {
		Book javaBook = createBook("Java", 100);
		ResponseEntity<Book> responseEntity = testRestTemplate.postForEntity(postUrl(), javaBook, Book.class);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(responseEntity.getBody().getId()).isEqualTo(100);
		assertThat(responseEntity.getBody().getName()).isEqualTo("Java");
		// assert the response from cache via GET call
		responseEntity = testRestTemplate.getForEntity(getUrl(100), Book.class);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody().getId()).isEqualTo(100);
		assertThat(responseEntity.getBody().getName()).isEqualTo("Java");
	}

	private Book createBook(String name, Integer id) {
		Book.Builder bookBuilder = Book.Builder.getInstance();
		return bookBuilder.id(id).name(name).build();
	}

	private String postUrl() {
		return baseUrl + "books";
	}

	private String getUrl(Integer id) {
		return baseUrl + "books/"+id.intValue();
	}
}
