package main

func HammingDistance(ptn1, ptn2 string) int {
	if len(ptn1) != len(ptn2) {
		return -1
	}
	var distance int

	for i, _ := range ptn1 {
		if ptn1[i] != ptn2[i] {
			distance++
		}
	}

	return distance
}
