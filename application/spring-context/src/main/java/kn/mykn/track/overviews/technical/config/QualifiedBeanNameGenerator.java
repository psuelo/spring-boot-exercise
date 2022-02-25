package kn.mykn.track.overviews.technical.config;

import java.beans.Introspector;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

public class QualifiedBeanNameGenerator extends AnnotationBeanNameGenerator {

    @Override
    protected String buildDefaultBeanName(final BeanDefinition definition) {
        return Introspector.decapitalize(definition.getBeanClassName());
    }
}
