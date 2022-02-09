package CrewCaller;

import java.util.Date;

public class CrewCaller {
	private CrewInventory crewInventory;

	public CrewCaller( CrewInventory crewInventory) {
		this.crewInventory=crewInventory;
		
	}

	public void callCrews(Date date) {
		this.crewInventory.findCrewsForDate(date);
		
	}

}
