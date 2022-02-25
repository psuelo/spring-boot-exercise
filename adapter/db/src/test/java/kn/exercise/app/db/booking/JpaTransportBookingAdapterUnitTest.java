package kn.exercise.app.db.booking;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

import kn.exercise.app.domain.model.TransportBooking;

@MockitoSettings
public class JpaTransportBookingAdapterUnitTest {

    @InjectMocks
    private JpaTransportBookingAdapter adapterUnderTest;

    @Mock
    private BookingRepository bookingRepository;

    @Test
    void shouldFindBooking() throws Exception {
        // given
        Long bookingId = 7L;
        Booking booking = Booking.builder()
                .bookingId(bookingId)
                .bookedQuantity(700L)
                .origin("Origin")
                .destination("Destination")
                .build();
        given(bookingRepository.findById(bookingId)).willReturn(Optional.of(booking));

        // when
        Optional<TransportBooking> result = adapterUnderTest.findTransportBooking(bookingId);

        // then
        assertThat(result).usingFieldByFieldValueComparator().contains(booking.toDomain());
    }

    @Test
    void shouldSaveBooking() throws Exception {
        // given
        Long bookingId = 7L;
        TransportBooking booking = TransportBooking.builder()
                .bookingId(bookingId)
                .bookedQuantity(700L)
                .origin("Origin")
                .destination("Destination")
                .build();
        
        // when
        adapterUnderTest.saveTransportBooking(booking);
        
        // then
        verify(bookingRepository).save(argThat(b -> b.getBookingId().equals(bookingId)));
    }

}
