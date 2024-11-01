package ISPractical;

public class DiffieHellmanExample {

    //fraud method
    public static boolean checkPrimitiveRoot(long g,long n){
        long ord = calcPow(g,n-1,n);
        System.out.println(ord);
        if(ord==1){
            return true;
        }
        return false;
    }

    public static long calcPow(long base,long expo,long mod){
        //format is n1^n2modn3
        long ans=1;
        while(expo>0){
            if(expo%2==1){
                ans = (ans*base)%mod;
                expo--;
            }
            else{
                base = (base*base)%mod;
                expo = expo/2;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        //assume g is primitive root of n
        long n = 23;
        long g = 5;
        long prA = 6;
        long prB = 15;

        //calculate pubA and pubB and shared key
        long pubA = calcPow(g,prA,n);
        long pubB = calcPow(g,prB,n);

        long key = calcPow(g,(prA*prB),n);
        System.out.println("Public key for Alice "+pubA);
        System.out.println("Public key for Bob "+pubB);
        System.out.println("Public key for Alice and Bob "+key);

        boolean check = checkPrimitiveRoot(4,5);
        System.out.println(check);
    }

}
