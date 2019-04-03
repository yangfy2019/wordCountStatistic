package zhujiemian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class firstPanel extends JPanel implements ActionListener
{
	JLabel jfile = new JLabel("选择文件: ");
	public static JTextField textField = new JTextField(30);// 文本域
    JButton bt1 = new JButton("浏览");
	JButton bt2 = new JButton("开始读入");
	JLabel jfun = new JLabel("功能选择: ");
	JButton bt3 = new JButton("指定单词词频统计及柱状图");
	JButton bt4 = new JButton("前k个高频词统计");
	JButton bt5 = new JButton("输出到文件");
	JButton bt6 = new JButton("统计行数及字符数");
	JButton bt7 = new JButton("附加1");
	
	public firstPanel()
	{
		this.setLayout(null);
		jfile.setBounds(100,50,100,30);
		this.add(jfile);
		textField.setBounds(200, 50, 300, 30);
		this.add(textField);
		bt1.setBounds(510, 50, 90, 30);
		bt1.addActionListener(this);
		this.add(bt1);
		bt2.setBounds(620, 50, 120, 30);
		bt2.addActionListener(this);
		this.add(bt2);
		jfun.setBounds(100, 120, 100, 30);
		this.add(jfun);
		bt3.setBounds(200, 120, 250, 30);
		bt3.addActionListener(this);
		this.add(bt3);
		bt4.setBounds(200, 160, 250, 30);
		bt4.addActionListener(this);
		this.add(bt4);
		bt5.setBounds(200, 200, 250, 30);
		bt5.addActionListener(this);
		this.add(bt5);
		bt6.setBounds(200, 240, 250, 30);
		bt6.addActionListener(this);
		this.add(bt6);
		bt7.setBounds(200, 280, 250, 30);
		bt7.addActionListener(this);
		this.add(bt7);
	}
	
	 public void actionPerformed(ActionEvent e)
	 {
		 if(e.getSource()==bt1)
		 {
			    JFileChooser chooser = new JFileChooser();
			    chooser.setCurrentDirectory(new File("."));
		        int result=chooser.showOpenDialog(this.getParent());
		        if(result==JFileChooser.APPROVE_OPTION)
		        {
		        	String path = chooser.getSelectedFile().getPath();
		        	textField.setText(path);
		        }
		 }
		 if(e.getSource()==bt2) 
		 {
			 function.input();
		 }
		 if(e.getSource()==bt3)
		 {
			 new chart();
		 }
		 if(e.getSource()==bt4)
		 {
			 new Highword(true);
		 }
		 if(e.getSource()==bt5)
		 {
			 function.output();
		 }
		 if(e.getSource()==bt6)
		 {
			 function.linecount();
		 }
		 if(e.getSource()==bt7) 
		 {
			 function.highWord1();
			 new Highword(false);
		 }
		 
	 }
	

}
