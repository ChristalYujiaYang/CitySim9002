import java.util.Random;

public class CitySim9002 {
	
	static String[] place={"The Cathedral of Learning","Squirrel Hill","The Point","Downtown","left the city"};
	//check whether the parameter is a integer or not 
	public boolean checkInteger(String a){
		try {
			   Integer.parseInt(a);
			   return true;
			  } catch (NumberFormatException e) {
			   return false;
			  }
	}
	//check whether the visitor like the place he or she is going to visit
	public boolean likeOrNot(Visitor n,String place){
		if(n.getIdentify()=="Student"){
			if(place=="The Cathedral of Learning"||place=="left the city")
				return false;
			else
				return true;
		}
		if(n.getIdentify()=="Business Person"){
			if(place=="Squirrel Hill"||place=="Downtown")
				return true;
			else
				return false;
		}
		if(n.getIdentify()=="Professor"){
			if(place=="left the city")
				return false;
			else
				return true;
		}
		if(n.getIdentify()=="Blogger")
			return false;
		else
			return false;
	}
	public String print(Visitor n,Random r1,String p){
		if(likeOrNot(n,p)){
			return "Visitor "+n.getNum()+" did like "+p+".";
		}
		else{
			return "Visitor "+n.getNum()+" did not like "+p+".";
		}
	}
	//for each iteration, find out where the visitor is going to visit and print out whether he or she like it.
	public void tourist(Visitor n,Random r1) {
		String p=place[r1.nextInt(5)];
		while(p=="left the city"){
			p=place[r1.nextInt(5)];
		}
		while(p!="left the city"){
			System.out.println("Visitor "+n.getNum()+" is going to "+p+"!");
			System.out.println(print(n,r1,p));
			p=place[r1.nextInt(5)];
		}
		System.out.println("Visitor "+n.getNum()+" has "+p);
	}
	public static void main(String[] args){
		CitySim9002 run=new CitySim9002();
		if(args.length!=1||!run.checkInteger(args[0])){
			System.out.println("Please enter one integer argument, seed");
			System.exit(0);
		}
		System.out.println("Welcome to CitySim!	Your seed is "+args[0]+".");
		Random r1=new Random(Long.parseLong(args[0]));
		for(int i=1;i<6;i++){
			Visitor person=new Visitor();
			person.setNum(i);
			person.setIdentify(r1);
			System.out.println("Visitor "+person.getNum()+" is a "+person.getIdentify());
			run.tourist(person,r1);
			System.out.println("***");
		}
	}
}
