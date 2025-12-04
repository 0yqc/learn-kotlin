fun kgv(vararg nums: Int): Int { // kgV is german for Kleinstes gemeinsames Vielfaches (Least common multiple)
	val max_num = nums.maxOrNull() ?: error("no numbers")
	for (currentKgv: Int in max_num .. Int.MAX_VALUE step max_num) {
		var possible = true
		for (num: Int in nums) {
			if (currentKgv % num != 0) {
				possible = false
			}
		}
		if (possible) {
			return currentKgv
		}
	}
	error("invalid numbers")
}

fun main() {
	for (i in 2..10) {
		println("up to $i players: ${kgv(*(2 .. i).toList().toIntArray())}")
	}
}