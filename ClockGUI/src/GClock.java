import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;










import java.awt.Color;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;


/**
 * A wrapper class to hold int values
 * 
 * @author Adrian D'Costa
 * @version 2.0
 * 
 */
class IntVal{
	private String input;
	
	/**
	 * This method checks whether the passed String can be converted to int or
	 * not
	 * 
	 * @param str
	 *            a String that can be converted to int
	 * @return returns true if converted otherwise false
	 */
	boolean isIntVal(String str) {
		
		try {
			
		 int tmp= Integer.parseInt(str);
		
		 return true;
		} catch (NumberFormatException e) {
			// else return false
			return false;
		}
		
		
		
	}
	/**
	 * Converts the String to int if possible
	 *
	 * @return an int
	 */
	int conversion() {

		
		int tmp = 0;
		try {
			
			tmp = Integer.parseInt(this.input);

		} catch (NumberFormatException e) {
			
			System.out.println("Could not convert the string to integer.");

			return tmp;

		}
		// otherwise return the converted int
		return tmp;
	}
	/**
	 * Gets the int value from the text field, converts the String input and
	 * save it in this obect's storage
	 */
	
	void getUserInput(String field, String field2) {

		// if input year is invalid show an error message
		if ((!(this.isIntVal(field)) && !(this.isIntVal(field2))) && ( (Integer.parseInt(field) < 0) || (Integer.parseInt(field)> 23)) && ( (Integer.parseInt(field2) < 0) || (Integer.parseInt(field2)> 59))) {
			
			GClock.setERROR(true);
			JOptionPane optionPane = new JOptionPane("Hour or Min. is invalid.",
					JOptionPane.ERROR_MESSAGE);
			JDialog dialog = optionPane.createDialog("Error in input");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
		} 
		else{
			GClock.setERROR(false);
		}
		

	}
}













class ClockCanvas extends Canvas {
	public static final long serialVersionUID = 1L;
	Clock clock = new Clock();
	DateForClock dateForClock = new DateForClock();
	String timeClock;
	//static boolean ERROR = false;
	Calendar  a;

    //The time I want
    String wTime ;

    String sec ;
    String min ;
    String hour ;
    
    String day ;
    String year;
    int month;
    String strm ;
	/**
	 * A method to paint the flag and draw String.
	 * 
	 * @param g
	 * 			Graphics
	 */
    ClockCanvas(){
    	super();
    }
    public String getHR(){
    	return hour;
    }
    public String getMIN(){
    	return min;
    }
    
	public void paint(Graphics g) {

		super.paint(g);
		
			
			dateForClock.computeDate();
			
				//invalidate();
				timeClock = "";
	           a = Calendar.getInstance();

	            //The time I want
	             wTime = "21:6:0";

	            sec = Integer.toString(a.get(Calendar.SECOND));
	            min = Integer.toString(a.get(Calendar.MINUTE));
	            hour = Integer.toString(a.get(Calendar.HOUR_OF_DAY));
	            day = Integer.toString(a.get(Calendar.DAY_OF_MONTH));
	            year = Integer.toString(a.get(Calendar.YEAR));
	            month = Integer.parseInt(Integer.toString(a.get(Calendar.MONTH)));
	            strm = "January";
	            switch(month)
	            {
	            case 0:
	            	strm = "January"; break;
	            case 1:
	            	strm = "February"; break;
	            case 2:
	            	strm = "March"; break;
	            case 3:
	            	strm = "April"; break;
	            case 4:
	            	strm = "May"; break;
	            case 5:
	            	strm = "June"; break;
	            case 6:
	            	strm = "July"; break;
	            case 7:
	            	strm = "August"; break;
	            case 8:
	            	strm = "September"; break;
	            case 9:
	            	strm = "October"; break;
	            case 10:
	            	strm = "November"; break;
	            case 11:
	            	strm = "December"; break;
	            default:
	            	strm = "Unknown"; break;
	            
	            }
	            
	            String time = hour + ":" + min + ":" + sec + " "   + strm + " " + day + ", " + year;

	            

		Font myFont = new Font("Monospaced", Font.PLAIN,30);
		g.setFont(myFont);
		g.setColor(Color.BLACK);
		timeClock = hour+ ":"+ min+ ":" + sec + " " + day + " " + strm + ", " + year ;
		g.drawString(timeClock, 50, 80);
		
	
	}
	
}

public class GClock extends JFrame  implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3795997955718992257L;
	private JPanel contentPane;
	static boolean ERROR = false;
	static boolean ISBEEP= false;
	Alarm alarm = null;
	/**
	 * Launch the application.
	 */
	
	public static boolean getERROR(){
		return GClock.ERROR;
	}
	public static void setERROR(boolean isError){
		GClock.ERROR = isError;
	}
	
	public void setAlarm(){
		
		alarm = new Alarm(-1, -1);
		
	}
	
	
	
	
	/**
	 * Create the frame.
	 
	*/
	public GClock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSetHour = new JLabel("Set Alarm Hour");
		lblSetHour.setBounds(10, 16, 100, 20);
		contentPane.add(lblSetHour, 0);
		
		JTextArea setHourTextArea = new JTextArea("0");
		setHourTextArea.setColumns(2);
		setHourTextArea.setBounds(110, 16, 170, 34);
		contentPane.add(setHourTextArea, 1);
		
		
		JLabel lblSetMinute = new JLabel("Set Alarm Min.");
		lblSetMinute.setBounds(288, 16, 150, 27);
		contentPane.add(lblSetMinute, 2);
		
		JTextArea setMinuteTextArea = new JTextArea("0");
		setMinuteTextArea.setColumns(2);
		setMinuteTextArea.setBounds(379, 16, 131, 34);
		contentPane.add(setMinuteTextArea, 3);
		
		ClockCanvas clockCanvas = new ClockCanvas();
		clockCanvas.setBounds(10,73, 594,232);
		contentPane.add(clockCanvas, 4);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(530, 16, 130, 27);
		contentPane.add(btnSave, 5);
		btnSave.addActionListener(this);
		this.setAlarm();
		//pack();
		setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent e){
		
		IntVal intVal = new IntVal();
		String m = ((JTextArea)getContentPane().getComponent(1)).getText().trim();
		String n = ((JTextArea)getContentPane().getComponent(3)).getText().trim();
		
		intVal.getUserInput(m, n);
		//System.out.println(GClock.getERROR());
		
		if(!GClock.getERROR() && ((m != null) && (n != null)&& (!GClock.ISBEEP)))
		{
			
			
			
			int i = Integer.parseInt(m);
			int j = Integer.parseInt(m);
			alarm.setAlarmHour(i);
			alarm.setAlarmMin(j);
			//System.out.println(i + " " + j);
		
		
		
		GClock.ISBEEP = true;
		
		}
		else if(GClock.getERROR()){
			JOptionPane optionPane = new JOptionPane("Error in Alarm hour and/or min.",
					JOptionPane.ERROR_MESSAGE);
			JDialog dialog = optionPane.createDialog("Error in Input");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
			//GClock.setERROR(false);
			
		}
		
	}
		
	}

