import java.util.Random;

public class MobileDevice extends Device{
	
	int battery;
	int RAM;
	final double amps=0.5;
	int mAh;

	Random random=new Random();
	int priceCoef=random.nextInt(10)+1;
	
	MobileDevice(int typeID,int guaranteeYear,int mAh, int RAM){
		super(typeID,guaranteeYear);
		this.battery=mAh;
		this.RAM=RAM;
		this.mAh=mAh;
		
	}
	
	@Override

	double evaluatePrice() {
		
		if (RAM==4) {
			
			return priceCoef*25;
		}
		else if (RAM==6) {
			return priceCoef*56;
		}
		else {
			return priceCoef*80;
		}
	}
	
	int batteryLifeCount() {  //returns in hour
		return (int)(mAh/(amps*1000));
	}
}
