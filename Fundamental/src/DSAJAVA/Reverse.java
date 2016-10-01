package DSAJAVA;
public class Reverse {
	/**
	 * 倒置数组，递归版
	 * @param A
	 * @param lo
	 * @param hi
	 */
	public static void reverseR(int[] A,int lo,int hi){
		if(lo < hi){
			int t = A[lo];
			A[lo] = A[hi];
			A[hi] = t;
			reverseR(A,lo+1,hi-1);
		}
	}
	
	public static void reverseI(int[] A,int lo,int hi){
		while(lo < hi){
			int t = A[lo];
			A[lo++] = A[hi];
			A[hi--] = t;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
