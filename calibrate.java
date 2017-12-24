 import java.io.*;
 import java.util.*;
 import java.net.*;
 	
	public class calibrate
	{
		static int[][] sol;
	static int n;
	
	public static void main(String args[]) throws IOException{	
	long time1= System.currentTimeMillis();
	
	Common c=new Common();
	URL pathtocal = homework.class.getResource("input.txt");
	File f = new File(pathtocal.getFile());
	BufferedReader inp = new BufferedReader (new FileReader(f));
    
	homework.tableflag=0;
	
	n= Integer.parseInt(inp.readLine());
	int p=Integer.parseInt(inp.readLine());
	
	double t=Double.parseDouble(inp.readLine());
	
	int i=0,j=0,count=0;
	sol = new int[n][n];
	for(i=0;i<n;i++)
	{	String line= inp.readLine();
		char[] ch=line.toCharArray();
		for(j=0;j<n;j++)
		{
			String s = ch[j] + "";
			if(ch[j]!='*')
			sol[i][j] = Integer.parseInt(s);
			else
			sol[i][j]=-1;
		}
	}

	int writeflag=0;
	try{
	PrintWriter w = new PrintWriter("calibration.txt", "UTF-8");
    int y=1;
	long time=0;
	while((System.currentTimeMillis()-time1<200000)&&(y<5))
	{
	solve s= new solve(sol,n,p,t,y);
	
	s.solving();
	w.print(y+"\n");
	long time2=System.currentTimeMillis()-time1;
	w.print(time2+"\n");
	
	if(time2>100000)
			break;
	if(System.currentTimeMillis()-time1<200000)
	{time=0;	y++;
	}
	
	}
	
	w.close();
	} catch (IOException e){};
	
	
	
	}

}
