package com.jk.explore.boot.echo.service.sample;

import java.util.concurrent.CompletableFuture;

public interface Service {

    String success();

    String failure();

    String failureWithFallback();

    String successException();

    String ignoreException();

    CompletableFuture<String> futureSuccess();

    CompletableFuture<String> futureFailure();

    CompletableFuture<String> futureTimeout();

}
