import javax.swing.JOptionPane;

public class Zad5 {

	public static void main(String[] args) {
		int x=Integer.parseInt(JOptionPane.showInputDialog("Unesite 1. broj "));
		int y=Integer.parseInt(JOptionPane.showInputDialog("Unesite 2. broj "));
		
		
		
		int mat [] []=new int [x][y];
		
		int pocReda=0;
		int krajReda=y-1;
		int pocStupca=0;
		int krajStupca=x-1;
		int count=1;
		
		
			
		while(count<=x*y) {
			for (int i=krajReda;i>=pocReda;i--) {
				mat[krajReda][i]=count++;
			}
			
			
			for(int i=krajReda-1;i>=pocReda;i--) {
				
				mat[i][pocStupca]=count++; 
			}
			
			for(int i=pocReda+1;i<=krajReda;i++) {
				mat[pocReda][i]=count++;
			}
			
			for(int i=pocReda+1;i<=krajReda-1;i++) {
				mat[i][krajStupca]=count++;
			}
			
			pocReda++;
			pocStupca++;
			krajReda--;
			krajStupca--;
			
		}
		 
		 
		 
		
				
		
		
		for (int i = 0; i < x; i++)
	    {
	        for (int j = 0; j <y; j++)
	        {
	            System.out.print(mat[i][j]+ "\t");
	        }
	         
	        System.out.println();
	    }
		

	}

}
