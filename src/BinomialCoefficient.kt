import kotlin.time.Duration
import kotlin.time.measureTime

fun factorial(n: Int): Int {
	var result: Int = 1
	for (i: Int in 2 .. n) {
		result *= i
	}
	return result
}

fun binomialCoefficient(n: Int, k: Int): Int {
	return factorial(n) / (factorial(n - k) * factorial(k))
}

fun binomialCoefficientDirect(n: Int, k: Int): Int {
	var result: Int = 1
	when {
		(2 * k >= n) -> {
			for (i: Int in k + 1 .. n) {
				result *= i
			}
			for (i: Int in 2 .. k - n) {
				result /= i
			}
		}

		else -> {
			for (i: Int in n - k + 1 .. n) {
				result *= i
			}
			for (i: Int in 2 .. n) {
				result /= i
			}
		}
	}
	return result
}

fun main() {
	val timeDirect: Duration = measureTime {
		println(binomialCoefficientDirect(16, 8))
	}
	println(timeDirect)
}