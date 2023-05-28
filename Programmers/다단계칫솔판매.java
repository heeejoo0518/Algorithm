import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Member> map = new HashMap<>();
        map.put("-", new Member(-1,null));
        for(int i=0;i<enroll.length;i++) {
            map.put(enroll[i], new Member(i,map.get(referral[i])));
        }
        
        int money;
        Member now, next;
        for(int i=0;i<seller.length;i++){
            now = map.get(seller[i]);
            next = now.next;
            money = amount[i]*100;

            while(money/10 != 0 && next != null){
                now.money += money-money/10;
                money /= 10;
                
                now = next;
                next = now.next;
            }
            
            now.money += money;
        }
        
        int[] answer = new int[enroll.length];
        for(Member mem:map.values()){
            if(mem.idx == -1) continue;
            answer[mem.idx] = mem.money;
        }
        
        return answer;
    }
    class Member {
        int idx;
        Member next = null;
        int money = 0;
        Member(int idx, Member next){this.next = next;this.idx = idx;}
    }
}
