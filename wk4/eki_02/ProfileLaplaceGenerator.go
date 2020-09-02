package main

const (
	A byte = 'A'
	C byte = 'C'
	G byte = 'G'
	T byte = 'T'
)

var NUCLS [4]byte = [4]byte{A, C, G, T}

func ProfileLaplaceGenerator(motifs []string, k, t int) map[byte][]float64 {
	//key NUCL, val => slice of float
	profile := make(map[byte][]float64)

	//initialize slice
	for _, n := range NUCLS {
		profile[n] = make([]float64, 0, k)
		for i := 0; i < k; i++ {
			profile[n] = append(profile[n], 1)
		}
	}
	//fmt.Println("profile")
	//fmt.Println(profile)

	//make profile
	for row := 0; row < t; row++ {
		for col := 0; col < k; col++ {
			// fmt.Println(row, col)
			switch motifs[row][col] {
			case A:
				profile[A][col] = profile[A][col] + 1
			case C:
				profile[C][col] = profile[C][col] + 1
			case G:
				profile[G][col] = profile[G][col] + 1
			case T:
				profile[T][col] = profile[T][col] + 1
			}
		}
	}
	// fmt.Println("-------------------")
	// fmt.Println("profile before")
	// fmt.Println(profile)

	//make percentage
	for col := 0; col < k; col++ {
		for _, v := range NUCLS {
			//4 bc we added one
			profile[v][col] = profile[v][col] / float64(4+t)
		}
	}

	return profile
}
