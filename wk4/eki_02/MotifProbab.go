package main

func MotifProbab(motif string, profile map[byte][]float64) float64 {
	var prob float64 = 1

	for i, v := range motif {
		n := byte(v)
		prob *= profile[n][i]
	}

	return prob
}
