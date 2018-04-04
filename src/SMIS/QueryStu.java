package 学生信息管理系统;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QueryStu extends JFrame{
	private JTable table;
	private JTable table_1;
	public QueryStu() {
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 34, 882, 226);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("\u6240\u6709\u5B66\u751F\u4E2A\u4EBA\u4FE1\u606F");
		label_1.setBounds(365, 15, 151, 24);
		panel_1.add(label_1);
		label_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 52, 882, 152);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"\u5B66\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u51FA\u751F\u5E74\u6708", "\u7535\u8BDD", "\u5B66\u9662", "\u73ED\u7EA7", "\u5BB6\u5EAD\u5730\u5740"
			}
		));
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(156, 286, 642, 295);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 37, 642, 242);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setRowHeight(30);
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"\u59D3\u540D", "\u8BFE\u7A0B", "\u4EFB\u8BFE\u6559\u5E08", "\u6210\u7EE9", "\u7EE9\u70B9", "\u5B66\u5206"
			}
		));
		
		MysqlConn.ConnectSQL();
		MysqlConn.getdatastu();
		if(MysqlConn.counter == 0){
			JOptionPane.showMessageDialog(null, "学生信息还未导入!", "提示消息", JOptionPane.ERROR_MESSAGE);
		}
		for(int i = 0; i < MysqlConn.counter; i++){
			table.setValueAt(MysqlConn.stu_id[i], i, 0);
			table.setValueAt(MysqlConn.stu_name[i], i, 1);
			table.setValueAt(MysqlConn.stu_sex[i], i, 2);
			table.setValueAt(MysqlConn.stu_birth[i], i, 3);
			table.setValueAt(MysqlConn.stu_tel[i], i, 4);
			table.setValueAt(MysqlConn.stu_academy[i], i, 5);
			table.setValueAt(MysqlConn.stu_class[i], i, 6);
			table.setValueAt(MysqlConn.stu_add[i], i, 7);
		}
		
		MysqlConn.getdatagra();
		if(MysqlConn.counter == 0){
			JOptionPane.showMessageDialog(null, "学生成绩还未导入!", "提示消息", JOptionPane.ERROR_MESSAGE);
		}
		for(int i = 0; i < MysqlConn.counter; i++){
			table_1.setValueAt(MysqlConn.stu_name[i], i, 0);
			table_1.setValueAt(MysqlConn.c_name[i], i, 1);
			table_1.setValueAt(MysqlConn.ct_name[i], i, 2);
			table_1.setValueAt(MysqlConn.stu_grade[i], i, 3);
			table_1.setValueAt(MysqlConn.stu_point[i], i, 4);
			table_1.setValueAt(MysqlConn.credit[i], i, 5);
		}
		
		JLabel label_2 = new JLabel("\u6240\u6709\u5B66\u751F\u6210\u7EE9\u4FE1\u606F");
		label_2.setBounds(201, 0, 167, 34);
		panel_2.add(label_2);
		label_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Stu st = new Stu();
			}
		});
		button.setBounds(329, 603, 85, 37);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_1.setBounds(520, 603, 85, 37);
		getContentPane().add(button_1);
		
		this.setTitle("学生信息管理系统-管理员-查询学生信息");
		//设置窗体大小
		this.setSize(900,700);
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
