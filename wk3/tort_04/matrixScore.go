package main

func matrixScore(matrix []string) int {
	t := len(matrix)
	k := len(matrix[0])
	profile := ProfileLaplaceGenerator(matrix, k, t)
	consensus := findConsensusSequence(profile, k)
	//fmt.Println("\tConsensus is ", consensus)
	var matrixScore int

	for _, motif := range matrix {
		matrixScore += motifScore(motif, consensus)
	}

	return matrixScore
}
