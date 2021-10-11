package coursename;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class studentsproject {

	JFrame frame16;
	private JLabel lblsummary;
	public JComboBox comboBox_1;
	public JComboBox comboBox_2;
	private JLabel lblsubject;
	private JLabel lblemail;
	public String t;
	private JTextArea textArea_1;
	private JLabel lbltitle;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentsproject window = new studentsproject();
					window.frame16.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public studentsproject() {
		initialize();
	}
	
	public void combo() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "Vivaj@m09");
			PreparedStatement pstmt;
			pstmt=connection.prepareStatement("SELECT E_mailID from instructorinfo where approve=?");
			pstmt.setString(1, "Yes");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				String str=rs.getString("E_mailID");
				comboBox_1.addItem(str);
			}
			connection.close();
		}catch(Exception exception) {
			exception.printStackTrace();
		}
	}
	public void combo2() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "Vivaj@m09");
			PreparedStatement pstmt;
			pstmt=connection.prepareStatement("SELECT specialization from instructorinfo where approve=?");
			pstmt.setString(1, "Yes");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				String str=rs.getString("specialization");
				comboBox_2.addItem(str);
			}
			connection.close();
		}catch(Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame16 = new JFrame();
		frame16.getContentPane().setBackground(Color.WHITE);
		frame16.setBounds(100, 100, 1920, 1080);
		frame16.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame16.getContentPane().setLayout(null);
		
		final JLabel projectimage = new JLabel("");
		projectimage.setBounds(946, 137, 448, 529);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		projectimage.setBorder(blackline);
		frame16.getContentPane().add(projectimage);
		
		
		JButton browseproject = new JButton("BROWSE");
		browseproject.setForeground(Color.WHITE);
		browseproject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
		        file.setCurrentDirectory(new File(System.getProperty("user.home")));
		      //filter the files
		          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
		          file.addChoosableFileFilter(filter);
		          int result = file.showSaveDialog(null);
		           //if the user click on save in Jfilechooser
		          if(result == JFileChooser.APPROVE_OPTION){
		              File selectedFile = file.getSelectedFile();
		              String path = selectedFile.getAbsolutePath();
		              projectimage.setIcon(ResizeImage(path));
		              t=path;
		          }
		           //if the user click on save in Jfilechooser


		          else if(result == JFileChooser.CANCEL_OPTION){
		              System.out.println("No File Select");
		          }
			}
			
			private Icon ResizeImage(String ImagePath) {
				// TODO Auto-generated method stub
				ImageIcon MyImage = new ImageIcon(ImagePath);
		        Image img = MyImage.getImage();
		        Image newImg = img.getScaledInstance(projectimage.getWidth(), projectimage.getHeight(), Image.SCALE_SMOOTH);
		        ImageIcon image = new ImageIcon(newImg);
		        return image;
				
			}
		});
		browseproject.setBackground(Color.decode("#4b6584"));
		browseproject.setFont(new Font("Sitka Display", Font.BOLD, 23));
		browseproject.setBounds(1101, 708, 143, 32);
		frame16.getContentPane().add(browseproject);
		
		final JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBackground(SystemColor.inactiveCaptionBorder);
		textArea.setFont(new Font("Sitka Display", Font.BOLD, 20));
		textArea.setBounds(353, 389, 448, 245);
		frame16.getContentPane().add(textArea);
		
		JLabel lblNewLabel = new JLabel("Summary :");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Sitka Display", Font.BOLD, 28));
		lblNewLabel.setBounds(68, 428, 226, 40);
		frame16.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("*Only 300 words");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(353, 644, 448, 35);
		frame16.getContentPane().add(lblNewLabel_1);
		
		lblsummary = new JLabel("");
		lblsummary.setForeground(Color.RED);
		lblsummary.setHorizontalAlignment(SwingConstants.CENTER);
		lblsummary.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		lblsummary.setBackground(Color.WHITE);
		lblsummary.setBounds(353, 677, 448, 30);
		frame16.getContentPane().add(lblsummary);
		
		JButton btnNewButton = new JButton("SUBMIT SUMMARY");
		btnNewButton.setForeground(Color.WHITE);
		
		btnNewButton.setFont(new Font("Sitka Display", Font.BOLD, 23));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str=textArea.getText();
				if (str.length() <=300 && str.length() >=1) {
					JOptionPane.showMessageDialog(null, "Your response has been recodred ");
				}
				else {
					lblsummary.setText("*Summary must conatain 300 words");
				}	
			}
		});
		btnNewButton.setBounds(440, 707, 240, 35);
		btnNewButton.setBackground(Color.decode("#4b6584"));
		frame16.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("PROJECT SUBMISSION");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Sitka Display", Font.BOLD, 38));
		lblNewLabel_3.setForeground(Color.decode("#6F1E51"));
		lblNewLabel_3.setBounds(606, 34, 500, 45);
		frame16.getContentPane().add(lblNewLabel_3);
		
		JButton btnSubmitProject = new JButton("SUBMIT PROJECT");
		btnSubmitProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag=0;
				String str=textArea_1.getText();
				String str2=textArea.getText();
				
				if(str.length() <=300 && str2.length()==0 && comboBox_1.getSelectedItem().toString().equals("Select your choice") && comboBox_2.getSelectedItem().toString().equals("Select your choice") ) {
					JOptionPane.showMessageDialog(null, "Please fill all the information");flag=1;
				}
				if(comboBox_1.getSelectedItem().toString().equals("Select your choice") ) {
					lblemail.setText("*This field is required ");flag=1;
				}
				if(comboBox_2.getSelectedItem().toString().equals("Select your choice") ) {
					lblsubject.setText("*This field is required ");flag=1;
				}
				if(str.length()==0 ) {
					lbltitle.setText("*This field is required ");flag=1;
				}
				if(str2.length()==0 ) {
					lblsummary.setText("*This field is required ");flag=1;
				}

				if(flag==0) {
					String ComboBox_1=comboBox_1.getSelectedItem().toString();
					String ComboBox_2=comboBox_2.getSelectedItem().toString();
					
					String email=null;
					if(studentpage.email!=null) {
						email=studentpage.email;
					}
					else if(loginsignup.Email!=null) {
						email=loginsignup.Email;
					}
					if(email!=null) {
						try {
							
							  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "Vivaj@m09");
			                    String query = "INSERT INTO project values(?,?,?,?,?,?)";
			                    PreparedStatement statement=connection.prepareStatement(query);
			                    FileInputStream fis=new FileInputStream(t);
			                    statement.setString(1,email);
			                    statement.setString(2,ComboBox_1);
			                    statement.setString(3,ComboBox_2);
			                    statement.setString(4,textArea_1.getText());
			                    statement.setString(5,textArea.getText());
			                    statement.setBinaryStream(6,fis);
			                    statement.executeUpdate();
								JOptionPane.showMessageDialog(null,"Project Submitted!!");
								int result=JOptionPane.showConfirmDialog(null,"Do you want to submit more projects??","Your response",JOptionPane.YES_NO_OPTION,
										JOptionPane.QUESTION_MESSAGE);
								if(result==JOptionPane.YES_OPTION) {
									studentsproject nw=new studentsproject();
									nw.frame16.setVisible(true);
									frame16.dispose();	
								}
								else if(result==JOptionPane.NO_OPTION) {
									studentform nw=new studentform();
									nw.frame15.setVisible(true);
									frame16.dispose();	
								}
			                    connection.close();
      
			                    
						} catch (Exception exception) {
		                    exception.printStackTrace();
		                }
					}
					
				}
			}
			
		});
		btnSubmitProject.setForeground(Color.WHITE);
		btnSubmitProject.setFont(new Font("Sitka Display", Font.BOLD, 25));
		btnSubmitProject.setBackground(new Color(0, 51, 102));
		btnSubmitProject.setBounds(729, 747, 254, 40);
		frame16.getContentPane().add(btnSubmitProject);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setFont(new Font("Sitka Display", Font.PLAIN, 23));
		comboBox_2.addItem("Select your choice");
		combo2();
		comboBox_2.setBounds(353, 137, 260, 30);
		frame16.getContentPane().add(comboBox_2);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setFont(new Font("Sitka Display", Font.PLAIN, 23));
		comboBox_1.addItem("Select your choice");
		combo();
		comboBox_1.setBounds(353, 218, 260, 30);
		frame16.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_4 = new JLabel("Subject :");
		lblNewLabel_4.setFont(new Font("Sitka Display", Font.BOLD, 28));
		lblNewLabel_4.setForeground(new Color(128, 0, 0));
		lblNewLabel_4.setBounds(68, 137, 226, 40);
		frame16.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Instructor Email :");
		lblNewLabel_4_1.setFont(new Font("Sitka Display", Font.BOLD, 28));
		lblNewLabel_4_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_4_1.setBounds(68, 212, 226, 40);
		frame16.getContentPane().add(lblNewLabel_4_1);
		
		lblsubject = new JLabel("");
		lblsubject.setForeground(new Color(255, 0, 0));
		lblsubject.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		lblsubject.setHorizontalAlignment(SwingConstants.CENTER);
		lblsubject.setBounds(353, 182, 260, 25);
		frame16.getContentPane().add(lblsubject);
		
		lblemail = new JLabel("");
		lblemail.setHorizontalAlignment(SwingConstants.CENTER);
		lblemail.setForeground(Color.RED);
		lblemail.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		lblemail.setBounds(353, 260, 260, 25);
		frame16.getContentPane().add(lblemail);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Project Title :");
		lblNewLabel_4_1_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_4_1_1.setFont(new Font("Sitka Display", Font.BOLD, 28));
		lblNewLabel_4_1_1.setBounds(68, 293, 226, 40);
		frame16.getContentPane().add(lblNewLabel_4_1_1);
		
		textArea_1 = new JTextArea();
		textArea_1.setBackground(SystemColor.inactiveCaptionBorder);
		textArea_1.setFont(new Font("Sitka Display", Font.PLAIN, 23));
		textArea_1.setBounds(353, 297, 260, 30);
		frame16.getContentPane().add(textArea_1);
		
		lbltitle = new JLabel("");
		lbltitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitle.setForeground(Color.RED);
		lbltitle.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		lbltitle.setBounds(353, 337, 260, 25);
		frame16.getContentPane().add(lbltitle);
		
		JLabel lblNewLabel212 = new JLabel();
		lblNewLabel212.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				studentform nw =new studentform();
				nw.frame15.setVisible(true);
				frame16.dispose();
			}
		});
		ImageIcon img50= new ImageIcon(this.getClass().getResource("/backbutton.png"));
		lblNewLabel212.setIcon(img50);
		lblNewLabel212.setBounds(10, 10, 38, 64);
		frame16.getContentPane().add(lblNewLabel212);
		
		JLabel lblNewLabel_33 = new JLabel("Back");
		lblNewLabel_33.setFont(new Font("Sitka Display", Font.BOLD, 20));
		lblNewLabel_33.setBounds(46, 36, 45, 20);
		frame16.getContentPane().add(lblNewLabel_33);
	   
		
	}
}
