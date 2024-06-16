package org.opengear.kie.server.springboot.kieserverspringboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.PathProvider;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.DefaultPathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.plugins.DocumentationPluginsManager;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContext;

@Configuration
@EnableSwagger2
public class MyXConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean
    @Primary
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("kie-server-user")
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.opengear.kie.server.springboot.kieserverspringboot"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket api2() {
        ApiInfo apiInfo = new ApiInfo("KIE Server API", "KIE Server API", "1.0", "urn:tos", "KIE Server API", "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("kie-server")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo)
                .host("www.baidu.com")
                .pathProvider(new PathProvider() {

                    @Override
                    public String getOperationPath(String operationPath) {
                        return "http://biadu.com/kie-server/rest/swagger.json";
                    }

                    @Override
                    public String getResourceListingPath(String groupName, String apiDeclaration) {
                        return "http://biadu.com/kie-server/rest/swagger.json";
                    }
                });
//                .plugins(new ReusablePlugin[]{new DocumentationPluginsManager()});
    }
}
