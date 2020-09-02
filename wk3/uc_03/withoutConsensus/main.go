package main

import (
	"fmt"
)

func main() {
	//Dna := [...]string{
	//	"AGGCTA",
	//	"ACGTTA",
	//	"TCGCGA",
	//	"AAGCCA",
	//	"ACGCGA",
	//	"AGGTCA",
	//}
//
	//profile := map[byte][]float64{
	//	'A': {0.4, 0.3, 0.0, 0.1, 0.0, 0.9},
	//	'C': {0.2, 0.3, 0.0, 0.4, 0.0, 0.1},
	//	'G': {0.1, 0.3, 1.0, 0.1, 0.5, 0.0},
	//	'T': {0.3, 0.1, 0.0, 0.4, 0.5, 0.0},
	//}

	Dna := [...]string{
		"AAGTTC",
	}

	profile := map[byte][]float64{
		'A': {0.4, 0.3, 0.0, 0.1, 0.0, 0.9},
		'C': {0.2, 0.3, 0.0, 0.4, 0.0, 0.1},
		'G': {0.1, 0.3, 1.0, 0.1, 0.5, 0.0},
		'T': {0.3, 0.1, 0.0, 0.4, 0.5, 0.0},
	}

	for _, v := range Dna {
		fmt.Print(v, "-------------------")
		fmt.Println(motifProbab(v, profile))
	}

}
