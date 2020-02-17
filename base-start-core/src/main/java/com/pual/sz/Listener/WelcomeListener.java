package com.pual.sz.Listener;

/**
 * @author pual
 * @version 1.0.0
 * @Description TODO
 * @createTime 2019年08月23日 14:26:00
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;

import java.util.concurrent.atomic.AtomicBoolean;

@Order(LoggingApplicationListener.DEFAULT_ORDER+1)
public class WelcomeListener implements ApplicationListener<ApplicationPreparedEvent> {

    private static AtomicBoolean processed = new AtomicBoolean(false);

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent applicationPreparedEvent) {
        Logger log =  LoggerFactory.getLogger("base-start-core");

        if(processed.compareAndSet(false,true)){

            String text ="\n"+
                    "\n" +
                    "                    .__ _________________                           .___\n" +
                    "______  __ _______  |  /   __   \\______  \\           ____  ____   __| _/___________\n" +
                    "\\____ \\|  |  \\__  \\ |  \\____    /   /    /  ______ _/ ___\\/  _ \\ / __ |/ __ \\_  __ \\\n" +
                    "|  |_> >  |  // __ \\|  |__/    /   /    /  /_____/ \\  \\__(  <_> ) /_/ \\  ___/|  | \\/\n" +
                    "|   __/|____/(____  /____/____/   /____/            \\___  >____/\\____ |\\___  >__|\n" +
                    "|__|              \\/                                    \\/           \\/    \\/           (1.0.0)";
            log.info(text);
        }

    }
}
