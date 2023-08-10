import pandas as pd

def find_managers(employee: pd.DataFrame) -> pd.DataFrame:

    temp = employee.groupby('managerId').agg(count_reports=('id', 'count')).reset_index()
    lis = temp[temp['count_reports']>=5]['managerId'].to_list()
    answer = employee[employee['id'].isin(lis)][['name']]
    return answer


data = {'id': [101, 102, 103, 104, 105, 106],
        'name': ['John', 'Dan', 'James', 'Amy', 'Anne', 'Ron'],
        'department': ['A', 'A', 'A', 'A', 'A', 'B'],
        'managerId': [None, 101, 101, 101, 101, 101]}

# Create a DataFrame
df = pd.DataFrame(data)

print(find_managers(df))