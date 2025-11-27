fun factorial(n: Int): Int {
	var result = 1
	for (i in 2 .. n) {
		result += i
	}
	return result
}

fun binomialCoefficient(n: Int, k: Int): Int {
	return factorial(n) / (factorial(n - k) * factorial(k))
}

fun main() {
	println(factorial(1))
	println(binomialCoefficient(4, 3))
}