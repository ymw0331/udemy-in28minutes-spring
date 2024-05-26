package com.wayneyong.learnspringframework;

import game.GameRunner;
import game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
            context.getBean(GamingConsole.class).up();

            context.getBean(GameRunner.class).run();
        }
    }

}
/**
 * 5. Spring is managing objects and performing auto-wiring.
 * - But arent we writing the code to create objects?
 * - How do we get Spring to create objects for us?
 */