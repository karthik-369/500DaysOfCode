import pandas as pd

def nth_highest_salary(employee: pd.DataFrame, N: int) -> pd.DataFrame:
    temp = employee.salary.unique()
    temp = temp.tolist()
    if(N>len(temp)):
        s = 'getNthHighest({var})'
        df = pd.DataFrame(columns = [s.format(var = N)])
        return df
    
    temp.sort(reverse=True)
    ans = [temp[N-1]]
    s = 'getNthHighest({var})'
    df = pd.DataFrame(ans, columns=[s.format(var = N)])
    return df