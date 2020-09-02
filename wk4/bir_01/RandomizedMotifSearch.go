package main

func RandomizedMotifSearch(Dna []string, k, t int) (bestScore int, bestMotifs []string) {
	bestMotifs = InitRandomMotifs(Dna, k, t)
	bestScore = MatrixScore(bestMotifs, k, t)
	for {
		profile := ProfileLaplaceGenerator(bestMotifs, k, t)
		motifs := MotifsFromProfile(Dna, profile, k)
		score := MatrixScore(motifs, k, t)
		if score < bestScore {
			bestScore = score
			bestMotifs = motifs
		} else {
			return
		}
	}
}
