package kn.exercise.app.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TransportBookingUnitTest {

    
    @Test
    void shouldBeValid() throws Exception {
        //given
        TransportBooking transportBooking = TransportBooking.builder().bookingId(7L).build();
        
        //when
        boolean result = transportBooking.isValid();
        
        //then
        assertThat(result).isTrue();
    }
}
