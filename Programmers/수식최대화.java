import java.util.*;

class 수식최대화 {
  int[][] total_order = {{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 0, 1}, {2, 1, 0}};//+-*
	Map<String, Integer> op = new HashMap<>();
	ArrayList<String> origin, exp;
    
    public void init(String expression) {
		op.put("+", 0);
		op.put("-", 1);
		op.put("*", 2);

		convertToList(expression);
	}
       
    public long solution(String expression) {
		init(expression);

		long max = 0;

		for (int i = 0; i < 6; i++) {
			long result = calc(total_order[i]);
			if (max < result) max = result;
		}

		return max;
    }
        
    public void convertToList(String expression){
		origin = new ArrayList<>();
		StringBuilder tmp = new StringBuilder();
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) != '+' && expression.charAt(i) != '-' && expression.charAt(i) != '*') {
				tmp.append(expression.charAt(i));
			} else {
				origin.add(tmp.toString());
				origin.add(expression.charAt(i) + "");
				tmp = new StringBuilder();

			}
		}
		origin.add(tmp.toString());
	}
    
    public void convert(int[] order){
		exp = new ArrayList<>();
		Stack<String> stack = new Stack<>();
		for(String item:origin){
			if(item.equals("+") || item.equals("-") || item.equals("*")){
				while(!stack.isEmpty() && order[op.get(stack.peek())] >= order[op.get(item)]){
					exp.add(stack.pop());
				}
				stack.push(item);
			}else{
				exp.add(item);
			}
		}

		while(!stack.isEmpty()) exp.add(stack.pop());
	}
    
    public long calc(int[] order){
		convert(order);
		Stack<Long> number = new Stack<>();

		for(String item:exp){
			if(item.equals("+") || item.equals("-") || item.equals("*")){
				long second = number.pop();
				long first = number.pop();
				number.push(calc(first, second, op.get(item)));
			}else{
				number.push(Long.parseLong(item));
			}
		}

		if(number.peek()<0) return -number.pop();
		return number.pop();
	}
    
    public long calc(long a, long b, int operator) {
		long result = a;
		switch (operator) {
			case 0:
				result += b;
				break;
			case 1:
				result -= b;
				break;
			case 2:
				result *= b;
				break;
		}

		return result;
	}

}
