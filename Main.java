import java.util.*;
 
interface Converter
{
	public Object Convert(Object obj);
}
abstract class TemparetureConverter implements Converter
{
	protected abstract boolean isHot(double i);
}
abstract class SpeedConverter implements Converter
{
	protected abstract boolean isFast(double i);
}
class Thermometer extends TemparetureConverter
{
	protected boolean isHot(double i)
	{
		return i>26.00d;
	}
	
	public Object Convert(Object obj1)
	{
		double dd1=((double)obj1*(9/5))+32;
		return dd1;
	}
}
class Thermocouple extends TemparetureConverter
{
	protected boolean isHot(double i)
	{
		return i>26.00d;
	}
	public Object Convert(Object obj2)
	{
		double dd2=(double)obj2+273.15;
		return dd2;
	}
}
class PitotTube extends SpeedConverter
{
	protected boolean isFast(double i)
	{
		return i>100.00d;
	}
	public Object Convert(Object obj3)
	{
		double dd3=(double)obj3/1235;
		return dd3;
	}
}
class ShaftLog extends SpeedConverter
{
	protected boolean isFast(double i)
	{
		return i>100.00d;
	}
	public Object Convert(Object obj4)
	{
		double dd4=(double)obj4/1.609;
		return dd4;
	}
}
class Main
{
	public static void main(String args[])
	{	
		int choice;
		do{
			System.out.println("case1: Thermometer...");
			System.out.println("case2: Thermocouple...");
			System.out.println("case3: PitotTube...");
			System.out.println("case4: ShaftLog...");
			System.out.println("enter your choice-> ");
			Scanner sc=new Scanner(System.in);
			choice=sc.nextInt();
			Scanner sc1=new Scanner(System.in);
			double value=sc1.nextDouble();
			Converter converter;
			
			switch(choice)
				{
				case 1:
					converter=new Thermometer();
					System.out.println("Celcious->Farenhite: "+ converter.Convert(value));
					/*System.out.println("tempareture measure: "+ converter.isHot(value));
					This code will fail even though converter holds an object of Thermometer
					because, objects of interface can only access those methods which declared in that interface..
					no extra methods even it is in the class in which the methods of interface defined.
					Here TemparetureConverter implements interface Converter and Thermometer inherits TemparetureConverter
					so the Convert() method are inherits on those all classes but interface variable cant access those class methods..*/
					Thermometer newobj=(Thermometer)converter;
					System.out.println("High Tempareture? "+ newobj.isHot(value));
					/*now after forcefully typecast the Converter (interface) type variable to the 
					method type variable now its object can access all the methods of that class because now it
					becomes an object of the Thermometer class from Converter type variable..*/
					break;
				case 2:
					converter=new Thermocouple();
					System.out.println("Celcious->kelvin: "+ converter.Convert(value));
					/*System.out.println("tempareture measure: "+ converter.isHot(value));
					This code will fail even though converter holds an object of Thermocouple
					because, objects of interface can only access those methods which declared in that interface..
					no extra methods even it is in the class in which the methods of interface defined.
					Here TemparetureConverter implements interface Converter and Thermocouple inherits TemparetureConverter
					so the Convert() method are inherits on those all classes but interface variable cant access those class methods..*/
					Thermocouple newobj1=(Thermocouple)converter;
					System.out.println("High Tempareture? "+ newobj1.isHot(value));
					/*now after forcefully typecast the Converter (interface) type variable to the 
					method type variable now its object can access all the methods of that class because now it
					becomes an object of the Thermocouple class from Converter type variable..*/
					break;
				case 3:
					converter=new PitotTube();
					System.out.println("kph->Mach: "+ converter.Convert(value));
					/*System.out.println("speed measure: "+ converter.isFast(value));
					This code will fail even though converter holds an object of PitotTube
					because, objects of interface can only access those methods which declared in that interface..
					no extra methods even it is in the class in which the methods of interface defined.
					Here SpeedConverter implements interface Converter and PitotTube inherits SpeedConverter
					so the Convert() method are inherits on those all classes but interace variable cant access those class methods..*/
					PitotTube newobj2=(PitotTube)converter;
					System.out.println("High speed? "+ newobj2.isFast(value));
					/*now after forcefully typecast the Converter (interface) type variable to the 
					method type variable now its object can access all the methods of that class because now it
					becomes an object of the PitotTube class from Converter type variable..*/
					break;
				case 4:
					converter=new ShaftLog();
					System.out.println("kph->Mph: "+ converter.Convert(value));
					/*System.out.println("speed measure: "+ converter.isFast(value));
					This code will fail even though converter holds an object of ShaftLog
					because, objects of interface can only access those methods which declared in that interface..
					no extra methods even it is in the class in which the methods of interface defined.
					Here SpeedConverter implements interface Converter and ShaftLog inherits SpeedConverter
					so the Convert() method are inherits on those all classes but interace variable cant access those class methods.*/
					ShaftLog newobj3=(ShaftLog)converter;
					System.out.println("High speed? "+ newobj3.isFast(value));
					/*now after forcefully typecast the Converter (interface) type variable to the 
					method type variable now its object can access all the methods of that class because now it
					becomes an object of the ShaftLog class from Converter type variable..*/
					break;
				
				}
			
		}while(choice!=5);
		
	}
}
