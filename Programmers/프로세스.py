def solution(priorities, location):
    answer = 0    
    idx = 0
    while any(priorities):
        if priorities[idx] == max(priorities):
            priorities[idx] = 0
            answer += 1
            if idx == location:
                return answer
        else:
            idx = (idx+1)%len(priorities)
