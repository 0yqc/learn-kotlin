fun checkPrime(n: Int, primes: List<Int>): Boolean {
	for (i: Int in primes) {
		if (i * i > n) {
			break
		}
		if (n % i == 0) {
			return false
		}
	}
	return true
}

fun printPrimeNums(start: Int = 2, stop: Int = Int.MAX_VALUE) {
	val primes: MutableList<Int> = mutableListOf<Int>()
	for (i: Int in maxOf(start, 2) .. stop) {
		if (checkPrime(i, primes)) {
			println(i)
			primes.add(i)
		}
	}
}

fun main() {
	print("Start Value: ")
	val start: Int = readln().toIntOrNull() ?: 2
	print("End value: ")
	val stop: Int = readln().toIntOrNull() ?: Int.MAX_VALUE
	printPrimeNums(start, stop)
}