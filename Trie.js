class Node {
    isWord = false
    arr = []
}

class Trie {
    root = new Node()

    addWord(word) { //cat
        
        let lettersAscii = this.#convertWordToAsciiArray(word);

        let curr = this.root
        for(let letterAscii of lettersAscii) {
            if(!curr.arr[letterAscii]) {
                curr.arr[letterAscii] = new Node()
            } 
            curr = curr.arr[letterAscii]
        }
        curr.isWord = true
    }

    search(word) {
        let lettersAscii = this.#convertWordToAsciiArray(word);

        let curr = this.root
        for(let letterAscii of lettersAscii) {
            if(!curr.arr[letterAscii]) {
                return false;
            } 
            curr = curr.arr[letterAscii]
        }
        return curr.isWord
    }

    giveWordSuggestions(prefix) { //ca
        let suggestions = []
        
        let lettersAscii = this.#convertWordToAsciiArray(prefix);
        let curr = this.root
        for(let letterAscii of lettersAscii) {
            if(!curr.arr[letterAscii]) {
                return suggestions;
            } 
            curr = curr.arr[letterAscii]
        }
        helper(curr, prefix)
        return suggestions
        
        function helper(currNode, currWord) {
            if(currNode.isWord) {
                suggestions.push(currWord)
            }
            for(let i = 0; i<currNode.arr.length; i++) {
                if(currNode.arr[i]) {
                    helper(currNode.arr[i], currWord+String.fromCharCode(97+i))
                }
            }
        }
    }

    #convertWordToAsciiArray(word) {
        let letters = word.split("")
        let lettersAscii = letters.map(letter=> {
            return letter.charCodeAt() - "a".charCodeAt()
        })
        return lettersAscii
    }
}

let trie = new Trie()

trie.addWord('cat')
trie.addWord('car')
trie.addWord('cart')
trie.addWord('call')
