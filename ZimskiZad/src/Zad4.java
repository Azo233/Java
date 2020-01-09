import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Zad4 {

	public static void main(String[] args) {
		
		

		
		int [] [] matrica1=new int [4][4];
		int [] [] matrica2=new int [4][4];
	
		
		for (int i=0;i<4;i++) {
			for (int j=0;j<4;j++) {  
				
				matrica1[i][j]=Integer.parseInt(JOptionPane.showInputDialog("Unesite elemente u 1. matricu " + (i+1) + " " + (j+1)));
				matrica2[i][j]=Integer.parseInt(JOptionPane.showInputDialog("Unesite elemente u 2. matricu " + (i+1) + " " + (j+1)));
				
				System.out.print(matrica1[i][j]+ matrica2[i][j] + " ");
			}
			System.out.println("");
		}
	
	
	
	
	
	
	
		

	}

	}
