import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class Langford {
	private int n;
	Algorithm a = new Algorithm();
	public Langford(int n, int maxRestarts)
	{
		this.n=n;
		int i=0;
		int[] rez=returnGjendjenFillestare();
		if(n>0&&(n%4==0||n%4==3))
		{
			while(i<maxRestarts || maxRestarts==-1)
			{
				if((a.funksHeuristik(a.hillClimbing(rez))==n))
				{
					System.out.println("Algoritmi kishte sukses.");
					a.printRez();
					break;
				}
				i++;
			};
			if((a.funksHeuristik(a.hillClimbing(rez))!=n))
			{
				System.out.println("Algoritmi deshtoi.");
				a.printRez();
			}
		}	
		else
		     JOptionPane.showInternalMessageDialog(null,"Problemi i Langford-it ka zgjidhje vetëm për numrat e formës 4*k ose 4*k-1, ku k është numër natyror.");
	}
	
	public int[] returnGjendjenFillestare()
	{
		ArrayList<Integer> gjendjaFillestare = new ArrayList<Integer>();
		for(int j=0;j<2;j++)
		for(int i=1;i<=n;i++)
			gjendjaFillestare.add(i);
		Collections.shuffle(gjendjaFillestare);
		int[] gjF = new int[gjendjaFillestare.size()];
		for(int i=0;i<gjendjaFillestare.size();i++)
			gjF[i]=gjendjaFillestare.get(i);
		return gjF;
	}
}