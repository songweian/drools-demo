package org.opengear.kie.server.springboot.kieserverspringboot;

public class Result {
    private String name;
    private String status;

    public Result(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}
