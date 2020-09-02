package main

import (
	"math/rand"
	"time"
)

func GibbsRandomizedMotifSearch(Dna []string, k, t, N int) (bestScore int, bestMotifs []string) {
	motifs := InitRandomMotifs(Dna, k, t)
	bestMotifs = motifs
	bestScore = MatrixScore(bestMotifs, k, t)
	lastSelected := -1
	for i := 0; i < N; i++ {

		rand.Seed(time.Now().UnixNano())
		removeInd := rand.Intn(t)
		for lastSelected == removeInd {
			removeInd = rand.Intn(t)
		}
		lastSelected = removeInd
		LessMotif, motifi := removeMotif(motifs, t, removeInd)
		profile := ProfileLaplaceGenerator(LessMotif, k, t-1)
		motifi = ProfileWtdRandonString(Dna[removeInd], profile, k)
		motifs = addMotif(LessMotif, motifi, t, removeInd)
		score := MatrixScore(motifs, k, t)
		// fmt.Println(motifs)
		// fmt.Println(score)
		if score < bestScore {
			bestScore = score
			bestMotifs = motifs
			// fmt.Println("\t", score)
		}
	}
	return
}

func removeMotif(Dna []string, t, ind int) (LessMotif []string, motifi string) {
	LessMotif = make([]string, 0, t-1)
	for i, v := range Dna {
		if i == ind {
			motifi = v
			continue
		}
		LessMotif = append(LessMotif, v)
	}
	return
}

func addMotif(Dna []string, motif string, t, ind int) (motifs []string) {
	motifs = make([]string, 0, t)

	for i, counter := 0, 0; i < t; i++ {
		if i == ind {
			motifs = append(motifs, motif)
		} else {
			motifs = append(motifs, Dna[counter])
			counter++
		}
	}

	return
}
