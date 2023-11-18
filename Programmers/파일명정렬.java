import java.util.*;

class 파일명정 {
    public String[] solution(String[] files) {
        //쪼개서 저장
        File[] filelist = new File[files.length];
        for(int i=0;i<files.length;i++){
            String[] tmp = new String[3];
            int start = 0, end;
            for(int j=0;j<2;j++){
                end = split(start,files[i],j);
                tmp[j] = files[i].substring(start, end);
                start = end;
            }
            if(start < files[i].length()) tmp[2] = files[i].substring(start);
            filelist[i] = new File(i,tmp[0], tmp[1], tmp[2]);
        }
        
        //정렬
        Arrays.sort(filelist, (o1,o2)-> {
           if(!o1.head.toUpperCase().equals(o2.head.toUpperCase())){
               return o1.head.compareToIgnoreCase(o2.head);
               //return o1.head.toUpperCase().compareTo(o2.head.toUpperCase());
           }else if(o1.num != o2.num){
               return o1.num - o2.num;
           }else{
               return o1.idx - o2.idx;
           }
        });
        
        //답 저장
        String[] answer = new String[files.length];
        int i=0;
        for(File file:filelist){
            StringBuilder sb = new StringBuilder();
            sb.append(file.head);
            sb.append(file.number);
            sb.append(file.tail);
            answer[i++] = sb.toString();
        }
        
        return answer;
    }
    
    //입력받은 위치부터 탐색하되, 첫번째위치와 탐색위치 종류가 다르면 리턴하고 끝
    public int split(int i, String filename, int type){
        int count = 0;
        boolean isNum = filename.charAt(i)>='0' && filename.charAt(i) <= '9';
        for(;i<filename.length();i++){
            if(isNum != (filename.charAt(i)>='0' && filename.charAt(i) <= '9')){
                break;
            }else if(type==1 && count > 5){
                break;
            }
            count++;
        }
        return i;
    }
    
    class File {
        int idx;
        String head;
        String number;
        int num;
        String tail = "";
        File(int idx, String head, String number, String tail){
            this.idx = idx;
            this.head = head;
            this.number = number;
            this.num = Integer.parseInt(number);
            if(tail != null) this.tail = tail;
        }
    }
}
