package kn.exercise.app.booking.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.http.ResponseEntity;

import kn.exercise.app.domain.TransportBookingCrudUsecase;
import kn.exercise.app.domain.model.TransportBooking;

@MockitoSettings
public class BookingRestControllerUnitTest {

    @InjectMocks
    private BookingRestController controllerUnderTest;

    @Mock
    private TransportBookingCrudUsecase transportBookingCrudUsecase;
    
    
    @Test
    void shouldCreateBooking() throws Exception {
        // given
        Long bookingId = 7L;
        BookingResource bookingResource = BookingResource.builder()
                .bookingId(bookingId)
                .bookedQuantity(700L)
                .origin("Origin")
                .destination("Destination")
                .description("Description")
                .build();
        
        // when
        controllerUnderTest.createBooking(bookingId, bookingResource);
        
        // then
        verify(transportBookingCrudUsecase).saveBooking(argThat(b -> b.getBookingId().equals(bookingId)));
    }
    
    @Test
    void shouldFindBooking() {
        // given
        Long bookingId = 7L;
        TransportBooking transportBooking = TransportBooking.builder()
                .bookingId(bookingId)
                .bookedQuantity(700L)
                .origin("Origin")
                .destination("Destination")
                .description("Description")
                .build();
        given(transportBookingCrudUsecase.findBooking(bookingId)).willReturn(Optional.of(transportBooking));

        // when
        ResponseEntity<BookingResource> result = controllerUnderTest.findBooking(bookingId);

        // then
        assertThat(result.getBody()).usingRecursiveComparison().isEqualTo(BookingResource.fromDomain(transportBooking));
        
        
    }
}
