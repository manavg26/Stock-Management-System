package com.wipro.sales.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class SalesApplication1 extends JFrame {

	private JPanel contentPane;
	private final JList list = new JList();
	private final JButton btnNewButton = new JButton("Proceed");
	private final JRadioButton rdbtnNewRadioButton = new JRadioButton("Insert Stock");
	private final JRadioButton rdbtnDeletestock = new JRadioButton("DeleteStock");
	private final JRadioButton rdbtnInsertSales = new JRadioButton("Insert Sales");
	private final JRadioButton rdbtnDeleteSales = new JRadioButton("Delete Sales");
	private final JRadioButton rdbtnSalesReport = new JRadioButton("Sales Report");
	static int r=0;
	private final JTable table = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTextField textField = new JTextField();
	private final JLabel lblProductName = new JLabel("Product Name");
	private final JLabel lblNewLabel = new JLabel("Product ID");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesApplication1 frame = new SalesApplication1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SalesApplication1() {
		textField.setBounds(192, 238, 128, 28);
		textField.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setBackground(Color.YELLOW);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 500);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		list.setBounds(90, 149, -19, -35);
		
		contentPane.add(list);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switch(r) {
				case 2:
					contentPane.add(lblNewLabel);							
					contentPane.add(lblProductName);
					
				case 5:
					contentPane.add(scrollPane);
					scrollPane.setViewportView(table);
				default:
					break;
					
					
					
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(146, 187, 113, 21);
		
		contentPane.add(btnNewButton);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected())
				{		r=1;		
						rdbtnDeletestock.setSelected(false);
						  rdbtnInsertSales.setSelected(false);
						rdbtnDeleteSales.setSelected(false);
						rdbtnSalesReport.setSelected(false);					
					
				}
			}
		});
		
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		rdbtnNewRadioButton.setBounds(42, 33, 128, 21);
		
		contentPane.add(rdbtnNewRadioButton);
		rdbtnDeletestock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnDeletestock.isSelected())
				{	r=2;		
					rdbtnNewRadioButton.setSelected(false);
						  rdbtnInsertSales.setSelected(false);
						rdbtnDeleteSales.setSelected(false);
						rdbtnSalesReport.setSelected(false);					
					
				}
				
			}
		});
		rdbtnDeletestock.setFont(new Font("Times New Roman", Font.BOLD, 18));
		rdbtnDeletestock.setBounds(42, 56, 128, 21);
		
		contentPane.add(rdbtnDeletestock);
		rdbtnInsertSales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnInsertSales.isSelected())
				{	r=3;			
					rdbtnNewRadioButton.setSelected(false);
					rdbtnDeletestock.setSelected(false);
						rdbtnDeleteSales.setSelected(false);
						rdbtnSalesReport.setSelected(false);					
					
				}
			}
		});
		rdbtnInsertSales.setFont(new Font("Times New Roman", Font.BOLD, 18));
		rdbtnInsertSales.setBounds(42, 79, 128, 21);
		
		contentPane.add(rdbtnInsertSales);
		rdbtnDeleteSales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnDeleteSales.isSelected())
				{	r=4;			
					rdbtnNewRadioButton.setSelected(false);
					rdbtnDeletestock.setSelected(false);
					rdbtnInsertSales.setSelected(false);
						rdbtnSalesReport.setSelected(false);					
					
				}
			}
		});
		rdbtnDeleteSales.setFont(new Font("Times New Roman", Font.BOLD, 18));
		rdbtnDeleteSales.setBounds(42, 102, 128, 21);
		
		contentPane.add(rdbtnDeleteSales);
		rdbtnSalesReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnSalesReport.isSelected())
				{	r=5;			
					rdbtnNewRadioButton.setSelected(false);
					rdbtnDeletestock.setSelected(false);
					rdbtnInsertSales.setSelected(false);
					rdbtnDeleteSales.setSelected(false);					
					
				}
			}
		});
		rdbtnSalesReport.setFont(new Font("Times New Roman", Font.BOLD, 18));
		rdbtnSalesReport.setBounds(42, 125, 128, 21);
		
		contentPane.add(rdbtnSalesReport);
		scrollPane.setBounds(368, 38, 415, 299);

		
		contentPane.add(textField);
		lblProductName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProductName.setBounds(42, 276, 108, 28);
		
		
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(42, 238, 108, 28);
		
		
	}
}
