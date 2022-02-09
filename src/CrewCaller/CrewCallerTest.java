package CrewCaller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CrewCallerTest {

	@Test
	void findCrewsToCall() {
		CrewInventory crewInventory =Mockito.mock(CrewInventory.class);
		CrewCaller crewCaller = new CrewCaller(crewInventory);
		
		Date date = new Date();
		crewCaller.callCrews(date);
		Mockito.verify(crewInventory).findCrewsForDate(date);
	}

}
