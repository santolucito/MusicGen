import java.util.*;
public class TuneWriter{

	private String key = "c";
	private int totalLines =3;
	private int totalBars = 4;//per line
	private int totalNotes = 8;//per bar
	private ArrayList<Note> notes= new ArrayList<Note>();

	public String makeTune(){

		String fullTune = "X:1 \nT:Random \nM:4/4 \nC:Runner.java \nK:"+key+"\n";
		notes.clear();

		for(int line = 0;line<totalLines;line++){
			for(int bar = 0; bar<totalBars;bar++){
				int ctr = 1;
				while(ctr<=totalNotes){//number of eigth notes in bar
					
					if(ctr==5) fullTune += " ";
					notes.add(makeNote(ctr));	
					//System.out.println(notes.get(notes.size()-1).getValue()+" "+notes.get(notes.size()-1).howLong());		
					fullTune += notes.get(notes.size()-1).getValue();
					ctr+=notes.get(notes.size()-1).howLong();
				}
				fullTune += "|";
			}
			if(line==totalLines-1) fullTune+="|";
			fullTune += ("\n");
		}

		return fullTune;
	}
	
	public Note makeNote(int ctr){ //passed in current place in bar
		//this is where the algorithm goes

		//first+last note of the piece is tonic
		if(notes.size()==0)return new Note(key+"2");
		if(notes.size()==1)return new Note(key+"1");
		if(this.totalDuration()>=totalLines*totalBars*(totalNotes)-2) return new Note(key);

		if(Math.random()>.8&&(ctr==3||ctr==5)&&this.totalDuration()<=totalLines*totalBars*(totalNotes-1)) return leap(2);
		if(Math.random()>.6&&ctr!=4&&ctr!=8) return step(2);
		else return step(1);

	}

	public Note leap(int dur){//passed in duration
		Note ret = notes.get(notes.size()-1);	
		//System.out.print(ret.getValue()+" ");
		if(Math.random()<.5){
			for (int i=0;i<3;i++){ ret.stepUp();}
			ret.changeDuration(dur);
			//System.out.println(ret.getValue());
			return ret;}

		else {
			for (int i=0;i<3;i++){ ret.stepDown();}
			ret.changeDuration(dur);
			//System.out.println(ret.getValue());
			return ret;}
	}
	
	public Note step(int dur){//passed in duration
		if(Math.random()<.5||(notes.size()>2&&(notes.get(notes.size()-1).getiValue()-notes.get(notes.size()-2).getiValue())>2)){
			Note ret = new Note(notes.get(notes.size()-1).getValue());
			ret.stepUp();
			ret.changeDuration(dur);
			return ret;}

		else {
			Note ret = new Note(notes.get(notes.size()-1).getValue());
			ret.stepDown();
			ret.changeDuration(dur);
			return ret;}
	}

	public double totalDuration(){
		double i = 0;
		for(Note n:notes) i+=n.howLong();
		return i;
	}

}
		
	
