/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package clases;


import java.io.FileNotFoundException;
import clases.IntArrayHandler;

public class Main {
    
    public static void main (String [] args) throws FileNotFoundException {
    	 
    	
    	 
    	int[] a = {3,7,6,8,5,2,9,4};
    	IntArrayHandler.ordenaIntercambio(a);
    	for(int i = 0;i<a.length-1;i++) {
		System.out.print(a[i] + ",");
	}
    	System.out.println("\n");
    	System.out.println(IntArrayHandler.busquedaDicotomica(5, a));
//    	System.out.println("\n");
//    	System.out.println(IntArrayHandler.busquedaBinaria(5, a));

    	
    }
}
    	
    	


