import java.util.*;

public class Common {
static int count;
public void setgc()
{count=0;}
public int removefruits(int[][] sol, int n, int row, int col)
	{
		int fruit=sol[row][col];
		//System.out.println("fruit selected is " + fruit);
		if(fruit==-1)
		{
			return count;
		}
			
		count++;
		//System.out.println("We have called this " + count + " times before...");

		sol[row][col]=-1;
		if(row-1!=-1)
		{
		if(sol[row-1][col]==fruit)
		{
		removefruits(sol, n, row-1,col);
		}
		}
		if(row+1!=n)
		{if(sol[row+1][col]==fruit)
			{removefruits(sol, n, row+1,col);
		}}
		if(col-1!=-1)
		{
		if(sol[row][col-1]==fruit)
			{removefruits(sol, n, row,col-1);
		}}
		if(col+1!=n)
		{
		if(sol[row][col+1]==fruit)
		{
		removefruits(sol, n, row,col+1);
		}}
		return count;
	}
	
	public void gravity(int[][] sol, int n)
	{
		for(int i=0;i<n;i++)//for col
		{
			for(int j=1;j<n;j++)//for row
			{
				if(sol[j][i]==-1)
				{
					if(sol[j-1][i]!=-1)
					{//swap these elements
					sol[j][i]=sol[j-1][i];
					sol[j-1][i]=-1;
					if(j!=1)
					{j-=2;
					continue;
					}
					}
				}
			}
		}
	}
	
	public void printmatrix(int[][] sol, int n)
	{
		for(int i=0;i<n;i++)
	{	for(int j=0;j<n;j++)
		{
			if(sol[i][j]!=-1)
			System.out.print(sol[i][j]);
			else
			System.out.print("*");
		}
		System.out.println();
	}	
	}

	public int[][] makeacopy(int[][] sol, int n)
	{
		int temp[][]= new int[n][n];
		
		for(int i=0;i<n;i++)
	{	for(int j=0;j<n;j++)
		{
			temp[i][j]=sol[i][j];
		}
	}
		return temp;
	}	
	
	public boolean gameover(int[][] sol, int n)
	{	for(int i=0;i<n;i++)
	{	for(int j=0;j<n;j++)
		{
			if(sol[i][j]!=-1)
				return false;
		}
	}
		return true;
	}
	
 
public int[] getbiggest(int[][] sol, int n) {
		Common c=new Common();
		int[] u=new int[3];
		int pqsize=1;
		PriorityQueue<int[]> pq= new PriorityQueue<int[]>(pqsize, new Comparator<int[]>() {
    @Override
    public int compare(int[] o1, int[] o2) {
        return Integer.compare(o1[0], o2[0]);
    }
});
        int nullnode[]= new int[3];
        for(int i=0; i<pqsize; i++)
		{pq.add(nullnode);}
		
		int temporaryscore=0;
		int temporary[][]= new int[n][n];
		int node[]= new int[3];
		temporary = c.makeacopy(sol,n);
		for(int i=0; i<n; i++)
		{
			
			for(int j=0; j<n; j++)
			{
				if(temporary[i][j]==-1)
					continue;
				
				else{
					int fruit=temporary[i][j];
					c.setgc();
					temporaryscore=c.removefruits(temporary, n, i, j);
					
					node=pq.peek();
					if (temporaryscore>node[0])
					{pq.remove();
					int[] node1={temporaryscore,i,j};
					pq.add(node1);
					
					//c.printmatrix(temporary, n);	
					//System.out.println("adding to the queue" +temporaryscore);
					//System.out.println();
					}
				}
			}
		}
		node=pq.remove();
		return node;
}

public int getavailable(int[][] sol, int n, int pqsize)
{
	Common c=new Common();
	int temp[][]= new int[n][n];
	temp=c.makeacopy(sol, n);
	int counter=0, flag=0;
	for(int i=0;i<n;i++)
	{	for(int j=0;j<n;j++)
		{
			if(temp[i][j]==-1)
				continue;
			else
			{
				counter++;
				setgc();
				removefruits(temp, n, i, j);
				//c.printmatrix(temp,n);
			//System.out.println("fruits removed from "+i+"  "+j);
			}
			// if(counter>=pqsize)
			// {
				// return pqsize;
			// }
		}
	}
	return counter;
}



public int[][] evaluateBoard(int[][] sol, int n, int pqsize) {
		Common c=new Common();
		int[] u=new int[3];
		PriorityQueue<int[]> pq= new PriorityQueue<int[]>(pqsize, new Comparator<int[]>() {
    @Override
    public int compare(int[] o1, int[] o2) {
        return Integer.compare(o1[0], o2[0]);
    }
});
        int nullnode[]= new int[3];
        for(int i=0; i<pqsize; i++)
		{pq.add(nullnode);}
		//store 4 biggest clusters, implement using priority queue
        
		int temporaryscore=0;
		int temporary[][]= new int[n][n];
		int node[]= new int[3];
		temporary = c.makeacopy(sol,n);
		for(int i=0; i<n; i++)
		{
			
			for(int j=0; j<n; j++)
			{
				if(temporary[i][j]==-1)
					continue;
				
				else{
					int fruit=temporary[i][j];
					c.setgc();
					temporaryscore=c.removefruits(temporary, n, i, j);
					
					node=pq.peek();
					if (temporaryscore>node[0])
					{pq.remove();
					int[] node1={temporaryscore,i,j};
					pq.add(node1);
					
					//c.printmatrix(temporary, n);	
					//System.out.println("adding to the queue" +temporaryscore);
					//System.out.println();
					}
				}
			}
		}
		
		int list[][]=new int[pqsize][3];
		for(int i=pqsize-1;i>=0;i--)
		{
		
		node=pq.remove();
		list[i][0]=node[0];//no of fruits
		list[i][1]=node[1];//row
		list[i][2]=node[2];//col 
		//System.out.println("returning" +list[i][0]+" "+list[i][1]+" "+list[i][2]+" ");
					
		}
		return list;
}

}