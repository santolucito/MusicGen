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

		int currentPlace =0;
		for(int line = 0;line<totalLines;line++){
			for(int bar = 0; bar<totalBars;bar++){
				int ctr = 1;
				while(ctr<=totalNotes){//number of notes
					
					if(ctr==5) fullTune += " ";
					notes.add(makeNote(ctr));	
					//System.out.println(notes.get(notes.size()-1).value);		
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
		if(this.totalDuration()>=totalLines*totalBars*(totalNotes)-2) return new Note(key);

		
		if(Math.random()>.8&&(ctr==3||ctr==5)&&this.totalDuration()<=totalLines*totalBars*(totalNotes-1)) return leap(2);
		if(Math.random()>.6&&ctr!=4&&ctr!=8) return step(2);
		else return step(1);

	}

	public Note leap(int dur){//passed in duration
		if(Math.random()<.5){
			Note ret = notes.get(notes.size()-1);
			for (int i=0;i<3;i++){ ret = ret.wholeStepUp();}
			return ret;}

		else {
			Note ret = notes.get(notes.size()-1);
			for (int i=0;i<3;i++){ ret = ret.wholeStepDown();}
			ret.changeDuration(dur);
			return ret;}
	}
	
	public Note step(int dur){//passed in duration
		if(Math.random()<.5){
			Note ret = notes.get(notes.size()-1).wholeStepUp();
			ret.changeDuration(dur);
			return ret;}

		else {
			Note ret = notes.get(notes.size()-1).wholeStepDown();
			ret.changeDuration(dur);
			return ret;}
	}

	public double totalDuration(){
		double i = 0;
		for(Note n:notes) i+=n.howLong();
		return i;
	}

}
		
	
