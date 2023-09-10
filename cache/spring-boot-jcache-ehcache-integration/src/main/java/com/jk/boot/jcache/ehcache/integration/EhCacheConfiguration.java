package com.jk.boot.jcache.ehcache.integration;


import com.jk.boot.jcache.ehcache.integration.domain.Book;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.expiry.ExpiryPolicy;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class EhCacheConfiguration {

    @Bean
    public JCacheManagerCustomizer bookStoreCache() {
        return (cacheManager) -> {
            CacheConfiguration<Integer, Book> ehCacheConfiguration = CacheConfigurationBuilder.newCacheConfigurationBuilder(Integer.class,
                    Book.class,
                    ResourcePoolsBuilder.heap(100)
                    ).withExpiry(ExpiryPolicy.NO_EXPIRY).build();
            javax.cache.configuration.Configuration<Integer, Book> jcacheConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(ehCacheConfiguration);
            cacheManager.createCache(BookService.BOOKSTORE_CACHE_NAME, jcacheConfiguration);
        };
    }

}
