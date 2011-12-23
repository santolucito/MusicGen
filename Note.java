public class Note {//implements Comparable{

	private String value;
	private double duration;//must match rythm value in value
	
	public Note(){
		value = "A";
		duration = 1;//eigth note
	}

	public Note(String v){
		value = v;
		if(Character.isDigit(value.charAt(value.length()-1))) this.changeDuration(Character.getNumericValue(value.charAt(value.length()-1)));
		else duration =1;

	}

	/*public int compareTo(Note other){
		//TODO this
		
		return (this.value.compareTo(other.value));
		
	}*/

	public String getValue(){return value;}

	public double howLong(){return duration;}

	public Note wholeStepUp(){
		if (value.charAt(0)=='G') return new Note("A");
		else if(value.charAt(0)=='g') return new Note("a");
		else if(value.charAt(0)=='B') return new Note("c");
		else if(value.charAt(0)=='b') return new Note("c'");
		else return new Note((char)(value.charAt(0)+1)+"");
	}

	public Note wholeStepDown(){
		if (value.charAt(0)=='A') return new Note("G");
		else if (value.charAt(0)=='a') return new Note("g");
		else if (value.charAt(0)=='C') return new Note("C");//no lower than middle C TODO find better way to control this
		else if (value.charAt(0)=='c') return new Note("B");
		else return new Note((char)(value.charAt(0)-1)+"");
	}

	public void changeDuration(double d){
		duration = d;
		if(d!=1) {
			int a=(int)d;
			value = value.charAt(0)+""+a;
		}		
	}




}
