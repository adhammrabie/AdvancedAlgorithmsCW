package DuplicateAlgorithm;

import java.util.Arrays;

public class removearrayduplicates {
	public static int removearrayDuplicates(int[] arr, int n){  
        if (n==0 || n==1){  
            return n;  
        }  
        int[] temp = new int[n];  
        int j = 0;  
        for (int i=0; i<n-1; i++){  
            if (arr[i] != arr[i+1]){  
                temp[j++] = arr[i];  
            }  
         }  
        temp[j++] = arr[n-1];     
        // Changing original array  
        for (int i=0; i<j; i++){  
            arr[i] = temp[i];  
        }  
        return j;  
    }  
       
    public static void main (String[] args) {  
    	int arr[] = {7, 29, 7, 9, 4, 29, 5};  
    	Arrays.sort(arr); // sort the array
    	int length = arr.length;  
    	length = removearrayDuplicates(arr, length);  
    	//printing array elements  
    	for (int i=0; i<length; i++)  
    	   System.out.print(arr[i]+" ");  
    }  
} 

