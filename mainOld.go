package main

import (
	"fmt"
	"io/ioutil"
	"os"
	"strconv"
	"strings"
)

func main() {
	//get input data

	var inputFile string
	if len(os.Args) < 2 {
		fmt.Println("Error!\n\tUsage: program inputFileName")
		return
	} else {
		inputFile = os.Args[1]
	}

	dataByte, err := ioutil.ReadFile(inputFile)
	errMsg(err)
	data := strings.Fields(string(dataByte))

	fmt.Println(data)
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

	fmt.Println("Dna is ", Dna)
	fmt.Println("k is ", k)
	fmt.Println("t is ", t)

	fmt.Println("-----------------------------")
	//actual calculation
	ans := RepeatRandomizedMotifSearch(Dna, k, t)

	fmt.Println("Answer is ", ans)

	//write data to file
	output := strings.Join(ans, "\n")

	ioutil.WriteFile("output.txt", []byte(output), 0666)
}

func errMsg(err error) {
	if err != nil {
		fmt.Println("Error:\n\t", err)
		os.Exit(1)
	}
}
