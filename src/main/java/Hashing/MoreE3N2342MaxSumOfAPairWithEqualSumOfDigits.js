/** 
 * @param {number[]} nums
 * @return {number} 
 */
const maximumSum = function (nums) {
  const digitSumToMaxNums = new Map();
  let maxSum = -1;
  for (const num of nums) {
    const digitSum = Array.from(String(num), Number)
      .reduce((sum, num) => sum + num, 0);
    if (digitSumToMaxNums.has(digitSum)) {
      const preMaxNums = digitSumToMaxNums.get(digitSum);
      if(num > preMaxNums[0]) {
        preMaxNums[0] = num;
      } else if(max > preMaxNums[1]) {
        preMaxNums[1] = num;
      }
      digitSumToMaxNums.set(digitSum, preMaxNums);
      maxSum = Math.max(maxSum, preMaxNums[0] + preMaxNums[1]);
    } else {
      digitSumToMaxNums.set(digitSum, [num, -Infinity]);
    }
  }
  return maxSum;
}

