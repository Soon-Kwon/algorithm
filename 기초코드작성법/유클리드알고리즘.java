package 기초코드작성법;

public class 유클리드알고리즘{
    public static int gcd(int p, int q){
        if (q==0) return p;
        int r = p % q;
        return gcd(q, r);
    }
    public static void main(String args[]){
        int result = gcd(8, 12);
        System.out.println(result);
    }
}
