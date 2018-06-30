import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Notifier{

	String message;
	IntVal intVal;
	public Notifier(String message) {
		this.message = message;
	}

	public static void main(String[] args){
		
		
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run(){
				GClock frame = new GClock();
				//frame.setVisible(true);
				
				Timer timer = new Timer();

				int interval = 1000; // One second

				timer.scheduleAtFixedRate(new TimerTask() {
				  @Override
				  public void run() {
					  
				       //place your code here that you'd like to run every second
				       frame.getContentPane().getComponent(4).repaint();
				       if(GClock.ISBEEP){
				       String hr = ((ClockCanvas)frame.getContentPane().getComponent(4)).getHR();
						
						String min = ((ClockCanvas)frame.getContentPane().getComponent(4)).getMIN();
						
						String hrText = ((JTextArea)frame.getContentPane().getComponent(1)).getText().trim();
						String minText = ((JTextArea)frame.getContentPane().getComponent(3)).getText().trim();
						if(hr.equals(hrText) && min.equals(minText)){
							if(min.equals(minText)){
								
								JOptionPane optionPane = new JOptionPane("Beep!!!!!!",
										JOptionPane.ERROR_MESSAGE);
								JDialog dialog = optionPane.createDialog("Time's up.");
								dialog.setAlwaysOnTop(true);
								dialog.setVisible(true);
								GClock.ISBEEP = false;
							
							}
							
						}
				      
						
				  
				       }}},interval,interval);
				
			}
			});
		
		
		
	}

}