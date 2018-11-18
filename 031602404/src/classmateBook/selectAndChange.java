package classmateBook;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import excel.ExcelTool;
import model.Users;
import Dao.dUsers;

public class selectAndChange {
	public static String newSelcetFrame(String title)
	{
		JFrame inputStuID= new JFrame(title);
		inputStuID.setVisible(true);
	    inputStuID.setBounds(250, 250, 350, 200);	
	    inputStuID.setTitle("输入学号");
	    JTextField content =new JTextField("");
		content.setBounds(10,10,160,50);
		Container container = inputStuID.getContentPane();
		container.setLayout(null);
		container.add(content);
		JButton select = new JButton("查询");
		select.setBounds(180,10,100,50);
		Users list= new Users();
		select.addActionListener(new ActionListener() {        // 监听器，用于监听点击事件
	           @Override
	           public void actionPerformed(ActionEvent e) {
	        	   Users list= new Users();
	               String stuID = content.getText().toString();
	               String temp= new String("");
	               list = dUsers.getUsers(stuID);
	               temp=list.toString();
	               setMyTextArea(banzhang.content,temp);
	            }
	        });
		JButton selectAll = new JButton("查询全部");
		selectAll.setBounds(180,80,100,50);
		selectAll.addActionListener(new ActionListener() {        // 监听器，用于监听点击事件
	           @Override
	           public void actionPerformed(ActionEvent e) {
	               List <Users> list = dUsers.getallUsers();
	               String temp = new String("");
	               for(int i=0;i<list.size();i++)
	               {
	            	   temp+=list.get(i).toString();
	               }
	               setMyTextArea(banzhang.content,temp);
	               sendAllList(banzhang.list1,list);   
	            }
	        });
		sendList(banzhang.list1,list);
		container.add(select);
		container.add(selectAll);
		String s = new String("");
		return s;
		
	}


public static void setMyTextArea(JTextArea content,String t)
{
	content.setText(t);
}

public static void sendList(List list1,Users list2)
{
	list1.add(list2);
}

public static void sendAllList(List list1,List list2)
{
	list1=list2;
}

}
