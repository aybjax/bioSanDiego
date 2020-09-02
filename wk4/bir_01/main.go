package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	//get input data

	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()
	dataString := scanner.Text()
	data := strings.Fields(string(dataString))
	///////////////////////////////////////////
	k64, err := strconv.ParseInt(data[0], 10, 64)
	errMsg(err)
	k := int(k64)
	t64, err := strconv.ParseInt(data[1], 10, 64)
	errMsg(err)
	t := int(t64)

	////////////////////////////////////////////
	Dna := make([]string, 0, t)

	for scanner.Scan() {
		dataString = scanner.Text()
		Dna = append(Dna, dataString)
	}

	fmt.Println("Dna is ", Dna)
	fmt.Println("k is ", k)
	fmt.Println("t is ", t)
	/*
			fmt.Println("-----------------------------")
		//actual calculation
		ans := RepeatRandomizedMotifSearch(Dna, k, t)

		//write data to file
		output := strings.Join(ans, "\n")

		fmt.Println(output)*/
}

func errMsg(err error) {
	if err != nil {
		fmt.Println("Error:\n\t", err)
		os.Exit(1)
	}
}
