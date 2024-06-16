package org.opengear.kie.server.springboot.kieserverspringboot;

import org.apache.http.HttpRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Base64;


class KieServerSpringbootApplicationTests {

    public static void main(String[] args) throws URISyntaxException {
//        CloseableHttpClient client = HttpClients.createDefault();
//
//        // 构建请求体，这里假设你的规则需要一个名为"input"的Fact，类型为String
//        String requestBody = "{ \"lookup\": \"defaultKieSession\", \"commands\": [ { \"insert\": { \"object\": { \"com.example.Fact\": { \"input\": \"hello\" } }, \"out-identifier\": \"fact\" } }, { \"fire-all-rules\": { } } ] }";
//
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(new URI("http://localhost:8080/kie-server/services/rest/server/containers/instances/pxxx-1.0.0-20240616.170243-1"))
//                .header("Content-Type", "application/json")
//                .header("Authorization", "Basic " + Base64.getEncoder().encodeToString("kieserver:kieserver1!".getBytes())) // 使用你的用户名和密码
//                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
//                .build();
//
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//        System.out.println(response.body());
    }
}
