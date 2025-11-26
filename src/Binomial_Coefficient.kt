fun factorial(n: Int): Int {
	var result = 1
	var i = n // n is not changeable
	while (i > 0) {
		result *= i
		i--
	}
	return result
}

fun binomial_coefficient(n: Int, k: Int): Int {
	return factorial(n) / (factorial(n - k) * factorial(k))
}

fun main() {
	println(binomial_coefficient(4, 3))
}