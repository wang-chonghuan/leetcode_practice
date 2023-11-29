/**
 * @param {string} text
 * @return {number}
 */
var maxNumberOfBalloons = function(text) {
    let charFreq = {b: 0, a: 0, l: 0, o: 0, n: 0};
    for(let char of text) {
        if(charFreq.hasOwnProperty(char)) {
            charFreq[char]++;
        }
    }
    charFreq['l'] = Math.floor(charFreq['l'] / 2);
    charFreq['o'] = Math.floor(charFreq['o'] / 2);
    return Math.min(...Object.values(charFreq));
};