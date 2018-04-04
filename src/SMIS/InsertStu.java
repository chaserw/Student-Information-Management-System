package 学生信息管理系统;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.GroupLayout.Alignment;

public class InsertStu extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public InsertStu() {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(40, 12, 554, 397);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		textField_3 = new JTextField();
		textField_3.setBounds(196, 218, 121, 26);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_7 = new JLabel("\u5BB6\u5EAD\u5730\u5740\uFF1A");
		label_7.setBounds(101, 331, 90, 24);
		panel.add(label_7);
		label_7.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"\u8BA1\u7B97\u673A\u79D1\u5B66\u4E0E\u6280\u672F\u5B66\u9662", "\u533B\u5B66\u9662"}));
		comboBox_4.setBounds(196, 257, 200, 24);
		panel.add(comboBox_4);
		
		JLabel label_6 = new JLabel("\u73ED\u7EA7\uFF1A");
		label_6.setBounds(137, 292, 54, 24);
		panel.add(label_6);
		label_6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"\u8BA1\u79D11501\u73ED", "\u8BA1\u79D11502\u73ED", "\u8BA1\u79D11401\u73ED", "\u4FE1\u5B891501\u73ED", "\u4E34\u5E8A1501\u73ED"}));
		comboBox_3.setBounds(196, 294, 121, 24);
		panel.add(comboBox_3);
		
		JLabel label_5 = new JLabel("\u5B66\u9662\uFF1A");
		label_5.setBounds(137, 255, 54, 24);
		panel.add(label_5);
		label_5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		textField_2 = new JTextField();
		textField_2.setBounds(196, 331, 285, 29);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_4 = new JLabel("\u7535\u8BDD\uFF1A");
		label_4.setBounds(137, 218, 54, 24);
		panel.add(label_4);
		label_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		JLabel label = new JLabel("\u5B66\u53F7\uFF1A");
		label.setBounds(137, 61, 54, 24);
		panel.add(label);
		label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010"}));
		comboBox_2.setBounds(196, 176, 70, 29);
		panel.add(comboBox_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_1.setBounds(270, 176, 47, 29);
		panel.add(comboBox_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox.setBounds(322, 176, 47, 29);
		panel.add(comboBox);
		
		JLabel label_3 = new JLabel("\u51FA\u751F\u5E74\u6708\uFF1A");
		label_3.setBounds(101, 176, 90, 29);
		panel.add(label_3);
		label_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		JRadioButton radioButton_1 = new JRadioButton("\u5973");
		radioButton_1.setBounds(270, 134, 47, 33);
		panel.add(radioButton_1);
		radioButton_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		JRadioButton radioButton = new JRadioButton("\u7537");
		radioButton.setBounds(196, 134, 47, 33);
		panel.add(radioButton);
		radioButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));

		ButtonGroup bg = new ButtonGroup();
		bg.add(radioButton);
		bg.add(radioButton_1);
		
		JLabel label_2 = new JLabel("\u6027\u522B\uFF1A");
		label_2.setBounds(137, 137, 54, 24);
		panel.add(label_2);
		label_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		textField_1 = new JTextField();
		textField_1.setBounds(196, 61, 121, 24);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setBounds(137, 100, 54, 24);
		panel.add(label_1);
		label_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setBounds(196, 99, 121, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_8 = new JLabel("\u8BF7\u586B\u5199\u60A8\u8981\u6DFB\u52A0\u7684\u5B66\u751F\u4FE1\u606F\uFF1A");
		label_8.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		label_8.setBounds(142, 18, 235, 30);
		panel.add(label_8);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(109, 422, 416, 37);
		getContentPane().add(panel_1);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.setBounds(51, 5, 63, 27);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MysqlConn.ConnectSQL();
				if(textField_1.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"请输入学号!","提示消息",JOptionPane.WARNING_MESSAGE);
				}else if(MysqlConn.querystu(textField_1.getText())){
					JOptionPane.showMessageDialog(null,"该学号已存在!\n请重新输入","提示消息",JOptionPane.WARNING_MESSAGE);
				}else if(!JudgeNum.judge(textField_1.getText(), textField_1.getText().length())){
					JOptionPane.showMessageDialog(null, "学号仅由数字组成，您输入的学号形式有误!\n请重新输入", "提示消息", JOptionPane.ERROR_MESSAGE);
				}else if(textField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"请输入姓名!","提示消息",JOptionPane.WARNING_MESSAGE);
				}else if(!radioButton.isSelected() && !radioButton_1.isSelected()){
					JOptionPane.showMessageDialog(null,"请选择性别!","提示消息",JOptionPane.WARNING_MESSAGE);
				}else if(textField_3.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"请输入电话!","提示消息",JOptionPane.WARNING_MESSAGE);
				}else if(!JudgeNum.judge(textField_3.getText(), textField_3.getText().length())){
					JOptionPane.showMessageDialog(null, "电话号码仅由数字组成，您输入的号码形式有误!\n请重新输入", "提示消息", JOptionPane.ERROR_MESSAGE);
				}else if(textField_2.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"请输入家庭地址!","提示消息",JOptionPane.WARNING_MESSAGE);
				}else{
					MysqlConn.stuid = textField_1.getText();
					MysqlConn.stuname = textField.getText();
					if(radioButton.isSelected())
						MysqlConn.stusex = "男";
					else
						MysqlConn.stusex = "女";
					MysqlConn.stubirth = Transform.strToDate((String) comboBox_2.getSelectedItem() +"-"+ (String)comboBox_1.getSelectedItem() +"-"+ (String) comboBox.getSelectedItem());
					MysqlConn.stutel = textField_3.getText();
					MysqlConn.stuacademy = (String) comboBox_4.getSelectedItem();
					MysqlConn.stuclass = (String) comboBox_3.getSelectedItem();
					MysqlConn.stuadd = textField_2.getText();
					
					//把学生信息插入到数据库中
					MysqlConn.insertstu();
				}
			}
		});
		panel_1.setLayout(null);
		panel_1.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Stu st = new Stu();
			}
		});
		button_1.setBounds(203, 5, 63, 27);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("\u9000\u51FA");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_2.setBounds(280, 5, 63, 27);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("\u91CD\u7F6E");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		button_3.setBounds(126, 5, 63, 27);
		panel_1.add(button_3);
		
		this.setTitle("学生信息管理系统-管理员-添加学生信息");
		//设置窗体大小
		this.setSize(650,520);
		//设置窗体初始位置
		this.setLocation(200, 150);
		//设置当关闭窗口时，保证JVM也退出
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//显示窗体
		this.setVisible(true);
		//窗体大小可变
		this.setResizable(true);
	}
	
	public InsertStu(String s) {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(40, 12, 554, 397);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		textField_3 = new JTextField();
		textField_3.setBounds(196, 218, 121, 26);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_7 = new JLabel("\u5BB6\u5EAD\u5730\u5740\uFF1A");
		label_7.setBounds(101, 331, 90, 24);
		panel.add(label_7);
		label_7.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"\u8BA1\u7B97\u673A\u79D1\u5B66\u4E0E\u6280\u672F\u5B66\u9662", "\u533B\u5B66\u9662"}));
		comboBox_4.setBounds(196, 257, 200, 24);
		panel.add(comboBox_4);
		
		JLabel label_6 = new JLabel("\u73ED\u7EA7\uFF1A");
		label_6.setBounds(137, 292, 54, 24);
		panel.add(label_6);
		label_6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"\u8BA1\u79D11501\u73ED", "\u8BA1\u79D11502\u73ED", "\u8BA1\u79D11401\u73ED", "\u4FE1\u5B891501\u73ED", "\u4E34\u5E8A1501\u73ED"}));
		comboBox_3.setBounds(196, 294, 121, 24);
		panel.add(comboBox_3);
		
		JLabel label_5 = new JLabel("\u5B66\u9662\uFF1A");
		label_5.setBounds(137, 255, 54, 24);
		panel.add(label_5);
		label_5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		textField_2 = new JTextField();
		textField_2.setBounds(196, 331, 285, 29);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_4 = new JLabel("\u7535\u8BDD\uFF1A");
		label_4.setBounds(137, 218, 54, 24);
		panel.add(label_4);
		label_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		JLabel label = new JLabel("\u5B66\u53F7\uFF1A");
		label.setBounds(137, 61, 54, 24);
		panel.add(label);
		label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010"}));
		comboBox_2.setBounds(196, 176, 70, 29);
		panel.add(comboBox_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_1.setBounds(270, 176, 47, 29);
		panel.add(comboBox_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox.setBounds(322, 176, 47, 29);
		panel.add(comboBox);
		
		JLabel label_3 = new JLabel("\u51FA\u751F\u5E74\u6708\uFF1A");
		label_3.setBounds(101, 176, 90, 29);
		panel.add(label_3);
		label_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		JRadioButton radioButton_1 = new JRadioButton("\u5973");
		radioButton_1.setBounds(270, 134, 47, 33);
		panel.add(radioButton_1);
		radioButton_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		JRadioButton radioButton = new JRadioButton("\u7537");
		radioButton.setBounds(196, 134, 47, 33);
		panel.add(radioButton);
		radioButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));

		ButtonGroup bg = new ButtonGroup();
		bg.add(radioButton);
		bg.add(radioButton_1);
		
		JLabel label_2 = new JLabel("\u6027\u522B\uFF1A");
		label_2.setBounds(137, 137, 54, 24);
		panel.add(label_2);
		label_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		textField_1 = new JTextField();
		textField_1.setBounds(196, 61, 121, 24);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setBounds(137, 100, 54, 24);
		panel.add(label_1);
		label_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setBounds(196, 99, 121, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_8 = new JLabel("请填写您要修改的学生信息：");
		label_8.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		label_8.setBounds(142, 18, 235, 30);
		panel.add(label_8);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(109, 422, 416, 37);
		getContentPane().add(panel_1);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.setBounds(51, 5, 63, 27);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MysqlConn.ConnectSQL();
				if(textField_1.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"请输入学号!","提示消息",JOptionPane.WARNING_MESSAGE);
				}else if(!JudgeNum.judge(textField_1.getText(), textField_1.getText().length())){
					JOptionPane.showMessageDialog(null, "学号仅由数字组成，您输入的学号形式有误!\n请重新输入", "提示消息", JOptionPane.ERROR_MESSAGE);
				}else if(!MysqlConn.querystu(textField_1.getText())){
					JOptionPane.showMessageDialog(null,"该学号不存在!\n请重新输入","提示消息",JOptionPane.WARNING_MESSAGE);
				}else if(textField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"请输入姓名!","提示消息",JOptionPane.WARNING_MESSAGE);
				}else if(!radioButton.isSelected() && !radioButton_1.isSelected()){
					JOptionPane.showMessageDialog(null,"请选择性别!","提示消息",JOptionPane.WARNING_MESSAGE);
				}else if(textField_3.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"请输入电话!","提示消息",JOptionPane.WARNING_MESSAGE);
				}else if(!JudgeNum.judge(textField_3.getText(), textField_3.getText().length())){
					JOptionPane.showMessageDialog(null, "电话号码仅由数字组成，您输入的号码形式有误!\n请重新输入", "提示消息", JOptionPane.ERROR_MESSAGE);
				}else if(textField_2.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"请输入家庭地址!","提示消息",JOptionPane.WARNING_MESSAGE);
				}else{
					MysqlConn.stuid = textField_1.getText();
					MysqlConn.stuname = textField.getText();
					if(radioButton.isSelected())
						MysqlConn.stusex = "男";
					else
						MysqlConn.stusex = "女";
					MysqlConn.stubirth = Transform.strToDate((String) comboBox_2.getSelectedItem() +"-"+ (String)comboBox_1.getSelectedItem() +"-"+ (String) comboBox.getSelectedItem());
					MysqlConn.stutel = textField_3.getText();
					MysqlConn.stuacademy = (String) comboBox_4.getSelectedItem();
					MysqlConn.stuclass = (String) comboBox_3.getSelectedItem();
					MysqlConn.stuadd = textField_2.getText();
					
					//把学生信息插入到数据库中
					MysqlConn.updatestu(MysqlConn.stuid,MysqlConn.stuname,MysqlConn.stusex,MysqlConn.stubirth,MysqlConn.stutel,MysqlConn.stuacademy,MysqlConn.stuclass,MysqlConn.stuadd);
				}
			}
		});
		panel_1.setLayout(null);
		panel_1.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Stu st = new Stu();
			}
		});
		button_1.setBounds(203, 5, 63, 27);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("\u9000\u51FA");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_2.setBounds(280, 5, 63, 27);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("\u91CD\u7F6E");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		button_3.setBounds(126, 5, 63, 27);
		panel_1.add(button_3);
		
		this.setTitle("学生信息管理系统-管理员-添加学生信息");
		//设置窗体大小
		this.setSize(650,520);
		//设置窗体初始位置
		this.setLocation(200, 150);
		//设置当关闭窗口时，保证JVM也退出
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//显示窗体
		this.setVisible(true);
		//窗体大小可变
		this.setResizable(true);
	}
}
