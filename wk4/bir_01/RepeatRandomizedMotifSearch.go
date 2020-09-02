package main

import (
	"math"
)

func RepeatRandomizedMotifSearch(Dna []string, k, t int) []string {
	var bestScore int = math.MaxInt64
	var bestMotif []string

	for i := 0; i < 1000; i++ {
		score, motif := RandomizedMotifSearch(Dna, k, t)
		if score < bestScore {
			bestScore = score
			bestMotif = motif
			//fmt.Println("Score is ", bestScore, ": ", bestMotif)
		}
	}

	return bestMotif
}
