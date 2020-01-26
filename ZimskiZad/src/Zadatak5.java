import javax.swing.JOptionPane;

public class Zadatak5 {

	public static void main(String[] args) {
		
		int x=Integer.parseInt(JOptionPane.showInputDialog("Unesite 1. broj "));
		int y=Integer.parseInt(JOptionPane.showInputDialog("Unesite 2. broj "));
		
		
		int minR=0;
		int maxR=x-1;
		int minS=0;
		int maxS=y-1;
		int br=1;
		
		int m[] []=new int [x][y];
		

		while(true) {
			 if(minS>maxS) {
				 break;
			 }

		 for(int i=maxS;i>=minS;i--){
			 m[maxR][i]=br++;
		 }
		 maxR--;
		 
		 if(minR>maxR) {
			 break;
		 }

		 for(int i=maxR;i>=minR;i--){
			 m[i][minS]=br++;
		 }
		 minS++;
		 
		 if(minS>maxS) {
			 break;
		 }

		 for(int i=minS;i<=maxS;i++){
			 m[minR][i]=br++;
		 }
		 minR++;
		 
		 if(minR>maxR) {
			 break;
		 }
		 
		 for(int i=minR;i<=maxR;i++){
			 m[i][maxS]=br++;

		 }
		 maxS--;
		 }
			

		
			
 
		
		for (int i = 0; i < x; i++)
	    {
	        for (int j = 0; j <y; j++)
	        {
	            System.out.print(m[i][j]+ "\t");
	        }
	         
	        System.out.println();
	    }
		
		
		
		
	}

}
