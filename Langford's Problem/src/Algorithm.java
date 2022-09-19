import java.util.Random;

public class Algorithm {
	private boolean solved;
	private int[] rez;
	
	public int funksHeuristik(int[] vargu)
	{
		int count=0;
			for(int i=0;i<vargu.length;i++)
				if(i+vargu[i]+1<vargu.length && vargu[i]==vargu[i+vargu[i]+1])	
					count++;
		return count;
	}
	
	public int[] hillClimbing(int[] gjendjaFillestare) 
	{
		Random r = new Random();
		rez = gjendjaFillestare;
		solved = funksHeuristik(rez)==rez.length/2;
		if(solved)
			return rez;
		int i=(int)(r.nextInt(rez.length));
		if(i+rez[i]+1<rez.length && rez[i]!=rez[i+1+rez[i]])
		{
			int index=0;
			for(int j=0;j<rez.length;j++)
				if(rez[j]==rez[i] && j!= i)
				{
					index=j;
					break;
				}
			int temp=rez[i+1+rez[i]];
			rez[i+1+rez[i]]=rez[i];
			rez[index]=temp;
		}
		else if(i-(rez[i]+1)>=0 && rez[i]!=rez[i-(rez[i]+1)])
		{
			int index=0;
			for(int j=0;j<rez.length;j++)
				if(rez[j]==rez[i] && j!= i)
				{
					index=j;
					break;
				}
			int temp=rez[i-(rez[i]+1)];
			rez[i-(rez[i]+1)]=rez[i];
			rez[index]=temp;
		}
		if(funksHeuristik(gjendjaFillestare)<funksHeuristik(rez))
			hillClimbing(rez);
		return rez;
	}
	
	public void printRez()
	{
		for(int i=0;i<rez.length-1;i++)
			System.out.print(rez[i]+", ");
		System.out.print(rez[rez.length-1]);
		System.out.println();
	}
	
}