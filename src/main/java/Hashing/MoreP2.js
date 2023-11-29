/**
 * 
 * @param {string} jewels 
 * @param {string} stones 
 * @returns {number}
 */
const countJewels = function(jewels, stones) {
  const jewelsSet = new Set(jewels);
  let count = 0;
  for(let stone of stones) {
    if(jewelsSet.has(stone)) {
      count++;
    }
  }
  return count;
}