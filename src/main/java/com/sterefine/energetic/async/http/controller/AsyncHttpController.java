package com.sterefine.energetic.async.http.controller;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.JdkFutureAdapters;
import com.google.common.util.concurrent.ListenableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import com.sterefine.energetic.async.http.service.TestAsyncService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author sterefine
 */
@RestController
@RequestMapping("/async")
@Slf4j
@EnableAsync
public class AsyncHttpController {
    @Autowired
    TestAsyncService testAsyncService;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello(){
        return "hello energetic!";
    }

    @RequestMapping(value = "sync", method = RequestMethod.GET)
    public String syncRequest() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("A");
        doSomeWork("A");
        stopWatch.stop();
        log.info("time {}", stopWatch.prettyPrint());
        return "hello energetic!";
    }

    @RequestMapping(value = "async", method = RequestMethod.GET)
    public String asyncRequest() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("B");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit( () -> doSomeWork("B"));
        executorService.shutdown();
        stopWatch.stop();
        log.info("time {}", stopWatch.prettyPrint());
        return "hello energetic!";
    }

    @RequestMapping(value = "async2", method = RequestMethod.GET)
    public String asyncRequest2() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("C");
        doSomeAsyncWork("C");
        stopWatch.stop();
        log.info("time {}", stopWatch.prettyPrint());
        return "hello energetic!";
    }

    @RequestMapping(value = "async3", method = RequestMethod.GET)
    public String asyncRequest3() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("D");
        testAsyncService.doSomeAsyncWork("D");
        stopWatch.stop();
        log.info("time {}", stopWatch.prettyPrint());
        return "hello energetic!";
    }

    @RequestMapping(value = "async4", method = RequestMethod.GET)
    public String asyncRequest4() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("E");
        Future<String> resultFuture = testAsyncService.doSomeAsyncWorkFuture("E");
        testAsyncService.handleCallBack(resultFuture);
        stopWatch.stop();
        log.info("time {}", stopWatch.prettyPrint());
        return "hello energetic!";
    }

    @RequestMapping(value = "async5", method = RequestMethod.GET)
    public String asyncRequest5() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("F");
        Future<String> resultFuture = testAsyncService.doSomeAsyncWorkListeningFuture("F");
        ListenableFuture<String> future = JdkFutureAdapters.listenInPoolThread(resultFuture);

        Futures.addCallback(future, new FutureCallback<String>() {
            @Override
            public void onSuccess(String result) {
                log.info("result {}" , result);
            }
            @Override
            public void onFailure(Throwable t) {
                log.error("error" , t);
            }
        });

        stopWatch.stop();
        log.info("time {}", stopWatch.prettyPrint());
        return "hello energetic!";
    }

    private void doSomeWork(String workName) {
        try {
            log.info("work {} start", workName);
            Thread.sleep(5000);
            log.info("work {} end", workName);
        }catch (InterruptedException e) {
            log.error("work {} interrupted", workName);
        }
    }

    @Async
    void doSomeAsyncWork(String workName) {
        try {
            log.info("work {} start", workName);
            Thread.sleep(5000);
            log.info("work {} end", workName);
        }catch (InterruptedException e) {
            log.error("work {} interrupted", workName);
        }
    }

}
