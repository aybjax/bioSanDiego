package main

import (
	"fmt"
)

func main() {
	Dna := "ACCTGTTTATTGCCTAAGTTCCGAACAAACCCAATATAGCCCGAGGGCCT"
	k := 5
	profile := map[byte][]float64{
		'A': {0.2, 0.2, 0.3, 0.2, 0.3},
		'C': {0.4, 0.3, 0.1, 0.5, 0.1},
		'G': {0.3, 0.3, 0.5, 0.2, 0.4},
		'T': {0.1, 0.2, 0.1, 0.1, 0.2},
	}

	fmt.Println(ProfileMostProbable(Dna, profile, k))
}
