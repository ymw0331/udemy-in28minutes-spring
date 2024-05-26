package com.wayneyong.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com/wayneyong/learnspringframework/game")
public class GaamingAppLauncherApplication {

    @Bean
    public GameRunner gameRunner(@Qualifier("SuperContraGameQualifier") GamingConsole game) {
        System.out.println("Parameter: " + game);
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }


    public static void main(String[] args) {
        try (var context =
                     new AnnotationConfigApplicationContext
                             (GaamingAppLauncherApplication.class)) {
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}
