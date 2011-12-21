public class Note{

	String value;
	double duration;//must match rythm value in value
	
	public Note(){
		value = "A";
		duration = 1;//eigth note
	}

	public Note(String v){
		value = v;
		if(value.length()!=1) duration = Character.getNumericValue(value.charAt(value.length()-1));
		else duration = 1;

	}

		

	public String get(){return value;}

	public double howLong(){return duration;}

	public Note wholeStepUp(){
		if (value.charAt(0)=='G') return this.wholeStepDown();
		return new Note((char)(value.charAt(0)+1)+"");
	}

	public Note wholeStepDown(){
		if (value.charAt(0)=='A') return this.wholeStepUp();
		else return new Note((char)(value.charAt(0)-1)+"");
	}

	public void changeDuration(double d){
		duration = d;
		int a=(int)d;
		value += a;		
	}


}