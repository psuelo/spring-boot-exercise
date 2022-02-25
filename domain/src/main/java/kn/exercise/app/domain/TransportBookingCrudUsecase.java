package kn.exercise.app.domain;

import java.util.Optional;

import org.springframework.stereotype.Component;

import kn.exercise.app.domain.model.TransportBooking;
import kn.exercise.app.domain.port.TransportBookingDbPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TransportBookingCrudUsecase {
	
    private final TransportBookingDbPort transportBookingDbPort;
    
	public boolean saveBooking(TransportBooking transportBooking) {
		boolean isValidBooking = transportBooking.isValid();
        if (isValidBooking) {
			transportBookingDbPort.saveTransportBooking(transportBooking);
		}
        
        return isValidBooking;
	}

	public Optional<TransportBooking> findBooking(Long bookingId) {
	    return transportBookingDbPort.findTransportBooking(bookingId);
	}
}
