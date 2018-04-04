package 学生信息管理系统;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class InsertTea extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	public InsertTea() {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(141, 61, 365, 273);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(123, 214, 201, 35);
		panel.add(comboBox_3);
		//comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"00256320", "00256321", "00256401", "00256530"}));
		MysqlConn.ConnectSQL();
		MysqlConn.getdatacou();
		for(int i = 0; i < MysqlConn.counter; i++){
			comboBox_3.addItem(MysqlConn.c_name[i]);
		}
		
		JRadioButton radioButton_2 = new JRadioButton("\u8BB2\u5E08");
		radioButton_2.setBounds(283, 167, 72, 27);
		panel.add(radioButton_2);
		
		JRadioButton radioButton_1 = new JRadioButton("\u526F\u6559\u6388");
		radioButton_1.setBounds(194, 167, 88, 27);
		panel.add(radioButton_1);
		
		JRadioButton radioButton = new JRadioButton("\u6559\u6388");
		radioButton.setBounds(130, 167, 72, 27);
		panel.add(radioButton);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(radioButton);
		bg.add(radioButton_1);
		bg.add(radioButton_2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(267, 109, 51, 35);
		panel.add(comboBox_2);
		for(int i = 1; i <= 31;i++){
			comboBox_2.addItem(String.valueOf(i));
		}
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(207, 109, 51, 35);
		panel.add(comboBox_1);
		for(int i = 1; i <= 12;i++){
			comboBox_1.addItem(String.valueOf(i));
		}
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(130, 109, 67, 35);
		panel.add(comboBox);
		for(int i = 1960; i<= 2010; i++){
			comboBox.addItem(String.valueOf(i));
		}
		
		textField_1 = new JTextField();
		textField_1.setBounds(130, 62, 125, 36);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("\u6240\u6559\u8BFE\u7A0B\uFF1A");
		label_3.setBounds(31, 208, 100, 42);
		panel.add(label_3);
		label_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		JLabel label_2 = new JLabel("\u804C\u79F0\uFF1A");
		label_2.setBounds(47, 159, 60, 42);
		panel.add(label_2);
		label_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("\u51FA\u751F\u5E74\u6708\uFF1A");
		label_1.setBounds(31, 104, 100, 42);
		panel.add(label_1);
		label_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setBounds(64, 59, 60, 42);
		panel.add(label);
		label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setBounds(130, 13, 124, 36);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u6559\u5E08\u53F7\uFF1A");
		lblNewLabel.setBounds(46, 13, 88, 42);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		JLabel label_4 = new JLabel("\u8BF7\u586B\u5199\u60A8\u8981\u6DFB\u52A0\u7684\u6559\u5E08\u4FE1\u606F\uFF1A");
		label_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		label_4.setBounds(212, 20, 235, 34);
		getContentPane().add(label_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(139, 358, 370, 47);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MysqlConn.ConnectSQL();
				if(textField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"请输入教师号!","提示消息",JOptionPane.WARNING_MESSAGE);
				}else if(MysqlConn.querytea(textField.getText())){
					JOptionPane.showMessageDialog(null,"该教师号已存在!\n请重新输入","提示消息",JOptionPane.WARNING_MESSAGE);
				}else if(!JudgeNum.judge(textField.getText(), textField.getText().length())){
					JOptionPane.showMessageDialog(null, "教师号仅由数字组成，您输入的教师号形式有误!\n请重新输入", "提示消息", JOptionPane.ERROR_MESSAGE);
				}else if(textField_1.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"请输入姓名!","提示消息",JOptionPane.WARNING_MESSAGE);
				}else if(!radioButton.isSelected() && !radioButton_1.isSelected() && !radioButton_2.isSelected()){
					JOptionPane.showMessageDialog(null,"请选择职称!","提示消息",JOptionPane.WARNING_MESSAGE);
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
					
					MysqlConn.inserttea();
				}
			}
		});
		button.setBounds(51, 5, 63, 36);
		panel_1.add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		button_1.setBounds(119, 5, 63, 36);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("\u8FD4\u56DE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Tea te =new Tea();
			}
		});
		button_2.setBounds(187, 5, 63, 36);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("\u9000\u51FA");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_3.setBounds(255, 5, 63, 36);
		panel_1.add(button_3);
		
		this.setTitle("学生信息管理系统-管理员-添加教师信息");
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
	
	//public static void main(String[] args){
		//new InsertTea().setVisible(true);
	//}
}
