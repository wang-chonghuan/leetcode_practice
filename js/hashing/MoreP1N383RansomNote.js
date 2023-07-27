/**
 * @param {string} ransomNote
 * @param {string} magazine
 * @return {boolean}
 */
var canConstruct = function(ransomNote, magazine) {
  const charMap = new Map();
  for(let char of magazine) {
      if(charMap.has(char)) {
          charMap.set(char, charMap.get(char) + 1);
      } else {
          charMap.set(char, 1);
      }
  }
  for(let tar of ransomNote) {
      if(charMap.has(tar) && charMap.get(tar) >= 1) {
          charMap.set(tar, charMap.get(tar) - 1)
      } else {
          return false;
      }
  }
  return true;
};