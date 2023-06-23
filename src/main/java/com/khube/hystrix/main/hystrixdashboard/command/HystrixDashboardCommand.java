package com.khube.hystrix.main.hystrixdashboard.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class HystrixDashboardCommand extends HystrixCommand<String> {

    public HystrixDashboardCommand() {
        super(HystrixCommandGroupKey.Factory.asKey("YourGroup"));
    }

    @Override
    protected String run() throws Exception {
        // Your code to be executed within the Hystrix command
        return "Result";
    }

    @Override
    protected String getFallback() {
        // Fallback method to be called when there is a failure or timeout
        return "Fallback Result";
    }
}