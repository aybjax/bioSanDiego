package main

// func ProfileMostProbable(seq string, profile map[byte][]float64, k int) string {
// 	var max float64 = math.MinInt64
// 	var maxMotif string
// 	for i := 0; i <= len(seq)-k; i++ {
// 		motifi := seq[i : i+k]
// 		prob := motifProbab(motifi, profile)
// 		if prob > max {
// 			max = prob
// 			maxMotif = motifi
// 			// fmt.Print("min score is ")
// 			// fmt.Println(score)
// 			// fmt.Print("motifi is ")
// 			// fmt.Println(maxMotif)
// 		}
// 	}
// 	return maxMotif
// }

func motifProbab(motif string, profile map[byte][]float64) float64 {
	var prob float64 = 1

	for i, v := range motif {
		n := byte(v)
		prob *= profile[n][i]
	}

	return prob
}
