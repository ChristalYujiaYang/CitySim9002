import java.util.Random;

public class Visitor {
	int num=0;
	String identify;
	String[] title={"Student","Professor","Business Person","Blogger"};
	//constructor
	public Visitor(){
		
	}
	//set the number of each visitor
	public void setNum(int num){
		this.num=num;
	}
	//set the identity of each visitor
	public void setIdentify(Random r1){
		this.identify=title[r1.nextInt(4)];
	}
	//set the identity of each visitor
	public void setIdentify(String a){
		this.identify=a;
	}
	//get the number of each visitor
	public int getNum(){
		return num;
	}
	//get the identity of each visitor
	public String getIdentify(){
		return identify;
	}
	
}
