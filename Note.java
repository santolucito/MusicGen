public class Note {//implements Comparable{
	

	// ^ -> sharp
	// = -> natural
	// _ -> flat
	
	//C eigth note
	private String value = "C";
	private int iValue = 1;//interval middle C
	private double duration = 1;//must match rythm value in value
	
	public Note(){
		//an A quarter
		value = "A2";
		iValue = -2;
		duration = 2;
	}

	public Note(String v){
		value = v;

		//this.calculateDist(value);

		//accidentials 
		/*if(value.charAt(0)=='^')iValue++;
		if(value.charAt(0)=='=')iValue=iValue;
		if(value.charAt(0)=='_')iValue--;*/
		
		if(Character.isDigit(value.charAt(value.length()-1))) this.changeDuration(Character.getNumericValue(value.charAt(value.length()-1)));
		else duration = 1;


	}

	public Note(String v, boolean b){
		value=v;
	}

	/*public int compareTo(Note other){
		//TODO this
		
		return (this.value.compareTo(other.value));
		
	}*/

	
	private String calculateDist(String v){//how many diatonic steps does it take to get to middle C
		

		if(v.charAt(0)=='C'){

			iValue=iValue;		
			return v;
		}
		else{ //if(v.charAt(0)>'C'){
			//System.out.println(v);
			iValue+=1;
			Note n = new Note(v,true);
			n.stepDown();
			return calculateDist(n.value);
		}
		/*else if(v.charAt(0)<'C'){dont this yet b/c all notes are above middle C for now
			System.out.println(this.value);
			iValue-=1;
			this.stepUp();
			return calculateDist(this.value);
		}*/
		//else System.exit(0);
		//return "X";
	}
	
	public String getValue(){return value;}
	public int getiValue(){return iValue;}
	public double howLong(){return duration;}

	public void stepUp(){
		String temp;
		if (value.charAt(0)=='G') temp ="A";
		else if(value.charAt(0)=='g') temp = "a";
		else if(value.charAt(0)=='B') temp = "c";
		else if(value.charAt(0)=='b') temp = "c'";
		else temp = (char)(value.charAt(0)+1)+"";
		this.value = temp+this.value.substring(1);

	}

	public void stepDown(){
		String temp;
		if (value.charAt(0)=='A') temp = "G";
		else if (value.charAt(0)=='a') temp = "g";
		else if (value.charAt(0)=='C') temp = "C";//no lower than middle C TODO find better way to control this
		else if (value.charAt(0)=='c') temp = "B";
		else temp = (char)(value.charAt(0)-1)+"";
		this.value = temp+this.value.substring(1);
	}

	public int distance(Note other){//interval, 
		return this.iValue-other.getiValue();
	}

	public void changeDuration(double d){

		duration = d;
		if(d!=1) {
			int a=(int)d;
			value = value.charAt(0)+""+a;
		}
		else value = value.charAt(0)+"";

	}




}
