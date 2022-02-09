package CrewCaller;

import java.util.Date;
import java.util.List;

public class CrewCaller {
	private CrewInventory crewInventory;
	private NumberLookup numberLookup;

	public CrewCaller( CrewInventory crewInventory, NumberLookup numberLookUp) {
		this.crewInventory=crewInventory;
		this.numberLookup=numberLookUp;
		
	}

		
	public void callCrews(Date date) {
		List <String> crewMembers =this.crewInventory.findCrewsForDate(date);
		if(crewMembers !=null) {
		for(String crewMembe:crewMembers) {
			this.numberLookup.lookupNumber(crewMembe);
			
		}
		
	}

	}
}