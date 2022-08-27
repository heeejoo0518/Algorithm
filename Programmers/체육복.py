def solution(n, lost, reserve):
    set_and = set(reserve) & set(lost)
    
    reserve = list(set(reserve) - set_and)
    lost = list(set(lost) - set_and)

    for i in reserve:
        if i-1 in lost:
            lost.remove(i-1)
        elif i+1 in lost:
            lost.remove(i+1)
            
    return n - len(lost)
