import javax.swing.*;
import java.awt.*;
import java.io.*;
import abc.notation.*;
import abc.parser.TuneParser;
import abc.ui.swing.JScoreComponent;

public class Runner{

	public static void main(String args[]) throws IOException{
		File flt = new File("output.txt");
		FileWriter wrt = new FileWriter(flt);
		

		String s = makeTune();
		Tune tune = new TuneParser().parse(s);
        	JScoreComponent scoreUI =new JScoreComponent();
		scoreUI.setJustification(true);
        	scoreUI.setTune(tune);
		scoreUI.writeScoreTo(new File("output.png"));
		wrt.write(s);
        	JFrame j = new JFrame();
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.add(scoreUI);
		j.pack();
   	        j.setVisible(true);

		//BasicMidiConverter midi = new BasicMidiConverter();
		//TunePlayer play = new TunePlayer(midi);
		//play.start();		
		//play.play();

		wrt.flush(); 
	}


	public static String makeTune(){

		String fullTune = "X:1 \nT:Random \nM:4/4 \nC:Runner.java \nK:c\n";

		for(int line = 0;line<3;line++){
			for(int bar = 0; bar<4;bar++){
				for(int i=0;i<9;i++){//number of notes(*2)+one space
				if(i==4) {
					//System.out.println(line+" "+bar+" "+i);
					fullTune += " ";
				}					
				else if(Math.random()>.7&&i!=0
					   &&fullTune.charAt(fullTune.length()-1)!='2'
					   &&fullTune.charAt(fullTune.length()-1)!=' ')
					 fullTune += "2";
			
				else fullTune += (char)((Math.random()*7)+65);
				}
				fullTune += "|";
			}
			fullTune += ("\n");
		}

		return fullTune;
	}
	
}
		
	
