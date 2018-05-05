/*
Taylor Earl
Assignment 1
CS2130
 */

public class Assignment1 {

    public static void main(String[] args) {
        // TODO code application logic here
        
        int[] setA = {1, 3, 5, 6, 8};
        int[] setB = {2, 3, 4, 7, 9};
        
        int[] A = {0, 1, 0, 1, 0, 1, 1, 0, 1, 0};
        int[] B = {0, 0, 1, 1, 1, 0, 0, 1, 0, 1};
        
        
        System.out.println("Assignment 1");
        System.out.println("Taylor Earl");
        System.out.println("CS 2130");
        
        
        System.out.println("Set A: {1, 3, 5, 6, 8}");
        System.out.println("Set B: {2, 3, 4, 7, 9}");
        
        
        // A intersect B
        System.out.print("A intersect B = {");
        for(int i=0; i < 10; i++)
        {
           
            if (A[i] == B[i])
            {
                System.out.print(i + ", "); 
            };
        }
        System.out.println("}");
        
        
        // A union B
        System.out.print("A union B = {");
        for(int i=0; i < 10; i++)
        {
            if (A[i] == 1 || B[i] == 1)
            {
                System.out.print(i + ", "); 
            }; 
        }
         System.out.println("}");       
        


        // A - B
        System.out.print("A - B = {");
                for(int i=0; i < 10; i++)
        {
            if (A[i] == 1 && B[i] == 0)
            {
                System.out.print(i + ", ");  
            }        
        }
        System.out.println("}");
        
        
        
    }
    
}