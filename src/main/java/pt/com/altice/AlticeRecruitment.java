package pt.com.altice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties
@EnableAutoConfiguration
@EnableCaching
@ComponentScan(basePackages = { "pt.com.altice" })
public class AlticeRecruitment {

	public static void main(String[] args) {
		SpringApplication.run(AlticeRecruitment.class, args);
	}
	
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("numbers");
    }

}
