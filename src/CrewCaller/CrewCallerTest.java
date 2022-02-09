package CrewCaller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CrewCallerTest {
	CrewInventory crewInventory;
	NumberLookup  numberLookup;
	CrewCaller crewCaller;
	

	
	@BeforeEach
	public void setup() {
		 crewInventory =Mockito.mock(CrewInventory.class);
		 numberLookup=Mockito.mock(NumberLookup.class);
		 crewCaller = new CrewCaller(crewInventory, numberLookup);
		
			}

	@Test
	void findCrewsToCall() {
				
		Date date = new Date();
		crewCaller.callCrews(date);
		Mockito.verify(crewInventory).findCrewsForDate(date);
	}
	
	@Test
	public void lookUpCrewPhoneNumber() {
		Date date =new Date();
		String name="Jessica";
		Mockito.when(crewInventory.findCrewsForDate(date))
		.thenReturn(Arrays.asList(name));
		
		crewCaller.callCrews(date);
		Mockito.verify(numberLookup).lookupNumber(name);
	}

}
