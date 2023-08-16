import pandas as pd

def replace_employee_id(employees: pd.DataFrame, employee_uni: pd.DataFrame) -> pd.DataFrame:
    answer = pd.merge(employees, employee_uni, how='left', on = 'id')
    return answer[['unique_id', 'name']]
