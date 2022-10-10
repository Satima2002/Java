import java.util.Comparator;

//sorted by max value rturned from overriden method

public class priceSort implements Comparator<ElectronicCompany> {  
	public int compare(ElectronicCompany a,ElectronicCompany b) {
		return (int)(a.highestPrice()-b.highestPrice());
		
	}
}
