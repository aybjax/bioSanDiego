package main

import "fmt"

func GreedyMotifSearchWLaPlace(Dna []string, k, t int) []string {
	var bestMotifs []string = initBestMotif(Dna, k, t)
	firstSeq := Dna[0]

	for i := 0; i <= len(firstSeq)-k; i++ {
		motif0 := firstSeq[i : i+k]
		motifs := make([]string, 0, t)
		motifs = append(motifs, motif0)
		for j := 1; j < t; j++ {
			profile := ProfileLaplaceGenerator(motifs, k, j)
			motifi := ProfileMostProbable(Dna[j], profile, k)
			motifs = append(motifs, motifi)
		}

		if matrixScore(motifs) < matrixScore(bestMotifs) { //or if matrixScore(motifs) <= matrixScore(bestMotifs) {
			bestMotifs = append([]string(nil), motifs...)
			fmt.Println(matrixScore(bestMotifs))
			fmt.Println(bestMotifs)
		}
	}

	return bestMotifs
}

//create matrix from first k-mers
func initBestMotif(Dna []string, k, t int) []string {
	firstMotifs := make([]string, 0, t)

	for _, v := range Dna {
		firstMotifs = append(firstMotifs, v[:k])
	}

	return firstMotifs
}
