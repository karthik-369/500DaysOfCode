
class Solution
{
    //Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String S)
    {
        //Your code here
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(char c:S.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(char key: map.keySet()){
            if(map.get(key)==1){
                return key;
            }
        }
        
        return '$';
    }
}

