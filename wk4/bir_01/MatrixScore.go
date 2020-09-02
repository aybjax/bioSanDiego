package main

func MatrixScore(matrix []string, k, t int) int {
	profile := ProfileLaplaceGenerator(matrix, k, t)
	consensus := FindConsensusSequence(profile, k)
	//fmt.Println("\tConsensus is ", consensus)
	var matrixScore int

	for _, motif := range matrix {
		matrixScore += motifScore(motif, consensus)
	}

	return matrixScore
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
