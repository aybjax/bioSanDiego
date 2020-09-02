package main

var (
	numSymb map[int]string = map[int]string{
		0: "A",
		1: "C",
		2: "G",
		3: "T",
	}
)

func NumToPtn(num, k int) string {
	if k == 1 {
		return numToSym(num)
	}
	prefix := num / 4
	suffix := num % 4
	symbol := numToSym(suffix)
	prefixPtn := NumToPtn(prefix, k-1)

	return prefixPtn + symbol
}

func numToSym(num int) string {
	return numSymb[num]
}
