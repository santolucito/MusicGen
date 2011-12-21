public class TuneWriter{

public String makeTune(){

		String fullTune = "X:1 \nT:Random \nM:4/4 \nC:Runner.java \nK:C\n";
		Note[] allNotes= new Note[3*4*8];
		int totalLines =3;
		int totalBars = 4;//per line
		int totalNotes = 8;//per bar
		int currentPlace =0;
		for(int line = 0;line<totalLines;line++){
			for(int bar = 0; bar<totalBars;bar++){
				int note = 0;
				System.out.println("new bar");
				while(note<totalNotes+1){//number of notes+one space
					

					if(note==4){ 
						note++;
						fullTune += " ";
						System.out.println("midway");
					}
					else {	
						allNotes[currentPlace] = makeNote(allNotes,currentPlace,note);			
						fullTune += allNotes[currentPlace].get();
						note+=allNotes[currentPlace].howLong();
						System.out.println(note+" "+allNotes[currentPlace].howLong()+" "+allNotes[currentPlace].get());
						currentPlace++;
					}

				
				}

				fullTune += "|";
			}
			fullTune += ("\n");
		}

		return fullTune;
	}
	
	public Note makeNote(Note[] notes, int p, int n){ //notes current place in array current place in bar
		if(p==0)return new Note("C2");
		//System.out.println(p);
		if(Math.random()>.7)
		 	return step(notes, 2, p);
		else if (n!=5&&n!=1)//dont cross midbar split
			return step(notes,1,p);
		else return new Note();
	}

	public Note step(Note[] n, int dur, int p){
		System.out.println(p);
		if(Math.random()<.4){
			Note ret = n[p-1].wholeStepUp();
			ret.changeDuration(dur);
			return ret;}

		else {
			Note ret = n[p-1].wholeStepDown();
			ret.changeDuration(dur);
			return ret;}


	}

}
		
	