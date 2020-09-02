package main

import (
	"fmt"
)

func main() {
	Dna := [...]string{
		"GGCGTTCAGGCA",
		"AAGAATCAGTCA",
		"CAAGGAGTTCGC",
		"CACGTCAATCAC",
		"CAATAATATTCG",
	}

	k := 3
	t := 5

	correct := []string{
		"CAG",
		"CAG",
		"CAA",
		"CAA",
		"CAA",
	}

	answer := GreedyMotifSearchWLaPlace(Dna[:], k, t)

	fmt.Println("correct is :", correct)
	fmt.Println(" answer is :", answer)

	fmt.Print("\n\n############################################################\n\n")

	k = 3
	t = 5
	Dna = [...]string{
		"GGCGTTCAGGCA",
		"AAGAATCAGTCA",
		"CAAGGAGTTCGC",
		"CACGTCAATCAC",
		"CAATAATATTCG",
	}

	correct = []string{
		"TTC",
		"ATC",
		"TTC",
		"ATC",
		"TTC",
	}

	answer = GreedyMotifSearchWLaPlace(Dna[:], k, t)

	fmt.Println("correct is :", correct)
	fmt.Println(" answer is :", answer)

}
