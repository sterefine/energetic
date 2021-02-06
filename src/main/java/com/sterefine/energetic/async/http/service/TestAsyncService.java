package com.sterefine.energetic.async.http.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author sterefine
 */

@Slf4j
@Service
public class TestAsyncService {

    @Async
    public void doSomeAsyncWork(String workName) {
        try {
            log.info("work {} start", workName);
            Thread.sleep(5000);
            log.info("work {} end", workName);
        }catch (InterruptedException e) {
            log.error("work {} interrupted", workName);
        }
    }

    @Async("asyncPoolExecutor")
    public Future<String> doSomeAsyncWorkFuture(String workName) {
        try {
            log.info("work {} start", workName);
            Thread.sleep(5000);
            log.info("work {} end", workName);
            return new AsyncResult<>("work " + workName + " OK");
        }catch (InterruptedException e) {
            log.error("work {} interrupted", workName);
            throw new RuntimeException(e);
        }
    }

    @Async("asyncPoolListeningExecutor")
    public Future<String> doSomeAsyncWorkListeningFuture(String workName) {
        try {
            log.info("work {} start", workName);
            Thread.sleep(5000);
            log.info("work {} end", workName);
            return new AsyncResult<>("work " + workName + " OK");
        }catch (InterruptedException e) {
            log.error("work {} interrupted", workName);
            throw new RuntimeException(e);
        }
    }

    @Async("asyncPoolExecutor")
    public void handleCallBack(Future<String> future) {
        try {
            String result = future.get(3000, TimeUnit.MILLISECONDS);
            log.info("The result of future is {}", result );
        } catch (Exception e) {
            log.error("Exception: ", e);
        }
    }
}
