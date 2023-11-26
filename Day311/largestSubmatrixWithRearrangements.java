LeetCode Logo
Daily Question
311

avatar
Premium
Debugging...
Debugging...







Run
Description
Editorial
Editorial
Solutions
Solutions
Submissions
Submissions

Code

Testcase
Test Result
Test Result

1727. Largest Submatrix With Rearrangements
Solved
Medium
Topics
Companies
Hint
You are given a binary matrix matrix of size m x n, and you are allowed to rearrange the columns of the matrix in any order.

Return the area of the largest submatrix within matrix where every element of the submatrix is 1 after reordering the columns optimally.

 

Example 1:


Input: matrix = [[0,0,1],[1,1,1],[1,0,1]]
Output: 4
Explanation: You can rearrange the columns as shown above.
The largest submatrix of 1s, in bold, has an area of 4.
Example 2:


Input: matrix = [[1,0,1,0,1]]
Output: 3
Explanation: You can rearrange the columns as shown above.
The largest submatrix of 1s, in bold, has an area of 3.
Example 3:

Input: matrix = [[1,1,0],[1,0,1]]
Output: 2
Explanation: Notice that you must rearrange entire columns, and there is no way to make a submatrix of 1s larger than an area of 2.
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m * n <= 105
matrix[i][j] is either 0 or 1.
Seen this question in a real interview before?
1/4
Yes
No
Accepted
31.1K
Submissions
44.4K
Acceptance Rate
69.9%
Topics
Companies
Hint 1
Hint 2
Similar Questions
Discussion (29)

Choose a type

















Copyright ©️ 2023 LeetCode All rights reserved

1.3K


29



Java
Auto



1234567891011
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int answer = 0;
        for (int i=0; i<matrix.length; i++) {
            for (int j =0; j<matrix[0].length; j++) {
                if( matrix[i][j] != 0 && i > 0) {
                    matrix[i][j] += matrix[i-1][j];
                }
            }
            int row[] = matrix[i].clone();

Saved to local
Case 1
Case 2
Case 3

matrix =
[[0,0,1],[1,1,1],[1,0,1]]
1
[[0,0,1],[1,1,1],[1,0,1]]
[[1,0,1,0,1]]
[[1,1,0],[1,0,1]]
