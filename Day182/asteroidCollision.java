class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length;
        int stack[] = new int[len];
        int top = -1;
        for(int i=0;i<len;i++){
            if(top==-1||asteroids[i]>0){
                stack[++top] = asteroids[i];
            }else{
                while(top>=0){
                    if(stack[top]<0){
                        stack[++top] = asteroids[i];
                        break; 
                    }else if(stack[top]+asteroids[i]==0){
                        top--;
                        break;
                    }else {
                        if(stack[top]<-asteroids[i]){
                            top--;
                            if(top==-1){
                                stack[++top] = asteroids[i];
                                break;
                            }
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        int answer[] = new int[top+1];
        System.arraycopy(stack, 0, answer, 0, top+1);
        return answer;
    }
}