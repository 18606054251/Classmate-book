package classmateBook;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import model.Users;
import excel.ExcelTool;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;


public class banzhang extends JFrame{
	public static JTextArea content =new JTextArea("");
	public static List<Users> list1= new ArrayList<>();
	public banzhang()
	{
		setBounds(200, 150, 680, 730);
		setTitle("班长");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Container container = getContentPane();
		container.setLayout(null);
		JButton bSelect=new JButton("修改或查询");
		bSelect.setBounds(30, 30, 200, 50);
		bSelect.addActionListener(new ActionListener() {        // 监听器，用于监听点击事件
	           @Override
	           public void actionPerformed(ActionEvent e) {
	        	   selectAndChange.newSelcetFrame("");
	            }
	        });
		container.add(bSelect);
		//多行文本
		content.setLineWrap(true);        //激活自动换行功能 
		content.setWrapStyleWord(true);// 激活断行不断字功能
		JScrollPane jsp = new JScrollPane(content);
		jsp.setBounds(30,95,600,500);
		container.add(jsp);
		//导出按钮
		JButton output= new JButton("导出excel");
		output.setBounds(425,610,200,50);
		container.add(output);
		output.addActionListener(new ActionListener() {        // 监听器，用于监听点击事件
	           @Override
	           public void actionPerformed(ActionEvent e) {
	        	   ExcelTool.outExcel(list1);
	            }
	        });
		JLabel jl = new JLabel("16级计算机同学录管理（班级）");
		jl.setFont(new Font("宋体", Font.BOLD,20));
		jl.setBounds(250,30,300,50);
		container.add(jl);
		setVisible(true);
		
		
	}
	
	
}
