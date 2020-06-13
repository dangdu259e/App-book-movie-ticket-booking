package GraphicalUserInterface;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;

import Database.Connect;



public class Login_S extends JFrame {

	private JTextField textUsername;
	private JPasswordField txtPassword;
	protected JFrame frmLoginSystem;
	private final Action action = new SwingAction();
	static String password;
	static String username;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_S window = new Login_S();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_S() {
		initialize();
	}

	/**	
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame.setBackground(Color.GRAY);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("Login");
		setBounds(200, 200, 500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
	
		
		JLabel lblTitle = new JLabel("LOGIN SYSTEM");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.DARK_GRAY);
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setOpaque(true);
		lblTitle.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTitle.setBounds(0, -2, 486, 56);
		getContentPane().add(lblTitle);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblUsername.setBounds(42, 80, 88, 28);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblPassword.setBounds(42, 136, 88, 25);
		getContentPane().add(lblPassword);
		
		textUsername = new JTextField();
		textUsername.setBounds(140, 80, 186, 28);
		getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(140, 133, 186, 28);
		getContentPane().add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(Color.BLUE);
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButtonLoginActionPerforme(e);
			}
		});
		btnLogin.setBounds(238, 214, 108, 28);
		getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset All");
		btnReset.setBackground(Color.GRAY);		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textUsername.setText(null);
				txtPassword.setText(null);
			}
		});
		btnReset.setBounds(339, 136, 88, 25);
		getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(Color.RED);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLoginSystem = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want exit !", "Login",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 17));	
		btnExit.setBounds(356, 214, 108, 28);
		getContentPane().add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 198, 486, 2);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 53, 486, 2);
		getContentPane().add(separator_1);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CustomerInfo cus = new CustomerInfo();				
				cus.main(null);
				cus.pack(); 
				cus.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(392, 53, 94, 34);
		getContentPane().add(btnNewButton);
		this.dispose();
	}
	private void JButtonLoginActionPerforme(ActionEvent evt) {
		 password = txtPassword.getText();
		 username = textUsername.getText();
		
		
		if (username.equals("")) {
			JOptionPane.showMessageDialog(null, "         Invalid Login DeTails \n       You must fill username","Login Error", JOptionPane.ERROR_MESSAGE);
		}
		if(password.equals("")) {
			JOptionPane.showMessageDialog(null, "         Invalid Login DeTails \n       You must fill password", "Login Error", JOptionPane.ERROR_MESSAGE);
		}	
		String queryString =  "SELECT * FROM `thongtincanhan` WHERE `username` = ? AND `password` = ?";
		PreparedStatement pStatement;
		try {
			pStatement = Connect.getConnect().prepareStatement(queryString);
			pStatement.setString(1, username);
			pStatement.setString(2, password);
			ResultSet rsResult;
			rsResult = pStatement.executeQuery();
			if (rsResult.next()) {
				//txtPassword.setText(null);
				//textUsername.setText(null);
						
				SoDoGhe info = new SoDoGhe();
			}else {
				JOptionPane.showMessageDialog(null, "Invalid username or password","Login error",2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//System.out.println("Error !!!");
			//Logger.getLogger(Login_S.class.getName().log(Level.SEVERE,null,e));
		}
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
		public static String getUsername() {
			return username;
		}
		public static String getPassword() {
			return password;
		}
}
