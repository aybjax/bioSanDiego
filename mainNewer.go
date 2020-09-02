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
	reader := bufio.NewReader(os.Stdin)
	dataString, err := reader.ReadString('\n')
	errMsg(err)
	data := strings.Fields(string(dataString))

	//fmt.Println(data)
	k64, err := strconv.ParseInt(data[0], 10, 64)
	errMsg(err)
	k := int(k64)
	t64, err := strconv.ParseInt(data[1], 10, 64)
	errMsg(err)
	t := int(t64)
	Dna := make([]string, 0, t)

	for i := 2; i < len(data); i++ {
		Dna = append(Dna, data[i])
	}
	/*
		fmt.Println("Dna is ", Dna)
		fmt.Println("k is ", k)
		fmt.Println("t is ", t)

		fmt.Println("-----------------------------")*/
	//actual calculation
	ans := RepeatRandomizedMotifSearch(Dna, k, t)

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
