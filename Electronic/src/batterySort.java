import java.util.Comparator;

public class batterySort implements Comparator<ElectronicCompany>{
	public int compare(ElectronicCompany a,ElectronicCompany b) {
		return (int)(a.highestBatteryLife()-b.highestBatteryLife());
	
	}
}
