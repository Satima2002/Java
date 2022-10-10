
public abstract class Device {
	int typeID;
	int guaranteeYear;
	
	Device(int typeID,int guaranteeYear){
		this.typeID=typeID;
		this.guaranteeYear=guaranteeYear;
		
	}
	int getID() {
		return this.typeID;
	}
	int getGuaranteeYear() {
		return this.guaranteeYear;
	}
	abstract double evaluatePrice();

}
