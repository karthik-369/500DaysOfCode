class Solution {
    public String sortVowels(String s) {
        int vowc = 0;
        for(char c: s.toCharArray()){
            if(isVowel(c)){
                vowc++;
            }
        }
        int vow[] = new int[vowc];
        int i=0;
        Map<Character, Integer> map= new HashMap<>();
        for(int j=0;j<s.length();j++){
            if(isVowel(s.charAt(j))){
                map.put(s.charAt(j), j);
                vow[i++] = s.charAt(j)-'a';
            }
        }
        Arrays.sort(vow);
        String answer = "";
        int temp = 0;
        for(char c:s.toCharArray()){
            if(!isVowel(c)){
                answer+=c;
            }else{
                answer+=(char)(vow[temp++]+'a');
            }
        }
        return answer;
    }
    public boolean isVowel(char c){
        return c=='a'|| c=='e'|| c=='i'|| c=='o'|| c=='u'|| c=='A'|| c=='E'|| c=='I'|| c=='O'|| c=='U';  
    }
}