/**
 * @param {number[][]} grid
 * @return {number}
 */
const equalRowAndColPairs = (gird) => {
  let count = 0;
  let n = grid.length;
  let rowMap = new Map();
  let colMap = new Map();

  for(let i = 0; i < n; i++) {
    let rowStr = JSON.stringify(grid[i]);
    rowMap.set(rowStr, (rowMap.get(rowStr) || 0) + 1);
  }

  // 把所有的列转换成字符串，保存在map中，重复的列要累加计数
  for(let j = 0; j < n; j++) {
    let colStr = JSON.stringify(grid.map(row => row[j]));
    colMap.set(colStr, (colMap.get(colStr) || 0) + 1);
  }

  for(let [key, value] of rowMap) {
    if(colMap.has(key)) {
      count += value * colMap.get(key);
    }
  }

  return count;

};