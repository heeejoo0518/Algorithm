def solution(answers):
    answer = []
    solve = [[1,2,3,4,5],[2,1,2,3,2,4,2,5],[3,3,1,1,2,2,4,4,5,5]]
    result = [0,0,0]
    
    for i in range(len(answers)):
        for j in range(3):
            if answers[i] == solve[j][i%len(solve[j])]:
                result[j] += 1
    
    max_num = max(result)
    for i in range(len(result)):
        if result[i]==max_num:
            answer.append(i+1)
    
    return answer
