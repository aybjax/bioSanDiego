package main

func RandomizedMotifSearch(Dna []string, k, t int) []string {
	bestMotifs := []string{
		"CCA",

		"CCT",

		"CTT",

		"TTG",
	}
	bestScore := MatrixScore(bestMotifs, k, t)
	profile := ProfileLaplaceGenerator(bestMotifs, k, t)
	motifs := MotifsFromProfile(Dna, profile, k)
	score := MatrixScore(motifs, k, t)
	if score < bestScore {
		bestScore = score
		bestMotifs = motifs
	}
	return bestMotifs

}
