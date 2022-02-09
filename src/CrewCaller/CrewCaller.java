package CrewCaller;

import java.util.Date;
import java.util.List;

public class CrewCaller {
	private CrewInventory crewInventory;
	private NumberLookup numberLookup;
	private PhoneDialer phoneDialer;

	public CrewCaller( CrewInventory crewInventory, NumberLookup numberLookUp, PhoneDialer phoneDialer) {
		this.crewInventory=crewInventory;
		this.numberLookup=numberLookUp;
		this.phoneDialer=phoneDialer;
		
	}

		
	public void callCrews(Date date) {
		List <String> crewMembers =this.crewInventory.findCrewsForDate(date);
		if(crewMembers !=null) {
		for(String crewMembe:crewMembers) {
			String foundNumber=this.numberLookup.lookupNumber(crewMembe);
			this.phoneDialer.dialNumber(foundNumber);
			
		}
		
	}

	}
}