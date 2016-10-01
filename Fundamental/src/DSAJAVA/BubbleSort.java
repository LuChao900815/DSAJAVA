package DSAJAVA;
import java.util.Arrays;

public class BubbleSort {
	
	public static void bubbleSort(int[] A){
		int n = A.length;
		for(boolean isSorted = false; isSorted = !isSorted; n--){
			for(int i = 1; i < n; ++i){
				if(A[i - 1] > A[i]){
					int t = A[i - 1];
					A[i - 1] = A[i];
					A[i] = t;
					isSorted = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,4,2,4,5,7};
		bubbleSort(A);
		System.out.println(Arrays.toString(A));
	}

}
