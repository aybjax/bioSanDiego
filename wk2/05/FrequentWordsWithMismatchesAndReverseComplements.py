# Place your FrequentWordsWithMismatchesAndReverseComplements() function here, along with any subroutines you need.
# Your function should return a list.
def FrequentWordsWithMismatchesAndReverseComplements(Text, k, d):
    frqPtn = set()
    neighborhood = []
    for i in range( len(Text) - k + 1 ):
        neigh = neighbors(Text[i: i + k], d)
        neigh = list(neigh)
        neighborhood += neigh
        neigh = neighbors( getReverse(Text[i: i + k]), d)
        neigh = list(neigh)
        neighborhood += neigh
    index = []
    count = []
    for i in range(len(neighborhood)):
        ptn = neighborhood[i]
        num = ptnToNum(ptn)
        index.append(num)
        count.append(1)
    index.sort()
    for i in range(len(neighborhood)-1):
        if index[i] == index[i+1]:
            count[i+1] = count[i]+1
    maxVal = max(count)
    
    for i in range(len(neighborhood)):
        if count[i] == maxVal:
            ptn = numToPtn(index[i], k)
            frqPtn.add(ptn)
    return frqPtn

def getReverse(ptn):
    rev = ""
    for i in range(len(ptn)):
        compl = complement(ptn[len(ptn) - i - 1])
        rev += compl
    return rev

def complement(char):
    if char == 'T':
        return 'A'
    if char == 'G':
        return 'C'
    if char == 'C':
        return 'G'
    if char == 'A':
        return 'T'

def neighbors(ptn, d):
    if d == 0:
        l = {ptn}
        return set(l)
    if len(ptn) == 1:
        return {'A', 'C', "T", "G"}
    neighborhood = set()
    suffNeigh = neighbors(ptn[1:], d)
    for str in suffNeigh:
        if HammingDistance(ptn[1:], str) < d:
             for nucl in {'A', 'C', "T", "G"}:
                 neighborhood.add(nucl + str)
        else:
             neighborhood.add(ptn[0] + str)
    return neighborhood

def HammingDistance(str1, str2):
    dist = 0
    for i in range(len(str1)):
        if str1[i] != str2[i]:
            dist += 1
    return dist

def numToPtn(num, k):
    if k == 1:
        return numSym(num)
    prefix = int(num/4)
    symNum = num % 4
    
    sym = numSym(symNum)
    prefix = numToPtn(prefix, k-1)
    
    return prefix + sym

def numSym(num):
    if num == 0:
        return 'A'
    if num == 1:
        return 'C'
    if num == 2:
        return 'G'
    if num == 3:
        return 'T'

def ptnToNum(ptn):
    if len(ptn) == 0:
        return 0;
    sym = ptn[-1]
    prefix = ptn[:-1]
    ret = 4*ptnToNum(prefix) + symNum(sym)
    
    return ret
    
def symNum(char):
    if char == 'A':
        return 0
    elif char == 'C':
        return 1
    elif char == 'G':
        return 2
    elif char == 'T':
        return 3