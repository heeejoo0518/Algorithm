import java.util.*;

class 키패드누르기 {
    int left = -1, right = -1;
    boolean isLeft;
    Map<Integer,Integer> lines = new HashMap<>();
    
    public String solution(int[] numbers, String hand) {
        lines.put(0,3);
        lines.put(-1,3);
        for(int i=1;i<10;i+=3){
            lines.put(i, i/3);
            lines.put(i+1,i/3);
            lines.put(i+2,i/3);
        }

        isLeft = hand.equals("left");
        
        StringBuilder sb = new StringBuilder();
        for(int num:numbers){
            sb.append(select(num));
        }
        
        return sb.toString();
    }
    
    public char select(int number){
        if(number%3==1) {
            left = number;
            return 'L';
        }else if(number != 0 && number%3==0){
            right = number;
            return 'R';
        }
        
        int ldist = calc(number,true);
        int rdist = calc(number,false);
        
        if(ldist<rdist || (ldist == rdist && isLeft)){
            left = number;
            return 'L';
        }else{
            right = number;
            return 'R';
        }
    }
    
    public int calc(int number, boolean lefthand){
        int answer = 1;
        int pos = lefthand? left:right;
        
        if(pos == 0 || pos%3==2) answer-=1; 
        
        answer += Math.abs(lines.get(pos)-lines.get(number));        
        return answer;
    }
}
