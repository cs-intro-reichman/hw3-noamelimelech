// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
        System.out.println(plus(2,3));   // 2 + 3
        System.out.println(minus(7,2));  // 7 - 2
        System.out.println(minus(2,7));  // 2 - 7
        System.out.println(times(3,4));  // 3 * 4
        System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
        System.out.println(pow(5,3));      // 5^3
        System.out.println(pow(3,5));      // 3^5
        System.out.println(div(12,3));   // 12 / 3    
        System.out.println(div(5,5));    // 5 / 5  
        System.out.println(div(25,7));   // 25 / 7
        System.out.println(mod(25,7));   // 25 % 7
        System.out.println(mod(120,6));  // 120 % 6    
        System.out.println(sqrt(36));
        System.out.println(sqrt(263169));
        System.out.println(sqrt(76123));

	
	}  



	// Returns x1 + x2
	public static int plus(int num1, int num2 ) {
		int count=0;
		while(count != num2){
			count++;
			num1++;
		}
		return num1;
		// Replace the following statement with your code
		
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int count = 0;
		while(count != x2){
			count++;
			x1--;
		}
		
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int a= 0;	
		if(x2<0){
			for(int i=0; i!=x2; i--){               
			 a = plus(a,x1);
			}
	
		}
		else{
							
		for(int i=0; i!=x2; i++){               
			 a = plus(a,x1);
	
		}
	}
		return a;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if(n==0){
			return 1;
		}
		int always = x;
		for(int count = 1; count != n; count++){
			x=times(always,x);
				}
	
		return x;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		if(x2==0)return 0;
		int count=0;
		while(x1>=x2){
			count++;
			x1=minus(x1, x2);
		}
		return count;


	}
	
		// Replace the following statement with your code
     
	// Returns x1 % x2
	public static int mod(int x1, int x2) {
			if(x1==0)return 0;
			if(x2==0)return -1; //eror - not possible 
		int count=0;
		while(x1>=x2){
			count++;
			x1=minus(x1, x2);
		}
		return x1;


	
	}

	public static int sqrt(int x) {
   	 	if (x < 0) {
        	return -1; // -1 for error
    	}

    int count = 0;
    // while (count * count) <= x
   	 	while (times(count, count) <= x) {
   	     	count++;
   		}

    return count - 1; 
	}
}