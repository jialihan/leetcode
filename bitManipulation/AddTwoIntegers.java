package leeeeeeee.bitManipulation;

/**
 * Created by jialihan on 17/1/21.
 *l
 *
 */
public class AddTwoIntegers {

    public static void main(String[] args)
    {
        int a = 1;
        int b = 2;
        int sum = getSum(a,b);
        System.out.println(a + "+" +b +" = " +sum);

    }
    public static int getSum(int a, int b) {
        // xor ^ : get the different bits in a&b
        // & and : get the carry position
        // << carry都是在高位加的，所以需要左移一位
        if(b == 0) return a;
        if(a == 0) return b;

        while(b != 0)
        {
            int carry = a&b;
            a = a ^b;
            b = carry<<1;
        }

        return a;

    }

    public static int getSum2(int a, int b) {

        String s1 = Integer.toBinaryString(a);
        String s2 = Integer.toBinaryString(b);
        int len1  = s1.length();
        int len2 = s2.length();
        String small = "";
        String large= "";
        if(len1>len2)
        {
            small = s2;
            large =s1;
        }
        else
        {  small = s1;
            large =s2;
        }
        int carry = 0;
        int i = small.length()-1;
        int j = large.length()-1;
        StringBuilder sb = new StringBuilder();
        while(i>=0)
        {

            char c1= small.charAt(i);
            char c2= large.charAt(j);
            if(c1 == '0' && c2 == '0')
            {
                if(carry == 1 )
                    sb.insert(0, '1');
                else
                    sb.insert(0, '0');
                carry = 0;
            }
            else  if(c1 == '0' && c2 == '1' ||  c1 == '1' && c2 == '0')
            {
                if(carry == 1 ) {
                    sb.insert(0, '0');
                    carry = 1;
                }
                else
                {
                    sb.insert(0, '1');
                    carry = 0;
                }

            }
            else
            {
                if(carry == 1 ) {
                    sb.insert(0, '1');
                    carry = 1;
                }
                else
                {
                    sb.insert(0, '0');
                    carry = 1;
                }
            }

            i--;
            j--;
        }
        if(j<0)
        {
            if(carry == 1)
                sb.insert(0, '1');
            return Integer.parseInt(sb.toString(),2);
        }
        else
        {
            while(j>=0) {

                char c= large.charAt(j);

                if(c == '0') {
                    if (carry == 1) {
                        sb.insert(0, '1');
                        carry = 0;
                    }
                    else
                        sb.insert(0, '1');
                }
                else // c == '1'
                {
                    if(carry == 1)
                    {
                        sb.insert(0,'0');
                        carry = 1;
                    }
                    else
                    {
                        sb.insert(0, '1');
                        carry = 0;
                    }
                }
                j--;
            }
            if(carry == 1)
                sb.insert(0, '1');
        }
        return  Integer.parseInt(sb.toString(),2);
    }
    /*
    // Iterative
public int getSum(int a, int b) {
	if (a == 0) return b;
	if (b == 0) return a;

	while (b != 0) {
		int carry = a & b;
		a = a ^ b;
		b = carry << 1;
	}

	return a;
}

// Iterative
public int getSubtract(int a, int b) {
	while (b != 0) {
		int borrow = (~a) & b;
		a = a ^ b;
		b = borrow << 1;
	}

	return a;
}

// Recursive
public int getSum(int a, int b) {
	return (b == 0) ? a : getSum(a ^ b, (a & b) << 1);
}

// Recursive
public int getSubtract(int a, int b) {
	return (b == 0) ? a : getSubtract(a ^ b, (~a & b) << 1);
}

// Get negative number
public int negate(int x) {
	return ~x + 1;
}
     */
}
