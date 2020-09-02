package main

import (
	"math/rand"
	"time"
)

//create matrix from first k-mers
func InitRandomMotifs(Dna []string, k, t int) []string {
	firstMotifs := make([]string, 0, t)

	for _, v := range Dna {
		rand.Seed(time.Now().UnixNano())
		i := rand.Intn(len(v) - k + 1)
		motif := v[i : i+k]
		firstMotifs = append(firstMotifs, motif)
	}

	return firstMotifs
}
