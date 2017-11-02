package org.zhuonima.hystrix.controllers;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HiController {

    @GetMapping("/hi")
    public String hi() {
        return new HiHystrixCommand().execute();
    }

    private String hiFallback() {
        return "Hi Timeout.";
    }

    private class HiHystrixCommand extends HystrixCommand<String> {

        private HiHystrixCommand() {
            super(HystrixCommandGroupKey.Factory.asKey("hi"), 100);
        }

        @Override
        protected String run() throws Exception {
            try {
                Thread.sleep(new Random().nextInt(200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hi";
        }

        @Override
        protected String getFallback() {
            return HiController.this.hiFallback();
        }
    }
}
