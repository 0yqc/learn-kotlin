fun checkPrime(n: Int): Boolean {
	for (i in 2 ..< n) {
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
	for (i in (if (start > 1) start else 2) .. stop) {
		if (checkPrime(i)) {
			println(i)
		}
	}
}

fun main() {
	print("Start Value: ")
	val start = readln().toInt()
	print("End value: ")
	val stop = readln().toInt()
	printPrimeNums(start, stop)
}