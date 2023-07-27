/**
 * @param {string[]} strs
 * @return {string[][]}
 * Group Anagrams

Given an array of strings strs, group the anagrams together.

For example, given strs = ["eat","tea","tan","ate","nat","bat"], return [["bat"],["nat","tan"],["ate","eat","tea"]].
 */
const groupAnagrams = (strs) => {
  const strToWords = new Map();
  for(const str of strs) {
    const key = [...str].sort().join('');
    const val = strToWords.get(key);
    if(val) {
      val.push(str);
    } else {
      strToWords.set(key, [str]);
    }
  }
  return [...strToWords.values()];
};