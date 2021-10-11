package coursename;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class registrationsuccessful {

	JFrame frame4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrationsuccessful window = new registrationsuccessful();
					window.frame4.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the application.
	 */
	public registrationsuccessful() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame4 = new JFrame();
		frame4.getContentPane().setBackground(Color.WHITE);
		frame4.setBounds(100, 100, 1920, 1080);
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel image1lable = new JLabel();
		image1lable.setBackground(Color.WHITE);
		ImageIcon img= new ImageIcon(this.getClass().getResource("/Screenshot (132).png"));
		frame4.getContentPane().setLayout(null);
		image1lable.setIcon(img);
		image1lable.setBounds(298, 0, 1000, 500);
		frame4.getContentPane().add(image1lable);
		
		JLabel lblNewLabel = new JLabel("Login into your account when your form is approved by Admin");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Sitka Display", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(313, 521, 1000, 40);
		frame4.getContentPane().add(lblNewLabel);
		
		JLabel lblThankYou = new JLabel("Thank You!!");
		lblThankYou.setForeground(new Color(0, 0, 128));
		lblThankYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblThankYou.setFont(new Font("Sitka Display", Font.BOLD, 35));
		lblThankYou.setBounds(616, 589, 340, 40);
		frame4.getContentPane().add(lblThankYou);
		
		JButton backtologinpage = new JButton("Back to Login page");
		backtologinpage.setForeground(Color.WHITE);
		backtologinpage.setBackground(new Color(0, 51, 102));
		backtologinpage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginsignup nw =new loginsignup();
			    nw.frame.setVisible(true);
			    frame4.dispose();
			}
		});
		backtologinpage.setFont(new Font("Sitka Display", Font.PLAIN, 23));
		backtologinpage.setBounds(669, 653, 225, 40);
		frame4.getContentPane().add(backtologinpage);
		
		
	}
}
