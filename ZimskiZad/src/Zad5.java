import javax.swing.JOptionPane;

public class Zad5 {

	public static void main(String[] args) {
		
		int [] [] matrica=new int [5][5];
		
		for (int i=0;i<5;i++) {
			for (int j=0;j<5;j++) {  
				
				matrica[i][j]=Integer.parseInt(JOptionPane.showInputDialog("Unesite elemente u 1. matricu " + (i+1) + " " + (j+1)));

				
				System.out.print(matrica[i][j] + " ");
			}
			System.out.println("");
			}

	        int stupac1 = 0;
	        int red1 = 0;
	        int stupac2= 4;
	        int red2 = 4;
	        int i = 0;
	        int j = 0;
	        int br=1;
	        
	        while(br <= 4 * 4){
	        	
	        	 for(i = red2 ; i >= red1; i--)
		                System.out.println(matrica[stupac2][i]); 
		                 br++;
		             for(i = stupac2 - 1; i >= stupac1 + 1; i--)
		               System.out.println(matrica[i][red1] ); 
		                 br++;
	        	
	        	 for(i = red1; i <= red2; i++)
	                 System.out.println(matrica[stupac1][i]);
	                 br++;
	             for(i = stupac1 + 1; i <= stupac2 - 1 ; i++)
	                 System.out.println(matrica[i][red2]);
	                 br++;
	            
	                 
	             red1++;
	             red2--;
	             stupac1++;
	             stupac2--;
	            
	            
	           
	        }
			
	
		
	}

}




	


