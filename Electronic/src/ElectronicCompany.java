
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class ElectronicCompany {
	String companyName;
	Random random =new Random();
	
	Set<Device> devices = new LinkedHashSet<Device>();
	
	ElectronicCompany(String companyName,int deviceID, int maxTypeofDevices,int maxGuaranteeYear){
		this.companyName=companyName;
		
		for (int i=0; i<maxTypeofDevices;i++) {
			int type=random.nextInt(2)+1;
			int guarantee=random.nextInt(maxGuaranteeYear)+1;			
				switch(type) {
				case 1:
					int[] ram= {2,4,6,8};
					int RAM=ram[random.nextInt(4)];
					int mAh=(random.nextInt(6)+2)*1000;
					devices.add(new MobileDevice(deviceID,guarantee,mAh,RAM));
					deviceID++;
					break;
				case 2:
					int power=(random.nextInt(1000))+50;
					devices.add(new HomeAppliance(deviceID,guarantee,power));
					deviceID++;
					break;
				}
				
		}
	}
	String getName() {
		return companyName;
	}
	
	
	double highestPrice() {  //general method (overriden)
		double maxValue=1;
		for (Device device:devices) {
	
			if(device.evaluatePrice()>maxValue) {
				maxValue=device.evaluatePrice();
			}
					
		}
		return maxValue;
			
	}
	int highestBatteryLife() { //individual method for Mobile device type objects
		int maxBatteryLife=0;
		for (Device device: devices) {
			if (device instanceof MobileDevice) {
				if(((MobileDevice) device).batteryLifeCount()>maxBatteryLife) {
					maxBatteryLife=((MobileDevice)device).batteryLifeCount();
				}
				
			}
		}
		return maxBatteryLife;
	}
	int mostPowerConsuming() { //individual method for Home Appliance type objects
		int maxPower=0;
		for (Device device: devices) {
			if (device instanceof HomeAppliance) {
				if(((HomeAppliance) device).electricityUsingPerMonth()>maxPower) {
					maxPower= ((HomeAppliance) device).electricityUsingPerMonth();
				}
				
			}
		}
		return maxPower;
	}
	void printDevices() {
		System.out.println("Type of devices in company: ");
		for (Device device:devices) {
			if (device instanceof MobileDevice) {
				System.out.println("DeviceID: " +device.typeID+"| Guarantee year: "+device.guaranteeYear+
						"| Battery life is "+((MobileDevice)device).batteryLifeCount()+" hours "+" | Price: "+((MobileDevice)device).evaluatePrice()+" $");
			}
			else {
				System.out.println("DeviceID: " +device.typeID+"| Guarantee year: "+device.guaranteeYear+
						"| Avg electricity using per month "+((HomeAppliance)device).electricityUsingPerMonth()+" kWh | Price: "+((HomeAppliance)device).evaluatePrice()+" $");
			}
		}
		
		
	}
	
	
	
}
