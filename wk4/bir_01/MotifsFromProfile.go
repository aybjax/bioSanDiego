package main

func MotifsFromProfile(Dna []string, profile map[byte][]float64, k int) []string {
	t := len(Dna)
	motifs := make([]string, 0, t)

	for _, seq := range Dna {
		motifi := ProfileMostProbableString(seq, profile, k)
		motifs = append(motifs, motifi)
	}

	return motifs
}
