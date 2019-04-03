package zhujiemian;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class firstFrame extends JFrame
{
	String lookAndFeel;       				//界面风格
	firstPanel jfirstPanel = new firstPanel();
	public firstFrame()
	{
		this.setTitle("英文文本统计分析程序");				//设置标题
		jfirstPanel.setBackground(Color.WHITE);        		//背景颜色设置为白色
		Toolkit toolkit=Toolkit.getDefaultToolkit();        //创建一个Toolkit对象
		Dimension d=toolkit.getScreenSize();                //获得Dimension对象
		int x=(int) ((d.width)/2);                    	//登录界面在屏幕中x坐标
		int y=(int) ((d.height)/2); 
		this.add(jfirstPanel);							//将JPanel对象添加到登录界面中
		//this.setBounds(x,y,0,0);				//设置界面大小
		this.setBounds(300, 200, x,y);
		this.setVisible(true);							//设置可见
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//界面关闭时释放资源
		this.setResizable(true); 						//界面大小不可改变
		try	{
			lookAndFeel="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
			UIManager.setLookAndFeel(lookAndFeel);		//设置外观风格			
		}
		catch(Exception e){	e.printStackTrace();}
	}

}
