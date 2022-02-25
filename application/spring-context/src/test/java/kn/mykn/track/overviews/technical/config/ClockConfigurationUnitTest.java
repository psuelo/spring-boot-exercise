package kn.mykn.track.overviews.technical.config;

import java.time.Clock;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ClockConfigurationUnitTest {

    @Test
    void shouldCreateSystemClockBean() {
        // given
        final ClockConfiguration clockConfiguration = new ClockConfiguration();

        // when
        final Clock clock = clockConfiguration.clock();

        // then
        assertThat(clock).isEqualTo(Clock.systemDefaultZone());
    }
}
