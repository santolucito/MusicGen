import javax.swing.*;
import java.awt.*;
import java.io.*;
import abc.notation.*;
import abc.parser.TuneParser;
import abc.midi.TunePlayer;
import abc.ui.swing.JScoreComponent;


public class Runner{

	
	public static String style;

	public static void main (String args[]) throws IOException{
		
		Runner r = new Runner();
		style=args[0];
		r.go();
	}

	public void go() throws IOException{

		File flt = new File("output.txt");
		FileWriter wrt = new FileWriter(flt);
	
		TuneWriter t = new TuneWriter(style);
		String s = t.makeTune();
		Tune tune = new TuneParser().parse(s);
        	wrt.write(s);

		TunePlayer play = new TunePlayer();
		play.start();		
		play.play(tune);
		System.out.println(play.isPlaying());

		JFrame j = new JFrame();
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JScoreComponent scoreUI =new JScoreComponent();
		scoreUI.setJustification(true);
        	scoreUI.setTune(tune);
		scoreUI.writeScoreTo(new File("output.png"));
		
		Container pane = j.getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		pane.setBackground(Color.white);

		JButton n = new JButton("new");
		n.addActionListener(new AListener(t,tune,scoreUI,j));
		n.setPreferredSize(new Dimension(25,25));	
	
		pane.add(n);		
		pane.add(scoreUI);
		j.pack();
   	        j.setVisible(true);

		wrt.flush(); 
	}

}
