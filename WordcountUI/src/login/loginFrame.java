package login;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
/**
 * 登陆界面
 */
public class loginFrame extends JFrame{		//用户登录界面
	loginPanel jLandPanel=new loginPanel();	//创建登录JPanel对象
	String lookAndFeel;       				//界面风格
	ImageIcon img;           				//设置图片
	public static loginFrame lf;				//创建登录界面的对象，进行显示
	public loginFrame(){
		img=new ImageIcon("res/img/icon_launch.png");		//将图片加载到ImageIcon中	
		this.setTitle("英文文本统计分析—登录界面");				//设置标题
		jLandPanel.setBackground(Color.WHITE);        		//背景颜色设置为白色
		Toolkit toolkit=Toolkit.getDefaultToolkit();                 	//创建一个Toolkit对象
		Dimension d=toolkit.getScreenSize();                  			//获得Dimension对象
		int x=(int) ((d.width-500)/2);                    				//登录界面在屏幕中x坐标
		int y=(int) ((d.height-320)/2); 
		this.add(jLandPanel);							//将JPanel对象添加到登录界面中
		this.setBounds(x,y,500,320);				//设置界面大小
		this.setVisible(true);							//设置可见
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//界面关闭时释放资源
		this.setResizable(false); 						//界面大小不可改变
		try	{
			lookAndFeel="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
			UIManager.setLookAndFeel(lookAndFeel);		//设置外观风格			
		}
		catch(Exception e){	e.printStackTrace();}
		this.setIconImage(img.getImage());				//设置界面左上方的图标
	}	
}
