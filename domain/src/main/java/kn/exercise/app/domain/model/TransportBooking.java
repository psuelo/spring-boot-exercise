package kn.exercise.app.domain.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TransportBooking {

	Long bookingId;
	
	Long bookedQuantity;
	
	String origin;

	String destination;
	
	String description;
	
	public boolean isValid() {
		boolean result = true;
		result &= bookingId != null;
		return result ;
	}

}
