 import java.io.*;
 import java.util.*;
 import java.net.*;
 	
 public class homework{

	static int[][] sol;
	static int n;
	public static int tableflag=0;
	
	public static void main(String args[]) throws IOException{	
	Common c=new Common();
	URL path = homework.class.getResource("input.txt");
	File f = new File(path.getFile());
	BufferedReader inp = new BufferedReader (new FileReader(f));
    
	n= Integer.parseInt(inp.readLine());
	//System.out.println(n);
	int p=Integer.parseInt(inp.readLine());
	//System.out.println(p);
	
	double t=Double.parseDouble(inp.readLine());
	//System.out.println(t);
	
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

	// for(i=0;i<n;i++)
	// {	for(j=0;j<n;j++)
		// {
			// System.out.print(sol[i][j]);
		// }
		// System.out.println();
	// }	
	
	// c.setgc();
	// count=c.removefruits(sol, n, 7, 7);
	// System.out.println();
	// c.printmatrix(sol, n);	
	// System.out.println("fruit count "+count);
	
	// c.setgc();
	// count=c.removefruits(sol, n, 3, 4);
	// System.out.println();
	// c.printmatrix(sol, n);	
	// System.out.println("fruit count "+count);
	
	// c.gravity(sol, n);
	// System.out.println();
	// c.printmatrix(sol, n);
	// long time1= System.currentTimeMillis();
	// File calf = new File(path.getFile());
	// BufferedReader input = new BufferedReader (new FileReader(calf));
    // double calfac= Double.parseDouble(input.readLine());
	// int r=getoptdl(sol,n,p,t,calfac);
	// int y=r;
	// if (r>=4)
		// y=r-1;
	// else y=r;
	
	double timetable[][]=new double[10][2];
	timetable=getoptdl();
	//System.out.println("We reached here!");
	int icount=0;
	int r=1;
	if(n>=12)
		r=1;
	else if(n>=7)
		r=2;
	else
		r=3;
	while((timetable[icount][1]<(t*1000))&&(icount<timetable.length-1)&&(tableflag!=0))
	{
		if(timetable[icount][1]!=-1)
		{r=icount+1;
		System.out.println("Updating the value of r");
		}
		icount++;
	}
	System.out.println("Using depth="+r+" which has time "+timetable[r-1][1]);
	solve s= new solve(sol,n,p,t,r);
	
	s.solving();
	}
	

	public static double[][] getoptdl() throws IOException
	{
	URL pathofcal = homework.class.getResource("calibration.txt");
	File f1 = new File(pathofcal.getFile());
	BufferedReader input = new BufferedReader (new FileReader(f1));
    double[][] timetable=new double[5][2];
	for(int i=0;i<5;i++)
	{
			timetable[i][1]=-1;
	}
	int icount=0;
	String line;
	while((line = input.readLine()) != null)
	{
	int y= Integer.parseInt(line);
	
	double timetaken=Double.parseDouble(input.readLine());
	if(icount<5){
		
		timetable[icount][0]=y;
		timetable[icount][1]=timetaken;
		
	tableflag=1;
	icount++;
	}
	//System.out.println("Still inside while");
	}
	//System.out.println("out of while loop");
	
	return timetable;
	}

}