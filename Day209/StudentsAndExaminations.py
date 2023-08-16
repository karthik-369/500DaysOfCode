import pandas as pd

def students_and_examinations(students: pd.DataFrame, subjects: pd.DataFrame, examinations: pd.DataFrame) -> pd.DataFrame:

    group = examinations.groupby(['student_id', 'subject_name'], as_index = False).agg(attended_exams = ('subject_name', 'count'))

    students = students.merge(subjects, how='cross')
    attended_exams = students.merge(group, how='left', on=['student_id', 'subject_name']).fillna(0)
    return attended_exams[['student_id', 'student_name', 'subject_name', 'attended_exams']].sort_values(by=['student_id', 'subject_name'])
