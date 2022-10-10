import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
	
	ElectronicCompany Samsung=new ElectronicCompany("Samsung",1,4,7);
	ElectronicCompany Sony=new ElectronicCompany("Sony",1,5,9);
	ElectronicCompany LG=new ElectronicCompany("LG",1,7,10);
	

	
	Set<ElectronicCompany> companies=new LinkedHashSet<ElectronicCompany>();
	
	companies.add(Samsung);	
	companies.add(Sony);
	companies.add(LG);
	
	for (ElectronicCompany company:companies) {
		
		System.out.println("Company name is: "+company.getName());
		System.out.println("The most expensive device price : "+company.highestPrice()+" $");
		System.out.println("The highest battery life of mobile devices :"+company.highestBatteryLife()+" hours");
		//System.out.println("The most power consumed: "+company.mostPowerConsuming()+" kWh");
		company.printDevices();
		System.out.println();
		
		}

	System.out.println("Companies are ranked by devices average price: ");
	TreeSet<ElectronicCompany> priceSorted=new TreeSet<ElectronicCompany>(new priceSort());
	priceSorted.addAll(companies);
	for (ElectronicCompany company:priceSorted) {
			System.out.println(company.getName()+" : "+company.highestPrice()+" $");
	}
	System.out.println(" ");
	
	
	System.out.println("Companies are ranked by mobile devices battery life: ");
	TreeSet<ElectronicCompany> batteryLifeSorted=new TreeSet<ElectronicCompany>(new batterySort());
	batteryLifeSorted.addAll(companies);
	for (ElectronicCompany company:batteryLifeSorted) {
			System.out.println(company.getName()+" : "+company.highestBatteryLife()+" hours");
	}
	
	System.out.println();
	

	Comparator<ElectronicCompany> pcomp = new priceSort().thenComparing(new batterySort());
	TreeSet<ElectronicCompany> company = new TreeSet<ElectronicCompany>(pcomp);
	System.out.println("Companies sorted by battery life and price");
	for(ElectronicCompany  p : company){
		
	    System.out.println(p.highestPrice() );
	}

	
	ArrayList<String> first=new ArrayList();	
	ArrayList<String> second=new ArrayList();
	ArrayList<String> third=new ArrayList();
	ArrayList<Integer> position=new ArrayList();

	
	for (ElectronicCompany comp:batteryLifeSorted) {
		first.add(comp.getName());
	}
	for (ElectronicCompany comp:batteryLifeSorted) {
		second.add(comp.getName());
	}
	
	for (String s:first) {
		
			int posi= (second.indexOf(s)+first.indexOf(s));
			System.out.println(second.indexOf(s)+first.indexOf(s));
			third.add(posi,s);
			
		
	}
	for (String i:third) {
		System.out.print(i);
	}
	
	
}}
