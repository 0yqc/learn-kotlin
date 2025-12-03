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

fun printPrimeNums(stop: Int = Int.MAX_VALUE) {
	val primes: MutableList<Int> = mutableListOf<Int>()
	for (i: Int in 2 .. stop) {
		if (checkPrime(i, primes)) {
			println(i)
			primes.add(i)
		}
	}
}

fun printPrimePairs(stop: Int = Int.MAX_VALUE) {
	val primes: MutableList<Int> = mutableListOf<Int>()
	for (i: Int in 2 .. stop) {
		if (checkPrime(i, primes)) {
			primes.add(i)
		}
		if (i in primes && i - 2 in primes) {
			println("($i, ${i - 2})")
		}
	}
}

fun main() {
	print("End value: ")
	val stop: Int = readln().toIntOrNull() ?: Int.MAX_VALUE
	print("Pairs/Nums? ")
	if (readln().lowercase().startsWith("n")) {
		printPrimeNums(stop)
	} else {
		printPrimePairs(stop)
	}
}