package CrewCaller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CrewCallerTest {
	CrewInventory crewInventory;
	NumberLookup numberLookup;
	CrewCaller crewCaller;
	PhoneDialer phoneDialer;
	Date date = new Date();

	@BeforeEach
	public void setup() {
		crewInventory = Mockito.mock(CrewInventory.class);
		numberLookup = Mockito.mock(NumberLookup.class);
		phoneDialer = Mockito.mock(PhoneDialer.class);
		crewCaller = new CrewCaller(crewInventory, numberLookup, phoneDialer);

	}

	@Test
	void findCrewsToCall() {

		crewCaller.callCrews(date);
		Mockito.verify(crewInventory).findCrewsForDate(date);
	}

	@Test
	public void lookUpCrewPhoneNumber() {

		String name = "Jessica";

		Mockito.when(crewInventory.findCrewsForDate(date)).thenReturn(Arrays.asList(name));

		crewCaller.callCrews(date);
		Mockito.verify(numberLookup).lookupNumber(name);
	}

	@Test
	public void dialCrewPhoneNumber() {

		String name = "Jessica";
		String phoneNumber = "402-590-6955";
		Mockito.when(crewInventory.findCrewsForDate(date)).thenReturn(Arrays.asList(name));
		Mockito.when(numberLookup.lookupNumber(name)).thenReturn(phoneNumber);
		Mockito.verify(phoneDialer).dialNumber(phoneNumber);

	}

}
