package main

import "math"

func DistanceBtwPtn_Strings(matrix []string, ptn string) int {
	k := len(ptn)
	strLen := len(matrix[0])
	hammingDistance := 0

	for _, seq := range matrix {
		dist := math.MaxInt64
		for i := 0; i <= strLen-k; i++ {
			str := seq[i : i+k]
			tmp := HammingDistance(ptn, str)
			if tmp < dist {
				dist = tmp
			}
		}
		hammingDistance += dist
	}
	return hammingDistance
}
