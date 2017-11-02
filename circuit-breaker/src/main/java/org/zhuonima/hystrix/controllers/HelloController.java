package org.zhuonima.hystrix.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HelloController {


    @GetMapping("/hello")
    @HystrixCommand(
        groupKey = "hello",
        commandKey = "hello-command",
        threadPoolKey = "hello-thread-pool-key",
        commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
        },
        fallbackMethod = "helloFallback"
    )
    public String hello() {

        int seed = new Random().nextInt(200);

        try {
            Thread.sleep(seed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Hello！";
    }

    public String helloFallback() {
        return "Timeout.";
    }
}
