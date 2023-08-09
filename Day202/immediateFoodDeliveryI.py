import pandas as pd

def food_delivery(delivery: pd.DataFrame) -> pd.DataFrame:
   
    count = (delivery['order_date']==delivery['customer_pref_delivery_date']).sum()
    per = round(count/len(delivery)*100,2)
    return pd.DataFrame({'immediate_percentage':[per]})


delivery_id = [1,2,3,4,5,6]
customer_id = [1,5,1,3,4,2]
order_date = ['2019-08-01','2019-08-02','2019-08-11','2019-08-24','2019-08-21','2019-08-11']
customer_pref_delivery_date = ['2019-08-02','2019-08-02','2019-08-11','2019-08-26','2019-08-22','2019-08-13']
dic = {'delivery_id':delivery_id, 'customer_id':customer_id, 'order_date':order_date, 'customer_pref_delivery_date':customer_pref_delivery_date}

df = pd.DataFrame(dic)

print(food_delivery(df))