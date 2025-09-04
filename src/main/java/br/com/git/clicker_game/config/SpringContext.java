package br.com.git.clicker_game.config;

import java.util.concurrent.CountDownLatch;
import org.springframework.context.ApplicationContext;

public final class SpringContext {

    private static ApplicationContext context;
    private static final CountDownLatch latch = new CountDownLatch(1);

    public static void setApplicationContext(ApplicationContext ctx) {
        context = ctx;
        latch.countDown();
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    public static void awaitContext() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static <T> T getBean(Class<T> beanClass) {
        if (context == null) throw new IllegalStateException("Spring context not initialized yet");
        return context.getBean(beanClass);
    }
    
}