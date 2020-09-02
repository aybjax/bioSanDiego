package main

import (
	"math/rand"
	"time"
)

func ProfileWtdRandonString(seq string, profile map[byte][]float64, k int) string {
	probDist := make([]float64, 0)
	motifs := make([]string, 0)
	var sum float64
	for i := 0; i <= len(seq)-k; i++ {
		motifi := seq[i : i+k]
		prob := MotifProbab(motifi, profile)
		probDist = append(probDist, prob)
		motifs = append(motifs, motifi)
		sum += prob
	}
	// [0; 1)
	rand.Seed(time.Now().UnixNano())
	randFl := rand.Float64()
	// fmt.Println(randFl)
	//get random number in dist of probDist
	randFl *= sum
	sum = 0
	for i := 0; i < len(probDist); i++ {
		sum += probDist[i]
		if randFl < sum {
			// fmt.Println(probDist)
			// fmt.Println("\t", randFl, "sum is", sum, "chosen is", i, "of", len(probDist))
			// fmt.Println("\t", motifs[i])

			return motifs[i]
		}
	}
	return motifs[len(motifs)-1]
}
