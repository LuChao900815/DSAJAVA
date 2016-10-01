package DSAJAVA;
import java.util.Arrays;
import java.util.Random;

public class Max2 {
	
	/**
	 * 循环版
	 * @param A
	 * @param lo
	 * @param hi
	 * @param x1
	 * @param x2
	 */
	public static void max2(int[] A, int lo,int hi, Integer x1, Integer x2){
		
		for(int i = lo; i < hi; ++i){
			if(A[i] > A[x1.intValue()]){
				x1 = i;
			}
		} //get x1
		
		for(int i = lo; i < x1.intValue(); ++i){
			if(A[i] > A[x2.intValue()]){
				x2 = i;
			}
		}
		
		for(int i = x1.intValue() + 1; i < hi; ++i){
			if(A[i] > A[x2.intValue()]){
				x2 = i;
			}
		}
		
		System.out.println("x1 = " + x1 + ", x2 = " + x2);
	}
	
	/**
	 * 改进版
	 * @param A
	 * @param lo
	 * @param hi
	 * @param x1
	 * @param x2
	 */
	public static void max2I(int[] A, int lo,int hi, Integer x1, Integer x2){
		
		x1 = lo;
		x2 = lo + 1;
		if(A[x1.intValue()] < A[x2.intValue()]){
			int t = x2.intValue();
			x2 = x1;
			x1 = t;
		}
		
		for(int i = lo + 2; i < hi; ++i){
			if(A[i] > A[x2]){
				if(A[x2 = i] > A[x1]){
					int t = x2.intValue();
					x2 = x1;
					x1 = t;
				}
			}
		}
		System.out.println("x1 = " + x1 + ", x2 = " + x2);
	}
	
	/**
	 * 递归版
	 * @param A
	 * @param lo
	 * @param hi
	 * @return
	 */
	public static int[] max2R(int[] A, int lo,int hi){
		if(lo + 2 == hi){
			int x1 = lo,x2 = lo+1;
			if(A[x1] < A[x2]){
				int t = x1;
				x1 = x2;
				x2 = t;
			}
			return new int[]{x1,x2};
		}
		if(lo + 3 == hi){
			int x1 = lo, x2 = lo + 1, x3 = lo + 2;
			if(A[x1] < A[x2])
			{
				int t = x1;
				x1 = x2;
				x2 = t;
			}
			if(A[x2] < A[x3])
			{
				x2 = x3;
			}
			if(A[x1] < A[x2])
			{
				int t = x1;
				x1 = x2;
				x2 = t;
			}
			
			return new int[]{x1,x2};
		}
		int mi = (lo + hi) >> 1;
		int[] xL = new int[2];
		int[] xR = new int[2];
		xL = max2R(A,lo,mi);
		xR = max2R(A,mi,hi);
		
		if(A[xL[0]] < A[xR[0]]){
			return  new int[]{xR[0], A[xL[0]] > A[xR[1]] ? xL[0] : xR[1]};
		}
		else
		{
			return  new int[]{xL[0], A[xR[0]] > A[xL[1]] ? xR[0] : xL[1]};
		}
	}

	public static void generateRandArray(int[] A){
		Random rand = new Random(47);
		for(int i = 0; i < A.length; ++i){
			A[i] = rand.nextInt(100);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = new int[10];
		generateRandArray(a);
		System.out.println(Arrays.toString(a));
		
		//循环版
		max2(a,0,a.length,0,0);
		
		//改进版
		max2I(a,0,a.length,0,0);
		
		//递归版
		System.out.println(Arrays.toString(max2R(a,0,a.length)));
	}
}
