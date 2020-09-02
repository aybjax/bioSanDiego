package main

import (
	"fmt"
	"math"
)

func RepeatGibbsRandomizedMotifSearch(Dna []string, k, t, N int) []string {
	var bestScore int = math.MaxInt64
	var bestMotif []string

	for i := 0; i < 50; i++ {
		score, motif := GibbsRandomizedMotifSearch(Dna, k, t, N)
		if score < bestScore {
			bestScore = score
			bestMotif = motif
			fmt.Println("Score is ", bestScore, ": ", bestMotif)
		}
	}
	return bestMotif
}
