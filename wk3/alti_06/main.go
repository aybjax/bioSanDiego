package main

import "fmt"

func main() {
	Dna := []string{
		"CTCGATGAGTAGGAAAGTAGTTTCACTGGGCGAACCACCCCGGCGCTAATCCTAGTGCCC",
		"GCAATCCTACCCGAGGCCACATATCAGTAGGAACTAGAACCACCACGGGTGGCTAGTTTC",
		"GGTGTTGAACCACGGGGTTAGTTTCATCTATTGTAGGAATCGGCTTCAAATCCTACACAG",
	}

	ptns := []string{
		"CGTGTAA",
		"TAGTTTC",
		"GATGAGT",
		"ATAACGG",
		"GTAGGAA",
		"TCTGAAG",
	}

	fmt.Print("finding median string:\n\t")

	fmt.Println(MedianString(Dna, 7))

	fmt.Print("given value:")

	for _, v := range ptns {
		fmt.Print(v, "---------------")
		fmt.Println(DistanceBtwPtn_Strings(Dna, v))
	}
}
