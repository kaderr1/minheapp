import java.io.*;
 
class GFG {
     
    
    static void heapify(int arr[], int n, int i)
    {
        int smallest = i; 
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
       
        if (l < n && arr[l] < arr[smallest])
            smallest = l;
 
        
        if (r < n && arr[r] < arr[smallest])
            smallest = r;
 
        
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
 
            
            heapify(arr, n, smallest);
        }
    }
 
    // main function to do heap sort
    static void heapSort(int arr[], int n)
    {
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
 
        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
             
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call min heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
 
    
    static void printArray(int arr[], int n)
    {
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
   
    public static void main(String[] args)
    {
        int arr[] = { 4, 6, 3, 2, 9 };
        int n = arr.length;
 
        heapSort(arr, n);
 
        System.out.println("Sorted array is ");
        printArray(arr, n);
    }
}