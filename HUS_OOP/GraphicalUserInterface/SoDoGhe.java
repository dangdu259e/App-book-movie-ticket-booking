package GraphicalUserInterface;

import java.awt.BorderLayout;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.text.AbstractDocument.Content;

import Database.queryprocess;
import Object.Customer;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.Action;
import javax.swing.JButton;

public class SoDoGhe extends JFrame {

	private static JFrame frame;
	public static JLabel lbSoGhe = new JLabel();
	public static JPanel contenPane = new JPanel();
	public static JLabel lbTongSoGhe = new JLabel("Tổng số ghế:");
	public static JLabel lbTongTien = new JLabel("Tổng thành tiền:");
	public static JLabel lbTien = new JLabel();
	public static JButton btXacNhan = new JButton("Xác nhận");

	static JButton[][] buttons = new JButton[10][10];
	static int count = 0;
	public static int id = 1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SoDoGhe window = new SoDoGhe();
					// window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SoDoGhe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 400, 600, 470);
		frame.setTitle("ĐẶT VÉ XEM PHIM");
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		contenPane.setLayout(new BorderLayout());
		contenPane.setBounds(0, 55, 586, 221);

		JPanel panel = genPanel();
		contenPane.add(panel);
		frame.getContentPane().add(contenPane);

		// Tổng số ghế
		lbTongSoGhe.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lbTongSoGhe.setHorizontalAlignment(SwingConstants.LEFT);
		lbTongSoGhe.setBounds(36, 325, 110, 28);
		frame.getContentPane().add(lbTongSoGhe);

		// Tổng thành tiền
		lbTongTien.setHorizontalAlignment(SwingConstants.LEFT);
		lbTongTien.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lbTongTien.setBounds(36, 364, 110, 28);
		frame.getContentPane().add(lbTongTien);

		// Ô tổng ghế
		lbSoGhe.setHorizontalAlignment(SwingConstants.RIGHT);
		lbSoGhe.setBounds(190, 324, 211, 30);
		lbSoGhe.setOpaque(true);
		lbSoGhe.setBackground(Color.white);
		lbSoGhe.setBorder(new TitledBorder(""));
		lbSoGhe.setText("" + count);
		frame.getContentPane().add(lbSoGhe);

		JLabel lblNewLabel_3 = new JLabel("MÀN HÌNH");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(113, 11, 359, 51);
		lblNewLabel_3.setBorder(new TitledBorder(""));

		// Ô tổng tiền
		lbTien.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTien.setBounds(190, 364, 211, 28);
		lbTien.setOpaque(true);
		lbTien.setBackground(Color.white);
		lbTien.setBorder(new TitledBorder(""));
		lbTien.setText("0 VND");
		frame.getContentPane().add(lbTien);

		// Màn chiếu
		JLabel lblMnChiu = new JLabel("Màn chiếu");
		lblMnChiu.setOpaque(true);
		lblMnChiu.setBackground(Color.WHITE);
		lblMnChiu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMnChiu.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblMnChiu.setBounds(177, 287, 245, 14);
		lblMnChiu.setBorder(new TitledBorder(""));
		frame.getContentPane().add(lblMnChiu);

		// Chu thich
		JLabel xanhLa = new JLabel();
		xanhLa.setBounds(446, 309, 15, 15);
		xanhLa.setOpaque(true);
		xanhLa.setBackground(Color.green);
		frame.getContentPane().add(xanhLa);

		JLabel noteXanhLa = new JLabel("Ghế đang chọn");
		noteXanhLa.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		noteXanhLa.setBounds(475, 309, 99, 14);
		frame.getContentPane().add(noteXanhLa);

		JLabel mauTrang = new JLabel();
		mauTrang.setBounds(446, 333, 15, 15);
		mauTrang.setOpaque(true);
		mauTrang.setBackground(Color.white);
		frame.getContentPane().add(mauTrang);

		JLabel noteMauTrang = new JLabel("Ghế trống");
		noteMauTrang.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		noteMauTrang.setBounds(475, 333, 99, 14);
		frame.getContentPane().add(noteMauTrang);

		JLabel mauDo = new JLabel();
		mauDo.setOpaque(true);
		mauDo.setBackground(Color.RED);
		mauDo.setBounds(446, 359, 15, 15);
		frame.getContentPane().add(mauDo);

		JLabel noteMauDo = new JLabel("Ghế đã bán");
		noteMauDo.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		noteMauDo.setBounds(475, 360, 99, 14);
		frame.getContentPane().add(noteMauDo);

		// Nút xác nhận
		btXacNhan.setBounds(475, 399, 89, 23);
		frame.getContentPane().add(btXacNhan);
		btXacNhan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (count == 0) {
					JOptionPane.showMessageDialog(frame, "Bạn hãy chọn ghế đã");
				} else {
					thanhToan money = new thanhToan();
				}
			}
		});

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		new queryprocess().setRedChairs();
	}

	private static JPanel genPanel() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder("SƠ ĐỒ GHẾ"));
		panel.setLayout(new GridLayout(10, 10));

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].setText("" + id);
				buttons[i][j].setBackground(Color.WHITE);
				int a = i;
				int b = j;

				// thêm chức năng cho mảng các nút ghế
				buttons[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						int oder = panel.getComponentZOrder(buttons[a][b]);
						int row = (oder / 10);
						int column = (oder % 10) + 1;

						if (buttons[a][b].getBackground() == Color.WHITE) {
							buttons[a][b].setBackground(Color.GREEN);
							count++;
							//Customer customer = new Customer();
							//customer.setSoCMND(soCMND);
							lbSoGhe.setText("" + count);
							lbTien.setText(100000 * count + " VND");
							// System.out.println("You picked the seat number "+row+""+column);
						} else if (buttons[a][b].getBackground() == Color.GREEN) {
							buttons[a][b].setBackground(Color.white);
							count--;
							lbSoGhe.setText("" + count);
							lbTien.setText(100000 * count + " VND");
							// System.out.println("You unpicked the seat number"+row+column);
						} else {
							JOptionPane.showMessageDialog(frame, "The seat have been sold out!", "",
									JOptionPane.WARNING_MESSAGE);
						}
					}
				});
				panel.add(buttons[i][j]);
				id++;
			}
		}
		return panel;
	}
	public static void setColor(int a, int b) {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(i == a && j == b) {
				buttons[i][j].setBackground(Color.red);}
			}
		}
	}
}
