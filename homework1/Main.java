package elice;

import java.io.*;
import java.util.Scanner;
import elice.EliceUtils;

public class Main {
	public static void main(String args[]) {
        long start = System.nanoTime();
        
        // Evaluate implemented functions measuring its CPU time on various inputs.
        // Measurement is intended to be understood as per trial on a single input not as 'for n = 1...10^10 do f(n)'
        // 1000001
		// System.out.println(FibRec(100));
		System.out.println(FibIter(10));
		System.out.println(FibRepSq(10));
        
        long time = System.nanoTime() - start;
        System.out.print("CPU time used (s): ");
		System.out.println((float) time / 1000000000);

	}


    public static int PRIME = 30011;
    


	/**
	 * 20pts. Implement Fibonacci number with Recursive algorithm
	 * @param n : int
	 * natural number n
	 * @return int
     * return fib(n) modulo PRIME. 
     * See the side section to see the definition
     */
	public static int FibRec(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else {
            int new_a = (FibRec(n-1) % PRIME + FibRec(n-2) % PRIME) % PRIME;
            return new_a;
        }
	}

	/**
	 * 20pts. Implement Fibonacci number with Iterative algorithm
	 * @param n : int
	 * natural number n
	 * @return int
     * return fib(n) modulo PRIME. 
     * See the side section to see the definition
     */
    public static int FibIter(int n) {
        if (n == 0)
            return 0;
            
        int front = 0;
        int front_next = 1;
        int current;
        for (int i=1; i < n; i++) {
            current = (front + front_next) % PRIME;
            front = front_next % PRIME;
            front_next = current;
        }
		
        return front_next % PRIME;
	}

	/**
	 * 30pts. Implement Fibonacci number with Repeated Squaring algorithm
	 * @param n : int
	 * natural number n
	 * @return int
     * return fib(n) modulo PRIME. 
     * See the side section to see the definition
     */
    public static int FibRepSq(int n) {
    
            int[][] fib = {{1,1}, {1,0}};
            int[][] arr = {{1,0}, {0,1}};
            int[][] cur = new int[2][2];
            int i,j,k;
            
            while (n > 0)
            {
                if (n%2 == 1) {
                    for (i=0; i<2; i++) for (j=0; j<2; j++)
                        cur[i][j] = 0;
                    
                    for (i=0; i<2; i++) for (j=0; j<2; j++) for (k=0; k<2; k++) 
                        cur[i][j] = (cur[i][j]+arr[i][k]*fib[k][j]) % PRIME;
                    
                    for (i=0; i<2; i++) for (j=0; j<2; j++)
                            arr[i][j] = cur[i][j] % PRIME;
                }
                for (i=0; i<2; i++) for (j=0; j<2; j++)
                        cur[i][j] = 0;

                for (i=0; i<2; i++) for (j=0; j<2; j++) for (k=0; k<2; k++)
                    cur[i][j] = (cur[i][j]+fib[i][k]*fib[k][j]) % PRIME;
                
                for (i=0; i<2; i++) for (j=0; j<2; j++)
                        fib[i][j] = cur[i][j] % PRIME;

                n /= 2;
            }
            
            return arr[0][1];
	}

    /**
     * 30pts (10pts each) Experiment
     * Try evaluating your implemented functions on different sizes of n
     * Determine the largest n which makes each function runs within 30 seconds
     * The number ranges among (1: [0, 100], 2: [101, 10000], 
     * 3: [10001, 1000000], 4: [1000001, 1000000000], 5: [1000000001, 2147483647])
     * store the index of the range that you could reach for each function.
     */
    public static int MAX_OF_INPUT_REC = 50;
    public static int MAX_OF_INPUT_ITER = 1000001;
    public static int MAX_OF_INPUT_REPSQ = 1800000001;


}
