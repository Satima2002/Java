import java.util.Random;

public class HomeAppliance extends Device{
	int powerConcumption;   //wattage
	
	
	Random random=new Random();
	int priceCoef=random.nextInt(10)+1;
	HomeAppliance(int typeID,int guaranteeYear, int powerConcumption){
		super(typeID,guaranteeYear);
		this.powerConcumption=powerConcumption;
	}
	
	@Override
	double evaluatePrice() {
		
		if (guaranteeYear<3) {
			return priceCoef*57;
		}
		else {
			return priceCoef*143;
		}
	}
	
	int electricityUsingPerMonth() {
		return (powerConcumption*30)/1000;//kWh
	}
}
