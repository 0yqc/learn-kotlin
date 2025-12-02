fun guess(min: Int, max: Int): Pair<Int, Int> {
	val n: Int = min / 2 + max / 2
	print("$n (</=/>): ")
	when (readln()) {
		"<" -> {
			return Pair(min, n - 1)
		}
		">" -> {
			return Pair(n + 1, max)
		}
		"=" -> {
			return Pair(n, n)
		}
		else -> {
			return Pair(min, max)
		}
	}
}

fun main() {
	print("Minimum: ")
	var min: Int = readln().toIntOrNull() ?: Int.MIN_VALUE
	print("Maximum: ")
	var max: Int = readln().toIntOrNull() ?: Int.MAX_VALUE
	while (true) {
		val res: Pair<Int, Int> = guess(min, max)
		min = res.first
		max = res.second
		if (min == max) {
			break
		}
	}
}