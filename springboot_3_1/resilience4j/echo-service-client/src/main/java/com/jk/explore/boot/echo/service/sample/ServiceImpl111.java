package com.jk.explore.boot.echo.service.sample;

import java.util.concurrent.CompletableFuture;

public class ServiceImpl111 implements Service {
    @Override
    public String success() {
        return null;
    }

    @Override
    public String failure() {
        return null;
    }

    @Override
    public String failureWithFallback() {
        return null;
    }

    @Override
    public String successException() {
        return null;
    }

    @Override
    public String ignoreException() {
        return null;
    }

    @Override
    public CompletableFuture<String> futureSuccess() {
        return null;
    }

    @Override
    public CompletableFuture<String> futureFailure() {
        return null;
    }

    @Override
    public CompletableFuture<String> futureTimeout() {
        return null;
    }
}
