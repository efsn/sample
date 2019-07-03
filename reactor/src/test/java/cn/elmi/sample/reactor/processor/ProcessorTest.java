package cn.elmi.sample.reactor.processor;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.TopicProcessor;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ProcessorTest {

    public static final Logger log = LoggerFactory.getLogger(ProcessorTest.class);

    @Test
    public void testTopicProcessor() throws InterruptedException {

        TopicProcessor<Integer> topicProcessor = TopicProcessor.<Integer>builder()
                .share(true)
                .executor(Executors.newSingleThreadExecutor()).build();

        topicProcessor.replay(0).autoConnect();

        Flux<Integer> flux1 = topicProcessor.map(e -> e);
        Flux<Integer> flux2 = topicProcessor.map(e -> e);
        Flux<Integer> flux3 = topicProcessor.map(e -> e);

        AtomicInteger count = new AtomicInteger(0);
        flux1.subscribe(e -> {
            log.info("flux1 subscriber:{}", e);
            count.incrementAndGet();
        });

        flux2.subscribe(e -> {
            log.info("flux2 subscriber:{}", e);
        });

        flux3.subscribe(e -> {
            log.info("flux3 subscriber:{}", e);
        });

        IntStream.rangeClosed(1, 100).parallel().forEach(e -> {
            log.info("emit:{}", e);
            topicProcessor.onNext(e);
        });

        topicProcessor.onComplete();
        topicProcessor.blockLast();
        TimeUnit.SECONDS.sleep(10);
        System.out.println(count.get());
    }


}
