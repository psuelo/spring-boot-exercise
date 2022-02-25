package kn.exercise.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import kn.mykn.track.overviews.technical.config.QualifiedBeanNameGenerator;

@SpringBootApplication
public class ExerciseAppSite {

    public static void main(final String[] args) {
        final SpringApplication springApplication = new SpringApplication(ExerciseAppSite.class);
        springApplication.setBeanNameGenerator(new QualifiedBeanNameGenerator());
        springApplication.run(args);
    }
}
