// Java Program for painter's partition problem
import java.util.*;
import java.io.*;
 
class GFG {
    // return the maximum element from the array
    static int getMax(int arr[], int n)
    {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }
 
    // return the sum of the elements in the array
    static int getSum(int arr[], int n)
    {
        int total = 0;
        for (int i = 0; i < n; i++)
            total += arr[i];
        return total;
    }
 
    // find minimum required painters for given maxlen
    // which is the maximum length a painter can paint
    static int numberOfPainters(int arr[], int n, int maxLen)
    {
        int total = 0, numPainters = 1;
 
        for (int i = 0; i < n; i++) {
            total += arr[i];
 
            if (total > maxLen) {
 
                // for next count
                total = arr[i];
                numPainters++;
            }
        }
 
        return numPainters;
    }
 
    static int partition(int arr[], int n, int k)
    {
        int lo = getMax(arr, n);
        int hi = getSum(arr, n);
 
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int requiredPainters = numberOfPainters(arr, n, mid);
 
            // find better optimum in lower half
            // here mid is included because we
            // may not get anything better
            if (requiredPainters <= k)
                hi = mid;
 
            // find better optimum in upper half
            // here mid is excluded because it gives
            // required Painters > k, which is invalid
            else
                lo = mid + 1;
        }
 
        // required
        return lo;
    }

    static int n,p;

    public static void main(String[] args) throws Exception {
		try ( 
			InputStreamReader is= new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(is);
		) { 
			String line = br.readLine();
				
			while(line!=null && line.length()>0 && !"0 0".equals(line)) {
				final String [] dataStr = line.split(" ");
                n = Integer.parseInt(dataStr[0]);
                p = Integer.parseInt(dataStr[1]);
                line = br.readLine();
                String [] tareas = line.split(" ");
				int[] tiempos = Arrays.stream(tareas).mapToInt(f->Integer.parseInt(f)).toArray();
                
                System.out.println(partition(tiempos,n,p ));

				line = br.readLine();
			}
		}
	}
}