package main

	func FindConsensusSequence(profile map[byte][]float64, k int) string {
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
