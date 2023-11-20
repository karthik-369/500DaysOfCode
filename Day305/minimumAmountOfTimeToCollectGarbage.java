class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int im  = -1, ig = -1, ip = -1;
        int cm = 0, cg = 0, cp = 0;
        for (int i=1; i<travel.length;i++) {
            travel[i] += travel[i-1];
        }
        for (int i=0; i<garbage.length; i++) {
            for (char v : garbage[i].toCharArray()) {
                if (v == 'M') {
                    im = i;
                    cm++;
                } else if( v == 'G') {
                    ig = i;
                    cg++;
                } else {
                    ip = i;
                    cp++;
                }
            }
        }
        // fmt.Println( im , ig, ip)
        // fmt.Println(cm ,cg, cp)
        // return 1
        int answer = 0;
        if (cm != 0) {
            if (im == 0) {
                answer += cm ;
            } else {
                answer += (cm + travel[im-1]);

            }
        }
        if (cg != 0  ) {
            if (ig == 0) {
                answer += cg;
            } else {
                
                answer += (cg + travel[ig -1]);
            }
        }
        if (cp != 0 ){
            if (ip == 0) {
                answer += cp;
            } else {

                answer += (cp + travel[ip-1]);
            }
        }
        return answer;
    }
}