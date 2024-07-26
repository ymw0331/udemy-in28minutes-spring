package com.wayneyong.learnspringframework.examples.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component //default is a singleton
class NormalClass {

}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass {


}

@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {

    public static void main(String[] args) {
        try (var context =
                     new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class)) {

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            //Singleton = one object instance per Spring Ioc Container
            System.out.println(context.getBean(NormalClass.class)); //same hashcode (same instance of NormalClass)
            System.out.println(context.getBean(NormalClass.class)); //same hashcode
            System.out.println(context.getBean(NormalClass.class)); //same hashcode
            System.out.println(context.getBean(NormalClass.class)); //same hashcode

            //Prototype = possibly many object instances per Spring Ioc Container
            System.out.println(context.getBean(PrototypeClass.class)); //new hashcode (diff instance of PrototypeClass)
            System.out.println(context.getBean(PrototypeClass.class)); //new hashcode
            System.out.println(context.getBean(PrototypeClass.class)); //new hashcode

        }
    }
}
