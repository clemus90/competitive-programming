import java.io.*;
import java.util.*;

public class MegaprimeNumbers {

    public static ArrayList<Long> primes = new ArrayList<>(1100000);
    public static int upperBound = 31622777;
    public static boolean [] nonPrimes = new boolean[upperBound + 1];;


    public static void genPrimes(){
        int prime = 2;
        while(prime * prime <= upperBound){
            crossPrimes(prime);
            prime = getNextPrime(prime);
        }
        for(int i=2; i<=upperBound; i++){
            if(!nonPrimes[i]){
                primes.add((long)i);
            }
        }
    }

    public static void crossPrimes(int prime){
        for(int i= prime*prime; i< nonPrimes.length; i+= prime){
            nonPrimes[i] = true;
        }
    }

    public static int getNextPrime(int prime){
        int next = prime + 1;
        while(next < nonPrimes.length && nonPrimes[next]){
            next++;
        }
        return next;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        genPrimes();

        long first, last;

        String[] inp = br.readLine().split(" ");

        first = Long.parseLong(inp[0]);
        last = Long.parseLong(inp[1]);

        int countPrimes = 0;
        MegaPrimeCandidate mpc = new MegaPrimeCandidate(first, last);
        while(mpc.hasNext()){
            long candidate = mpc.next();
            if(candidate <= upperBound){
                if(!nonPrimes[(int)candidate]){
                    countPrimes++;
                }
            }
            else{
                boolean prime = true;
                for(int i=0; primes.get(i) * primes.get(i) <= candidate; i++){
                    if(candidate % primes.get(i) == 0){
                        prime = false;
                        break;
                    }
                }
                if(prime) countPrimes++;
            }
        }

        out.println(countPrimes);

        out.close();
    }
}

class MegaPrimeCandidate implements Iterator<Long> {

    private int[] oneDigitPrimes = {2,3,5,7};
    private long currVal;
    private long upperBound;

    public MegaPrimeCandidate(long num, long upperBound){
        currVal = transformToCandidate(num);
        this.upperBound = upperBound;
    }

    public boolean hasNext(){
        return currVal <= upperBound;
    }

    public Long next(){
        long curr = currVal;
        currVal = transformToCandidate(curr + 1);
        return curr;
    }

    public long transformToCandidate(long num){
        long ret = 0;
        long base = 1;
        long digit;
        boolean correct;
        boolean carry = false;
        if(num == 0) num++;
        while(num != 0){
            digit = num % 10;
            if(carry) digit++;
            correct = false;
            for(int i=0; i<oneDigitPrimes.length; i++){
                if(oneDigitPrimes[i] == digit){
                    correct = true;
                    break;
                }else if(oneDigitPrimes[i] > digit){
                    correct = true;
                    digit = oneDigitPrimes[i];
                    break;
                }
            }
            if(!correct){
                digit = oneDigitPrimes[0];
                carry = true;
            }else{
                carry = false;
            }
            ret += digit * base;
            base *= 10;
            num /= 10;
        }
        if(carry){
            ret += oneDigitPrimes[0] * base;
        }
        return ret;
    }
}