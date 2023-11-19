int l = nums.length;
    Arrays.sort(nums)
    for (int i=0; i<l/2; i++) {
        int temp  = nums[i]
        nums[i] = nums[l-i-1]
        nums[l-i-1] = temp
    }

    int answer = 0
    for (int i=0; i<l-1; i++) {
        if (nums[i] == nums[l-1]) {
            return answer
        }
        if (nums[i] != nums[i+1]) {
            answer += i+1
        }
    }
    return answer