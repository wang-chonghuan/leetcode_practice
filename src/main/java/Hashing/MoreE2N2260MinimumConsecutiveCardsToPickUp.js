/**
 * @param {number[]} cards
 * @return {number}
 */
const minimumCardPickup = (cards) => {
  const numToLastOccur = new Map();
  let minLen = Infinity;
  for(let i = 0; i < cards.length; i++) {
    const lastOccur = numToLastOccur.get(cards[i]);
    // 此处不能用if(lastOccur)，否则会返回一个0，导致这里检测失败！
    if(numToLastOccur.has(cards[i])) {
      minLen = Math.min(minLen, i - lastOccur + 1);
    }
    numToLastOccur.set(cards[i], i);
  }
  return minLen === Infinity ? -1 : minLen;
};