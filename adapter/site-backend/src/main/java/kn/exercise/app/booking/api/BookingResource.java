package kn.exercise.app.booking.api;

import kn.exercise.app.domain.model.TransportBooking;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingResource {

    Long bookingId;

    Long bookedQuantity;

    String origin;

    String destination;

    String description;

    public static BookingResource fromDomain(TransportBooking transportBooking) {
        return BookingResource.builder()
                .bookingId(transportBooking.getBookingId())
                .bookedQuantity(transportBooking.getBookedQuantity())
                .origin(transportBooking.getOrigin())
                .destination(transportBooking.getDestination())
                .description(transportBooking.getDescription())
                .build();
    }

    public TransportBooking toDomain(Long bookingId) {
        return TransportBooking.builder()
                .bookingId(bookingId)
                .bookedQuantity(this.getBookedQuantity())
                .origin(this.getOrigin())
                .destination(this.getDestination())
                .description(this.getDescription())
                .build();
    }
}
