package kn.exercise.app.domain.port;

import java.util.Optional;

import kn.exercise.app.domain.model.TransportBooking;

public interface TransportBookingDbPort {

	void saveTransportBooking(TransportBooking transportBooking);
	
	Optional<TransportBooking> findTransportBooking(Long bookingId);
}
