fun nDivisors(n: Int): Int {
	when (n) {
		0 -> return 0
		1 -> return 1
	}
	var divisors = 2 // 1 and itself
	for (i in 2 .. n / 2) {
		if (n % i == 0) {
			divisors += 1
		}
	}
	return divisors
}

fun main() {
	print("Start value: ")
	val start: Int = readln().toIntOrNull() ?: 0
	print("End value: ")
	val stop: Int = readln().toIntOrNull() ?: Int.MAX_VALUE
	var max = 0
	for (i in start .. stop) {
		val current = nDivisors(i)
		if (current > max) {
			max = current
			println("New perfect number: $i with $current divisors.")
		}
	}
}