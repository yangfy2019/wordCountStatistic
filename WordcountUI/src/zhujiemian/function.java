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
	static Map<String,Integer> staff = new HashMap<String, Integer>();//初始存储
	static List<Entry<String,Integer>> aList = new ArrayList<Entry<String,Integer>>();//存储按值排序后的数据
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
				stmplength1+=temp.length();//字符数
				String[] str = temp.split("([^a-zA-Z])"); //过滤出只含有字母的
				stmplength++;//行数
				for(int i=0;i<str.length;i++)
				{
					String word = str[i].trim();
					if(word.length()!=0)    //去除长度为0的行
						staff.put(word, staff.getOrDefault(word, 0)+1);
				}
			}
			br.close();
			endTime1=System.currentTimeMillis();
			
	        //System.out.println("Total time is:"+ (endTime-startTime) );
			rank();//按值排序
			long endTime=System.currentTimeMillis();
			//System.out.println("文件读入成功！请继续...");
			JOptionPane.showMessageDialog(null, "文件读入成功! \n 耗时："+(endTime-startTime)+"ms");//提示登录成功
		}catch(Exception e) {
			//System.out.println("文件不存在！！！请重新确认！");
			JOptionPane.showMessageDialog(null, "文件读入出错!");
		}
	}
	
	public static void rank()//按值排序
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
		Set<Entry<String,Integer>> mapEntries = staff.entrySet();//该方法将键和值的映射关系作为对象存储到了Set集合中
		
		List<Entry<String,Integer>> aList1 = new ArrayList<Entry<String,Integer>>(mapEntries);
		long startTime=System.currentTimeMillis();
		//按字典序排序
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
			out.println("total: "+aList.size()); //输出总词数
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
		//System.out.println("已写到result.txt  请继续...");
		JOptionPane.showMessageDialog(null, "已写到result.txt \n 耗时:"+(endTime-startTime)+"ms");
	}
	
	public static void linecount()
	{
		JOptionPane.showMessageDialog(null, "行数："+stmplength+"\n字符数："+stmplength1+"\n耗时:"+(endTime1-startTime1)+"ms");
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
					if(word.length()!=0)    //去除长度为0的行
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
