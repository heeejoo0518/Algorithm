import java.util.*;

class Solution {
    public long solution(long w, long h) {
        long answer = w*h;
        long g = gcd(w,h);
        w /= g;
        h /= g;
        
        long white = w*h-(w-1)*(h-1);
        answer -= white*g;
        
        return answer;
    }
    
    public long gcd(long a, long b){
        if(a<b){
            long tmp = a;
            a = b;
            b = tmp;
        }
        if(b==0) return a;
        return gcd(b,a%b);
    }
}
