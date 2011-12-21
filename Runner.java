import javax.swing.*;
import java.awt.*;
import java.io.*;
import abc.notation.*;
import abc.parser.TuneParser;
import abc.ui.swing.JScoreComponent;

public class Runner{

	public static void main (String args[]) throws IOException{
		
		Runner r = new Runner();
		r.go();
	}

	public void go() throws IOException{

		File flt = new File("output.txt");
		FileWriter wrt = new FileWriter(flt);

		TuneWriter t = new TuneWriter();
		String s = t.makeTune();
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
		///play.start();		
		//play.play();

		wrt.flush(); 
	}


	}
