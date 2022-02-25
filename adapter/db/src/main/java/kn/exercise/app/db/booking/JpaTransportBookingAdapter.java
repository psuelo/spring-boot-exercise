package kn.exercise.app.db.booking;

import java.util.Optional;

import org.springframework.stereotype.Component;

import kn.exercise.app.domain.model.TransportBooking;
import kn.exercise.app.domain.port.TransportBookingDbPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JpaTransportBookingAdapter implements TransportBookingDbPort{

	private final BookingRepository bookingRepository;
	
	@Override
	public void saveTransportBooking(TransportBooking transportBooking) {
		bookingRepository.save(Booking.fromDomain(transportBooking));
	}

    @Override
    public Optional<TransportBooking> findTransportBooking(Long bookingId) {
        return bookingRepository.findById(bookingId).map(Booking::toDomain);
    }
}
