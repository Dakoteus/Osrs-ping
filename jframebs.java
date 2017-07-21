package osrs;

import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JList;
import javax.swing.JPanel;
import java.net.URL;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class jframebs extends JFrame implements ActionListener{
	public static int min = 9999999;
	public static int counter = 0;
	public static int pos = 0;
	public static int[] same = new int[10];
	public static String ip = "oldschool";
	public static String ip2 = ".runescape.com";
	public static int worlds[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,65,66,67,68,69,70,73,74,75,76,77,78,81,82,83,84,85,86,93,94};
	public int pings[] = new int[worlds.length];
	public static String ints;
	public static int nums[] = new int[worlds.length];
	public static DefaultListModel<String> listModel = new DefaultListModel<>();
	public static JScrollPane scroll = new JScrollPane();
	private static String OS = System.getProperty("os.name").toLowerCase();
	private static String donateID = "https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=dakoteus2117%40gmail%2ecom&lc=US&item_name=Dakota%20Wicker&currency_code=USD&bn=PP%2dDonationsBF%3abtn_donateCC_LG%2egif%3aNonHosted";
	private static JButton Donate = new JButton("Help a poor college kid?");
	private static JButton Free = new JButton("Free servers");
	private static JButton Members = new JButton("Members servers");
	private static JButton All = new JButton(new AbstractAction("All servers (longer)"){
	public void actionPerformed(ActionEvent e){
			System.out.println("Button clicked...");
			if(OS.indexOf("win") >= 0){
			System.out.println("Loading... it could take one minute.");
			 for(int i = 0; i < worlds.length; i++){
				 ints = runSystemCommand("ping -n 1 " + ip + Integer.toString(worlds[i]) + ip2);
				 nums[i] = Integer.parseInt(ints);
				 System.out.println(nums[i]);
				 System.out.println("Pinging server " + worlds[i] +"...");
				 listModel.addElement("server " + worlds[i] + ": " + nums[i] + " ms");
				 if(nums[i] < min){
					 if(nums[i] == min){
					 same[counter] = worlds[i];
					 counter++;
					 }
					 min = nums[i];
					 pos = worlds[i];
				 }
			 }
			 String samestring;
			 for(int j = 1; j < 10; j++){
				 if(same[j]>0){
					
				 }
			 }
			 MinP.setText("The server with the least ping is: " + pos + " with " + min + " ms delay\n servers with the same ping are: ");
			 }
			else if(OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 || OS.indexOf("mac") >= 0){
				
		     }
			}
	});
	private static JTextField MinP = new JTextField("The server with least ping is ");

		  public static String runSystemCommand(String command) {

				try {
					Process p = Runtime.getRuntime().exec(command);
					BufferedReader inputStream = new BufferedReader(
							new InputStreamReader(p.getInputStream()));
					ArrayList<String> a = new ArrayList<String>();
					String s = "";
					// reading output stream of the command
					while ((s = inputStream.readLine()) != null) {
						a.add(s);
						
					}
					String split = a.get(2);
					String[] reply = split.split("time");
					String nice = reply[1];
					String[] reply2 = nice.split(" ");
					String[] reply3 = reply2[0].split("=");
					String[] reply4 = reply3[1].split("ms");
					return reply4[0];
				} catch (Exception e) {
					e.printStackTrace();
					return "a";
				}
				
			}

			public static void main(String[] args) {
				
				
				SwingUtilities.invokeLater(new Runnable() {
		            @Override
		            public void run() {
		                new jframebs();
		            }
		        });
				
			
			
			}
		
			
			
			
	 public jframebs() {
		 JFrame frame = new JFrame("test");
		 //frame.setLayout(new GridLayout(1,2));
		 JPanel panel = new JPanel();
		 frame.setSize(300,300);
		 frame.add(panel);
		 JList<String>List = new JList<>(listModel);
	     add(List);
	     //setting sizes for windows and buttons and what not
	     panel.setLayout(null);
	     frame.setSize(640, 480);
	     Donate.setBounds(440,0,184,50);
	     List.setBounds(0, 0, 440, 480);
	     Free.setBounds(440, 100, 184, 50);
	     Members.setBounds(440, 200, 184, 50);
	     All.setBounds(440, 300, 184, 50);
	     MinP.setBounds(440,400,184,50);
	     
	     panel.add(scroll);
	     
	     Donate.addActionListener(this);
	     
	     panel.add(List);
	     panel.add(Donate);
	     panel.add(Free);
	     panel.add(Members);
	     panel.add(All);
	     panel.add(MinP);
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     
	     frame.setVisible(true);
		 
		 //if you're on windows
		 
		 /*System.out.println("Loading... it could take one minute.");
		 for(int i = 0; i < 10; i++){
			 ints = runSystemCommand("ping -n 1 " + ip + Integer.toString(worlds[i]) + ip2);
			 nums[i] = Integer.parseInt(ints);
			 System.out.println(nums[i]);
			 System.out.println("Pinging server " + worlds[i] +"...");
			 listModel.addElement("server " + worlds[i] + ": " + nums[i] + " ms");
		 }*/
	    		 }
		 
		 
	 public void actionPerformed(ActionEvent e){
			if(e.getSource() == Donate){
				openWebpage("https://www.paypal.com/donate/?token=rPOb7X9zz41HXcGcUvs55V0uB1m6GzYvbwzlj6UgVBrKHYWL60iqM_ixJr46tnaNophJ3G&country.x=US&locale.x=US");
				System.exit(0);
			}
			else if(e.getSource() == Free){
				 
			 }
			else if(e.getSource() == Members){
				 
			 }
			else if(e.getSource() == All){
				System.out.println("Button clicked...");
				if(OS.indexOf("win") >= 0){
				System.out.println("Loading... it could take one minute.");
				 for(int i = 0; i < 10; i++){
					 ints = runSystemCommand("ping -n 1 " + ip + Integer.toString(worlds[i]) + ip2);
					 nums[i] = Integer.parseInt(ints);
					 System.out.println(nums[i]);
					 System.out.println("Pinging server " + worlds[i] +"...");
					 listModel.addElement("server " + worlds[i] + ": " + nums[i] + " ms");
				 }
				 }
				else if(OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 || OS.indexOf("mac") >= 0){
					
			     }
				}
		}
	 
	 
	 public void openWebpage(String urlString) {
		    try {
		        Desktop.getDesktop().browse(new URL(urlString).toURI());
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
}
	
