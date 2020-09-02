package main

import (
	"fmt"
)

func main() {
	ptn := "AAA"

	Dna := [...]string{
		"TTACCTTAAC", "GATATCTGTC", "ACGGCGTTCG", "CCCTAAAGAG", "CGTCAGAGGT",
	}

	answer := DistanceBtwPtn_Strings(Dna[:], ptn)

	fmt.Println("answer is :", answer)
}
