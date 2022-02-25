package kn.mykn.track.overviews.technical.config;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.config.BeanDefinition;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class QualifiedBeanNameGeneratorUnitTest {

    @Test
    void shouldBuildDefaultBeanName() {
        // given
        final QualifiedBeanNameGenerator qualifiedBeanNameGenerator = new QualifiedBeanNameGenerator();
        final BeanDefinition beanDefinition = mock(BeanDefinition.class);
        given(beanDefinition.getBeanClassName()).willReturn("kn.mykn.track.overviews.VisCoOverviews");

        // when
        final String result = qualifiedBeanNameGenerator.buildDefaultBeanName(beanDefinition);

        // then
        then(result).isEqualTo("kn.mykn.track.overviews.VisCoOverviews");
    }

}
