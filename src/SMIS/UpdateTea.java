package 学生信息管理系统;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class UpdateTea extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	public UpdateTea() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6559\u5E08\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		lblNewLabel.setBounds(194, 57, 78, 37);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(297, 61, 150, 33);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		label.setBounds(211, 120, 59, 39);
		getContentPane().add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(288, 180, 80, 37);
		getContentPane().add(comboBox);
		for(int i = 1960; i<= 2010; i++){
			comboBox.addItem(""+i);
		}
		
		textField_1 = new JTextField();
		textField_1.setBounds(297, 124, 146, 33);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("\u51FA\u751F\u5E74\u6708\uFF1A");
		label_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		label_1.setBounds(171, 182, 101, 37);
		getContentPane().add(label_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(372, 180, 66, 37);
		getContentPane().add(comboBox_1);
		for(int i = 1; i <= 12;i++){
			comboBox_1.addItem(""+i);
		}
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(442, 180, 61, 37);
		getContentPane().add(comboBox_2);
		for(int i = 1; i <= 31;i++){
			comboBox_2.addItem(""+i);
		}
		
		JLabel label_2 = new JLabel("\u804C\u79F0\uFF1A");
		label_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		label_2.setBounds(210, 247, 59, 37);
		getContentPane().add(label_2);
		
		JRadioButton radioButton = new JRadioButton("\u6559\u6388");
		radioButton.setBounds(279, 252, 71, 33);
		getContentPane().add(radioButton);
		if(radioButton.getText().toString().equals(MysqlConn.protitle))
			radioButton.setSelected(true);
		
		JRadioButton radioButton_1 = new JRadioButton("\u526F\u6559\u6388");
		radioButton_1.setBounds(348, 252, 79, 33);
		getContentPane().add(radioButton_1);
		if(radioButton_1.getText().toString().equals(MysqlConn.protitle))
			radioButton_1.setSelected(true);
		
		JRadioButton radioButton_2 = new JRadioButton("\u8BB2\u5E08");
		radioButton_2.setBounds(433, 252, 79, 33);
		getContentPane().add(radioButton_2);
		if(radioButton_2.getText().toString().equals(MysqlConn.protitle))
			radioButton_2.setSelected(true);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(radioButton);
		bg.add(radioButton_1);
		bg.add(radioButton_2);
		
		JLabel label_3 = new JLabel("\u6240\u6559\u8BFE\u7A0B\u53F7\uFF1A");
		label_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		label_3.setBounds(162, 308, 113, 37);
		getContentPane().add(label_3);
		
		JComboBox comboBox_3 = new JComboBox();
		//comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"00256320", "00256321", "00256401", "00256530"}));
		comboBox_3.setBounds(291, 308, 149, 32);
		getContentPane().add(comboBox_3);
		
		MysqlConn.ConnectSQL();
		MysqlConn.getdatacou();
		for(int i = 0; i < MysqlConn.counter; i++){
			comboBox_3.addItem(MysqlConn.c_name[i]);
		}
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MysqlConn.ConnectSQL();
				if(textField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"请输入教师号!","提示消息",JOptionPane.WARNING_MESSAGE);
				}else if(!JudgeNum.judge(textField.getText(), textField.getText().length())){
					JOptionPane.showMessageDialog(null, "教师号仅由数字组成，您输入的教师号形式有误!\n请重新输入", "提示消息", JOptionPane.ERROR_MESSAGE);
				}else if(!MysqlConn.querytea(textField.getText())){
					JOptionPane.showMessageDialog(null,"您输入的教师号有误或该教师号不存在!\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);
				}else if(textField_1.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"请输入姓名!","提示消息",JOptionPane.WARNING_MESSAGE);
				}else{
					MysqlConn.teaid = textField.getText();
					MysqlConn.teaname = textField_1.getText();
					MysqlConn.teabirth = Transform.strToDate((String) comboBox.getSelectedItem() +"-"+ (String) comboBox_1.getSelectedItem() +"-"+ (String) comboBox_2.getSelectedItem());
					if(radioButton.isSelected()){
						MysqlConn.protitle = "教授";
					}else if(radioButton_1.isSelected()){
						MysqlConn.protitle = "副教授";
					}else{
						MysqlConn.protitle = "讲师";
					}
					MysqlConn.cname = (String) comboBox_3.getSelectedItem();
					MysqlConn.getdatacou(MysqlConn.cname);
					MysqlConn.updatetea(MysqlConn.teaid,MysqlConn.teaname,MysqlConn.teabirth,MysqlConn.protitle,MysqlConn.cno);
				}
			}
		});
		button.setBounds(191, 376, 80, 35);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Tea te = new Tea();
			}
		});
		button_1.setBounds(278, 376, 80, 35);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u9000\u51FA");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_2.setBounds(368, 376, 80, 35);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("\u786E\u8BA4");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MysqlConn.ConnectSQL();
				if(textField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"请输入教师号!","提示消息",JOptionPane.WARNING_MESSAGE);
				}else if(!MysqlConn.querytea(textField.getText())){
					JOptionPane.showMessageDialog(null,"您输入的教师号有误或该教师号不存在!\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);
				}else{
					textField.setEditable(false);
					MysqlConn.getdatatea(textField.getText());
					textField_1.setText(MysqlConn.teaname);
				}
			}
			
		});
		button_3.setBounds(467, 59, 80, 37);
		getContentPane().add(button_3);
		
		this.setTitle("学生信息管理系统-管理员-修改教师信息");
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
