package org.zhuonima.helloservice.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RefreshScope
@RestController
public class HelloController {

    @Value("${hello.message}")
    private String message;

    @GetMapping("/hello-service")
    public Map<String, Object> hello() {
        ClassPathResource resource = new ClassPathResource("hello-service.conf");
        return Collections.singletonMap(message, resource.getFilename());
    }
}
