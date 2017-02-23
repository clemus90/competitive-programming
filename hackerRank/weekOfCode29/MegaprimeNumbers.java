import java.io.*;
import java.util.*;

public class MegaprimeNumbers {

    public static ArrayList<Integer> primes = new ArrayList<>(1100000);
    public static int[] oneDigitPrimes = {2,3,5,7};
    public static int upperBound = 31622777;

    public static void genPrimes(){
        for(int i=0; i<oneDigitPrimes.length; i++){
            primes.add(oneDigitPrimes[i]);
        }

        for(int i=9; i<upperBound; i+=2){
            boolean isPrime = true;
            int j = 1;
            int testPrime = primes.get(j);
            while(testPrime * testPrime <= i){
                if(i % testPrime == 0){
                    isPrime = false;
                    break;
                }
                testPrime = primes.get(++j);
            }
            if(isPrime){
                primes.add(i);
            }
        }
    }

    public static void genPrimesSieve(){
        boolean [] nonPrimes = new boolean[upperBound + 1];
        int prime = 2;
        while(prime * prime <= upperBound){
            crossPrimes(nonPrimes, prime);
            prime = getNextPrime(nonPrimes, prime);
        }
        for(int i=0; i<=upperBound; i++){
            if(!nonPrimes[i]){
                primes.add(i);
            }
        }
    }

    public static void crossPrimes(boolean[] nonPrimes, int prime){
        for(int i= prime*prime; i< nonPrimes.length; i+= prime){
            nonPrimes[i] = true;
        }
    }

    public static int getNextPrime(boolean[] nonPrimes, int prime){
        int next = prime + 1;
        while(next < nonPrimes.length && nonPrimes[next]){
            next++;
        }
        return next;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        long init = System.currentTimeMillis();
        //genPrimes();
        genPrimesSieve();
        init = System.currentTimeMillis() - init;
        out.println("time " + init);
        out.println(primes.size());

        out.close();
    }
}