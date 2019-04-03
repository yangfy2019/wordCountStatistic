package zhujiemian;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

public class function 
{
	static Map<String,Integer> staff = new HashMap<String, Integer>();//��ʼ�洢
	static List<Entry<String,Integer>> aList = new ArrayList<Entry<String,Integer>>();//�洢��ֵ����������
	static ArrayList<String> stop = new ArrayList<String>();
	static String path = firstPanel.textField.getText();
	static int stmplength=0;
	static long startTime1 = 0;
	static long endTime1 = 0;
	static int stmplength1=0;
	public static void input()
	{
		String path = firstPanel.textField.getText();
		try {
			FileInputStream fis = new FileInputStream(path);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String temp="";
			long startTime=System.currentTimeMillis();
			startTime1=System.currentTimeMillis();
			while((temp = br.readLine())!=null)
			{
				stmplength1+=temp.length();//�ַ���
				String[] str = temp.split("([^a-zA-Z])"); //���˳�ֻ������ĸ��
				stmplength++;//����
				for(int i=0;i<str.length;i++)
				{
					String word = str[i].trim();
					if(word.length()!=0)    //ȥ������Ϊ0����
						staff.put(word, staff.getOrDefault(word, 0)+1);
				}
			}
			br.close();
			endTime1=System.currentTimeMillis();
			
	        //System.out.println("Total time is:"+ (endTime-startTime) );
			rank();//��ֵ����
			long endTime=System.currentTimeMillis();
			//System.out.println("�ļ�����ɹ��������...");
			JOptionPane.showMessageDialog(null, "�ļ�����ɹ�! \n ��ʱ��"+(endTime-startTime)+"ms");//��ʾ��¼�ɹ�
		}catch(Exception e) {
			//System.out.println("�ļ������ڣ�����������ȷ�ϣ�");
			JOptionPane.showMessageDialog(null, "�ļ��������!");
		}
	}
	
	public static void rank()//��ֵ����
	{
		Set<Entry<String,Integer>> mapEntries = staff.entrySet();
		
		aList = new ArrayList<Entry<String,Integer>>(mapEntries);
		
		Collections.sort(aList, new Comparator<Entry<String,Integer>>() {
			 
            @Override
            public int compare(Entry<String, Integer> ele1,
                    Entry<String, Integer> ele2) {
 
                return ele2.getValue().compareTo(ele1.getValue());
            }
        });
 
       /* for(Entry<String,Integer> entry: aList) {
        	System.out.println(entry.getKey() + " : " + entry.getValue());
        } */
	}
	
	public static void output()
	{
		Set<Entry<String,Integer>> mapEntries = staff.entrySet();//�÷���������ֵ��ӳ���ϵ��Ϊ����洢����Set������
		
		List<Entry<String,Integer>> aList1 = new ArrayList<Entry<String,Integer>>(mapEntries);
		long startTime=System.currentTimeMillis();
		//���ֵ�������
		Collections.sort(aList1, new Comparator<Entry<String,Integer>>() {
			 
            @Override
            public int compare(Entry<String, Integer> ele1,
                    Entry<String, Integer> ele2) {
 
                return ele1.getKey().compareTo(ele2.getKey());
            }
        });
 
		PrintWriter out = null;
		try {
			out = new PrintWriter("result.txt");
			out.println("total: "+aList.size()); //����ܴ���
			for(Entry<String,Integer> entry: aList1) 
			{
				out.println(entry.getKey()+"\t"+entry.getValue());
			}
		} catch (FileNotFoundException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		out.close();
		long endTime=System.currentTimeMillis();
		//System.out.println("��д��result.txt  �����...");
		JOptionPane.showMessageDialog(null, "��д��result.txt \n ��ʱ:"+(endTime-startTime)+"ms");
	}
	
	public static void linecount()
	{
		JOptionPane.showMessageDialog(null, "������"+stmplength+"\n�ַ�����"+stmplength1+"\n��ʱ:"+(endTime1-startTime1)+"ms");
	}
	
	public static void highWord1()
	{
		
		try {
			FileInputStream fis;
			fis = new FileInputStream("a.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String temp="";
			while((temp = br.readLine())!=null)
			{
				String[] str = temp.split(",");
				for(int i=0;i<str.length;i++)
				{
					String word = str[i].trim();
					if(word.length()!=0)    //ȥ������Ϊ0����
						stop.add(word);
				}
			}
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
