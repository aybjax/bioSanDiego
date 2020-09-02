package main

import (
	"fmt"
	"os"
	"strings"
)

func main() {
	//get input data

	k := 3
	t := 4

	////////////////////////////////////////////
	Dna := []string{
		"AAGCCAAA",
		"AATCCTGG",
		"GCTACTTG",
		"ATGTTTTG",
	}

	ans := RandomizedMotifSearch(Dna, k, t)

	//write data to file
	output := strings.Join(ans, "\n")

	fmt.Println(output)
}

func errMsg(err error) {
	if err != nil {
		fmt.Println("Error:\n\t", err)
		os.Exit(1)
	}
}
