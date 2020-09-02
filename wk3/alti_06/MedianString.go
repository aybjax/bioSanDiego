package main

import (
	"fmt"
	"math"
)

func MedianString(Dna []string, k int) string {
	var median string
	distance := math.MaxInt64
	end := math.Pow(4.0, float64(k))
	endInt := int(end)

	for i := 0; i < endInt-1; i++ {
		ptn := NumToPtn(i, k)
		tmpDst := DistanceBtwPtn_Strings(Dna, ptn)
		if tmpDst == distance {
			fmt.Println("now is ", tmpDst, "dist is ", distance)
			fmt.Println(ptn)
		}
		if tmpDst < distance {
			fmt.Println("now is ", tmpDst, "dist is ", distance)
			distance = tmpDst
			median = ptn
			fmt.Println(ptn)
		}
	}

	return median
}
