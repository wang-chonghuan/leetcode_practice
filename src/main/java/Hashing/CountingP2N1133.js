/**
 * @param {number[]} nums
 * @return {number}
 */
var largestUniqueNumber = function(nums) {
  let numFreq = new Map();
  for(let num of nums) {
      numFreq.set(num, (numFreq.get(num) || 0) + 1);
  }
  let oneOccur = Array.from(numFreq)
      .filter(([num, freq]) => freq === 1)
      .map(([num, freq]) => num)
      .sort((a, b) => b - a)
  return oneOccur[0] || -1;
};