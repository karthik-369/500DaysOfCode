import pandas as pd

def count_salary_categories(accounts: pd.DataFrame) -> pd.DataFrame:
    low = (accounts['income']<20000).sum()
    high = (accounts['income']>50000).sum()
    mid = len(accounts)-(low+high)
    dic = {'category':['High Salary', 'Low Salary', 'Average Salary'], 'accounts_count':[high, low, mid]}
    return pd.DataFrame(dic)


account_id = [3,2,8,6]
income = [108939, 12747, 87709, 91796]

dic = {'account_id':account_id, 'income':income}
df = pd.DataFrame(dic)
print(count_salary_categories(df))