package org.opengear.kie.server.springboot.kieserverspringboot;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.List;

@Component
@Primary
public class CustomInMemorySwaggerResourcesProvider implements SwaggerResourcesProvider {

    @Override
    public List<SwaggerResource> get() {
        SwaggerResource r = new SwaggerResource(){
            {
                setName("kie-server-user");
                setLocation("/rest/swagger.json");
                setSwaggerVersion("2.0");
            }
        };
        return Lists.newArrayList(r);
    }
}
