package kn.exercise.app.booking.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kn.exercise.app.domain.TransportBookingCrudUsecase;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookingRestController {

    private final TransportBookingCrudUsecase transportBookingCrudUsecase;
    
	@PutMapping("/booking/{bookingId}")
	public void createBooking(@PathVariable("bookingId") Long bookingId, @RequestBody final BookingResource bookingResource) {
		transportBookingCrudUsecase.saveBooking(bookingResource.toDomain(bookingId));
	}

	@GetMapping("/booking/{bookingId}")
	public ResponseEntity<BookingResource> findBooking(@PathVariable("bookingId") Long bookingId) {
	    return ResponseEntity.of(transportBookingCrudUsecase.findBooking(bookingId).map(BookingResource::fromDomain));
	}
}
