import java.util.Arrays;

import javax.swing.JOptionPane;

public class Zad1 {

	public static void main(String[] args) {
		int max=0, min =0;
        int a=24;
        
        int  sum=0;
        
		int [] niz = new int[a];
		
		for (int i=1;i<a;i++) {
			
			niz[i]=Integer.parseInt(JOptionPane.showInputDialog("Unesi broj na mjesto:" + (i)));
			
			
			
		}
		
		System.out.println(Arrays.toString(niz));
		
	
		for (int i : niz) {
			
			sum=sum+i;
			
		}
		
		System.out.println(sum);
		
		for(int i=0;i<=23;i++) {
			
			if(niz[i]<min) {
				min=niz[i];
			}
			
		}
		
		for(int i=0;i<=23;i++) {
			
			if(niz[i]>max) {
				max=niz[i];
			}
			
		}
		


		System.out.println(max);

		System.err.println(min);
		
		
			
			
		}
	}


