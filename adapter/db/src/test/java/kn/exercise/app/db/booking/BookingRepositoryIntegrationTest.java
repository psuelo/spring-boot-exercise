package kn.exercise.app.db.booking;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import kn.exercise.app.db.DbConfiguration;

@DataJpaTest
@ContextConfiguration(classes = DbConfiguration.class)
@ActiveProfiles({ "db", "db-local-h2" })
public class BookingRepositoryIntegrationTest{

	@Autowired
	private BookingRepository repoUnderTest;
	
	@Test
	void shouldSaveBooking() throws Exception {
		//given
		long bookingId = 1L;
		Booking booking = Booking.builder().bookingId(bookingId).bookedQuantity(7L).origin("Hamburg").destination("Dresden").description("Some goods").build();
		
		//when
		repoUnderTest.save(booking);

		//then
		Optional<Booking> result = repoUnderTest.findById(bookingId);
		assertThat(result).usingFieldByFieldValueComparator().contains(booking);
	}
	
}
