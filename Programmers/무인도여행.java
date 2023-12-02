import java.util.*;

class 무인도여행 {
    int[][] deltas = {{1,0},{0,1},{0,-1},{-1,0}};
    int I, J;
    char[][] map;
    public int[] solution(String[] maps) {
        I = maps.length;
        J = maps[0].length();
        ArrayList<Integer> list = new ArrayList<>();
        
        map = new char[maps.length][];
        for(int i=0;i<I;i++){
            map[i] = maps[i].toCharArray();
        }
        
        for(int i=0;i<I;i++){
            for(int j=0;j<J;j++){
                if(map[i][j]=='X') continue;
                list.add(dfs(i, j));
            }
        }
        
        if(list.size()==0) return new int[]{-1};
        
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    public int dfs(int i, int j){
        int count = map[i][j]-'0';
        map[i][j] = 'X';
        int ni, nj;
        for(int[] d:deltas){
            ni = i+d[0];
            nj = j+d[1];
            if(ni<0 || nj<0 || ni >= I || nj >= J || map[ni][nj] == 'X') continue;
            count += dfs(ni, nj);
        }
        
        return count;
    }
}
