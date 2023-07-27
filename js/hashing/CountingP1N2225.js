/**
 * @param {number[][]} matches
 * @return {number[][]}
 这题要返回的是没输过的人，和只输过一次的人
 先获得所有玩家的set，再获得每个玩家输过几次的map
 没输过的人，是只要不在map里，都是
 输过一次的人，是只要map里的值是1，就算
 */
 var findWinners = function(matches) {
  let allPlayers = new Set();
  let losers = new Map();
  for(let match of matches) {
      let [winner, loser] = match;
      allPlayers.add(winner);
      allPlayers.add(loser);
      losers.set(loser, (losers.get(loser) || 0) + 1);
  }
  let undefeated = Array.from(allPlayers)
      .filter((player) => !losers.get(player))
      .sort((a, b) => a - b);
  let oneLoss = Array.from(losers)
      .filter(([player, losses]) => losses === 1)
      .map(([player, losses]) => player)
      .sort((a, b) => a - b);
  return [undefeated, oneLoss];
}
