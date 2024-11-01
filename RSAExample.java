package ISPractical;

public class RSAExample {
    public static long modPow(long base,long expo,long mod){
        long result =1;
        while(expo>0){
            if(expo%2==1){
                result = (result*base)%mod;
                expo--;
            }
            else{
                base = (base*base)%mod;
                expo = expo/2;
            }
        }
        return result;
    }
    public static long modInverse(long base,long mod){
        //extended euclidean to find inverse of bmodm
        long b = base;
        long m = mod;
        long q =0;
        long r=0;
        long t1 = 0;
        long t2 = 1;
        long t3 = 0;

        while(b>0){
            q=m/b;
            r=m%b;
            t3 = t1 - (t2*q);
            //left shift
            t1=t2;
            t2=t3;
            m=b;
            b=r;
        }
        if(t1<0){
            t1 = t1 + mod;
        }
        return t1;
    }
    public static long gcd(long num1,long num2){
        if(num2==0){
            return num1;
        }
         return gcd(num2,num1%num2);
    }
    public static void main(String[] args){
           long inv = modInverse(7,120);
           System.out.println(inv);
    }
}
