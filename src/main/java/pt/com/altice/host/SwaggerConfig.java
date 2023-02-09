package pt.com.altice.host;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final String TAG_ALTICCI_NUMBER = "Alticci Number";
	@Value("${versao}")
	private String versao;

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("pt.com.altice")).build()
				.apiInfo(apiInfo())
				.tags(new Tag(TAG_ALTICCI_NUMBER, 
				    "\nCalculate alticci number.The Alticci – a(n) - sequence is defined as follows:\n"
				    + "n=0 => a(0) = 0\n"
				    + "n=1 => a(1) = 1\n"
				    + "n=2 => a(2) = 1\n"
				    + "n>2 => a(n) = a(n-3) + a(n-2)"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Calculates Alticci Number")
				.version(versao).build();
	}
}
