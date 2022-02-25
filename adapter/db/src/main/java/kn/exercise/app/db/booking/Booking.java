package kn.exercise.app.db.booking;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import kn.exercise.app.domain.model.TransportBooking;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "BOOKING")
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Booking {

    @Id
    Long bookingId;

    Long bookedQuantity;

    String origin;

    String destination;

    String description;

    public static Booking fromDomain(TransportBooking transportBooking) {
        return Booking.builder()
                .bookingId(transportBooking.getBookingId())
                .bookedQuantity(transportBooking.getBookedQuantity())
                .origin(transportBooking.getOrigin())
                .destination(transportBooking.getDestination())
                .description(transportBooking.getDescription())
                .build();
    }

    public TransportBooking toDomain() {
        return TransportBooking.builder()
                .bookingId(this.getBookingId())
                .bookedQuantity(this.getBookedQuantity())
                .origin(this.getOrigin())
                .destination(this.getDestination())
                .description(this.getDescription())
                .build();
    }
}
