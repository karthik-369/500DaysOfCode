class Solution
{
    //Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        // code here
        List<Integer> list =new ArrayList<>();
        while(!s.isEmpty()){
            list.add(s.pop());
        }
        int mid = 0;
        if(sizeOfStack%2==1){
            mid = sizeOfStack/2;
        }else{
            mid = sizeOfStack/2;
        }
        
        for(int i=list.size()-1;i>=0;i--){
            if(mid == i){
                continue;
            }
            s.add(list.get(i));
        }
    } 
}
