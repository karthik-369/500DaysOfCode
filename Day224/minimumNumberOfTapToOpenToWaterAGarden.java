class Solution {
    public int minTaps(int n, int[] ranges) {
        int arr[][] = new int[n+1][2];
				for (int i=0; i<=n; i++) {
					arr[i][0] = Math.max(0, i - ranges[i]);
					arr[i][1] = Math.min(n, i + ranges[i]);
				}
				Arrays.sort(arr, (a,b)->{
					if (a[0] == b[0]) {
						return b[1] - a[1];
					} else {
						return a[0] - b[0];
					}
				});
				// for (int i=0; i<=n; i++) {
				// 	System.out.println(arr[i][0] +" "+ arr[i][1]);
				// }
				if (arr[0][0] > 0) {
					return -1;
				}
				int end = arr[0][1];
				int count = 0;
				for (int i=0; i<=n; i++) {
					count++;
					if (end >= n) {
						return count;
					}
					int newEnd = end;
					for (int j=i+1; j<n; j++) {
						if (arr[j][0] <= end && arr[j][1]>newEnd) {
							i = j;
							newEnd = arr[j][1];
						}
					}
					if (newEnd == end) {
						return -1;
					}
					end = newEnd;
					i--;
				}
				return -1;
    }
}