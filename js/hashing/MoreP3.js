/**
 * @param {string} s
 * @return {number}
 * 在这个算法中，map 是用来存储字符串中每个字符最后出现的位置，而不仅仅是窗口内的元素。当窗口滑动时，即使有些字符已经不在窗口内了，我们也不从 map 中删除它们的记录。这是因为我们需要知道这些字符最后一次出现的位置，以便在后面的窗口中遇到这些字符时能正确地移动 left。

这也是为什么我们在移动 left 时需要使用 Math.max 函数的原因，就是为了确保 left 不会回退到窗口外面去。
 */
const lengthOfLongestSubstring = function(s) {
    let map = new Map();
    let left = 0;
    let maxLength = 0;
    for(let right = 0; right < s.length; right++) {
      if(map.has(s[right])) {
        left = Math.max(left, map.get(s[right]) + 1);
      }
      map.set(s[right], right);
      maxLength = Math.max(maxLength, right - left + 1);
    }
    return maxLength;
};