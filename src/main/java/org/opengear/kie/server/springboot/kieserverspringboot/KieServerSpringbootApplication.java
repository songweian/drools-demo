package org.opengear.kie.server.springboot.kieserverspringboot;

import org.jbpm.services.api.DeploymentService;
import org.jbpm.services.api.ProcessService;
import org.jbpm.services.api.model.DeployedUnit;
import org.kie.api.KieServices;
import org.kie.api.definition.rule.Rule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.kie.server.api.model.KieContainerResource;
import org.kie.server.api.model.ReleaseId;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.services.api.KieServer;
import org.kie.server.services.drools.DroolsKieServerExtension;
import org.kie.server.services.drools.RulesExecutionService;
import org.kie.server.services.impl.ContainerManager;
import org.kie.server.services.swagger.SwaggerKieServerExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KieServerSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(KieServerSpringbootApplication.class, args);
    }

    @Bean
    public SwaggerKieServerExtension swaggerKieServerExtension() {
        return new SwaggerKieServerExtension();
    }


    @Autowired
    private DeploymentService deploymentService;
    @Autowired
    private ProcessService processService;
    @Autowired
    private KieServer kieServer;
    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            KieServices kieServices = KieServices.Factory.get();
            ServiceResponse<KieContainerResource> containerInfo =
                    kieServer.getContainerInfo("pxxx_1.0.0-SNAPSHOT");
            org.kie.api.builder.ReleaseId newReleaseId = kieServices.newReleaseId("com.myspace", "pxxx", "1.0.0-SNAPSHOT");
            KieContainerResource result1 = containerInfo.getResult();
//            com.myspace:pxxx:1.0.0-SNAPSHOT
            ReleaseId releaseId = result1.getReleaseId();

            KieContainer kc = kieServices.newKieContainer(newReleaseId);
//            KieContainer kc = kieServices.getKieClasspathContainer("pxxx_1.0.0-SNAPSHOT");
//            KieContainer kc = kieServices.getKieClasspathContainer("pxxx_1.0.0-SNAPSHOT");
//            KieContainer kc = kieServices.newKieContainer(kieServices.newReleaseId("com.myspace", "pxxx", "1.0.0-SNAPSHOT"));
            KieSession kieSession = kc.newKieSession();
            // 插入数据
            Student student = new Student();
            student.setName("张三");
            student.setAge(20);
            kieSession.insert(student);
            // 触发所有规则
            kieSession.fireAllRules();

            // 查询结果
            QueryResults results = kieSession.getQueryResults("getResult");
            for (QueryResultsRow row : results) {
                Result result = (Result) row.get("result");
                System.out.println(result.getName() + ": " + result.getStatus());
            }
        };
    }
}
