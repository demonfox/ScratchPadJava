
public class Divide {

	public int divide(int dividend, int divisor) {
        long quotient = 0;
        boolean flag = true;
        
        long dvd = dividend;
        long dvs = divisor;
        if (dividend == 0)
        	return 0;
        
        if (dividend < 0) {
        	dvd = -dvd;
        	flag = !flag;
        }
        
        if (divisor < 0) {
        	dvs = -dvs;
        	flag = !flag;
        }
        
        long[] inc = new long[32];
        long magValue = dvs;
        
        int i = 0;
        
        // look for the largest multiple of dvs that is
        // smaller than dvd, and the multiplier is a power
        // of 2
        while (magValue > 0 && magValue <= dvd) {
        	inc[i] = magValue;
        	magValue = magValue << 1;
        	i++;
        }
        i--;
        
        while (i >= 0 && dvd != 0) {
        	if (dvd >= inc[i]) {
        		dvd -= inc[i];
        		quotient += (1 << i);
        	}
        	i--;
        }
        
        return flag ? (int)quotient :  (int)-quotient;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Divide d = new Divide();
		/* 
		System.out.println(d.divide(5, 3));
		System.out.println(d.divide(6, 3));
		System.out.println(d.divide(7, 3));
		System.out.println(d.divide(0, 3));
		System.out.println(d.divide(-5, 3));
		System.out.println(d.divide(-9, 3));
		System.out.println(d.divide(2147483647, 1));*/
		System.out.println(d.divide(-2147483648, 1));
	}

}
