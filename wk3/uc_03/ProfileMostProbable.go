package main

//tort_04 algorithm is better

import (
	"math"
)

const (
	A byte = 'A'
	C byte = 'C'
	G byte = 'G'
	T byte = 'T'
)

var NUCLS [4]byte = [4]byte{A, C, G, T}

func ProfileMostProbable(seq string, profile map[byte][]float64, k int) string {
	var min int = math.MaxInt64
	var maxMotif string
	consensus := findConsensusSequence(profile, k)
	for i := 0; i <= len(seq)-k; i++ {
		motifi := seq[i : i+k]
		score := motifScore(motifi, consensus)
		if score < min {
			min = score
			maxMotif = motifi
			// fmt.Print("min score is ")
			// fmt.Println(score)
			// fmt.Print("motifi is ")
			// fmt.Println(maxMotif)
		}
	}

	return maxMotif
}

func motifScore(motif, consensus string) int {
	var score int

	for i, _ := range motif {
		if motif[i] != consensus[i] {
			score++
		}
	}

	return score
}

func findConsensusSequence(profile map[byte][]float64, k int) string {
	var consensus []byte = make([]byte, 0, k)
	max := 0.0
	var char byte
	for i := 0; i < k; i++ {
		max = 0
		char = 0
		for _, n := range NUCLS {
			if profile[n][i] > max {
				max = profile[n][i]
				char = n
			}
		}
		consensus = append(consensus, char)
	}

	return string(consensus)
}
