import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import abc.notation.*;
import abc.parser.TuneParser;
import abc.ui.swing.JScoreComponent;

public class AListener implements ActionListener {


	TuneWriter tW;
	Tune t;
	JScoreComponent score;
	JFrame j;


	public AListener(TuneWriter tuneW, Tune tune, JScoreComponent scoreUI, JFrame j){
		tW=tuneW;
		t=tune;
		score = scoreUI;
		this.j = j;
	}
		
	
	public void actionPerformed(ActionEvent e) {
		t = new TuneParser().parse(tW.makeTune());
		score.setTune(t);
		j.add(score);
		j.repaint();
	}
}
