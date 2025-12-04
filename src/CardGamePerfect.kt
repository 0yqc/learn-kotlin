fun kgv(vararg nums: Int): Int { // kgV is german for Kleinstes gemeinsames Vielfaches (Least common multiple)
	val max_num = nums.maxOrNull() ?: error("no numbers")
	var max_kgv = 1
	for (num: Int in nums) {
		max_kgv *= num
	}
	for (currentKgv: Int in max_num .. max_kgv step max_num) {
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
	println(kgv(2, 6))
}