package login;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
/**
 * ��½����
 */
public class loginFrame extends JFrame{		//�û���¼����
	loginPanel jLandPanel=new loginPanel();	//������¼JPanel����
	String lookAndFeel;       				//������
	ImageIcon img;           				//����ͼƬ
	public static loginFrame lf;				//������¼����Ķ��󣬽�����ʾ
	public loginFrame(){
		img=new ImageIcon("res/img/icon_launch.png");		//��ͼƬ���ص�ImageIcon��	
		this.setTitle("Ӣ���ı�ͳ�Ʒ�������¼����");				//���ñ���
		jLandPanel.setBackground(Color.WHITE);        		//������ɫ����Ϊ��ɫ
		Toolkit toolkit=Toolkit.getDefaultToolkit();                 	//����һ��Toolkit����
		Dimension d=toolkit.getScreenSize();                  			//���Dimension����
		int x=(int) ((d.width-500)/2);                    				//��¼��������Ļ��x����
		int y=(int) ((d.height-320)/2); 
		this.add(jLandPanel);							//��JPanel������ӵ���¼������
		this.setBounds(x,y,500,320);				//���ý����С
		this.setVisible(true);							//���ÿɼ�
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//����ر�ʱ�ͷ���Դ
		this.setResizable(false); 						//�����С���ɸı�
		try	{
			lookAndFeel="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
			UIManager.setLookAndFeel(lookAndFeel);		//������۷��			
		}
		catch(Exception e){	e.printStackTrace();}
		this.setIconImage(img.getImage());				//���ý������Ϸ���ͼ��
	}	
}
