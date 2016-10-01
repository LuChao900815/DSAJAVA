package DSAJAVA;
public class Sum {

	public int SumI(int[] A){
		int sum = 0;
		for(int i = 0; i < A.length; ++i){
			sum += A[i];
		}
		return sum;
	}
	
	public int SumR1(int[] A,int n){
		return (n < 1 ? 0 : A[n-1] + SumR1(A,n-1));
	}
	
	public int SumR2(int[] A,int lo,int hi){
		if(lo == hi){
			return A[lo];
		}
		int mi = (lo + hi) >> 1;
		return SumR2(A,lo,mi) + SumR2(A,mi+1,hi);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
