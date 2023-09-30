import java.util.*;

class 압축 {
    Map<String, Integer> dict = new HashMap<>();
    public int[] solution(String msg) {
        int len = msg.length();
        msg += '.';//더미문자열추가
        ArrayList<Integer> list = new ArrayList<>();
        init();

        String sub;
        for(int i=0;i<len;i++){
            for(int j=len;j>i;j--){
                sub = msg.substring(i,j); 
                
                if(dict.containsKey(sub)){
                    list.add(dict.get(sub));
                    dict.put(sub+msg.charAt(j), dict.size()+1);
                    i = j-1;
                    break;
                }
            }
            
        }
        
        return convert(list);
    }
       
    private void init(){
        for(int i='A';i<='Z';i++){
            dict.put(String.valueOf((char)i), i-'A'+1);
        }
    }
    
    private int[] convert(ArrayList<Integer> list){
        int[] result = new int[list.size()];
        for(int i=0;i<result.length;i++){
            result[i] = list.get(i);
        }
        
        return result;
    }
}
