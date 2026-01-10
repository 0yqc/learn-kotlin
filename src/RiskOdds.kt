fun main() {
	var result: Double = 0.0
	var attackerWin: Int = 0
	var defenderWin: Int = 0
	var tied: Int = 0

	for (aToss1: Int in 1 .. 6) {
		for (aToss2: Int in 1 .. 6) {
			for (aToss3: Int in 1 .. 6) {
				for (dToss1: Int in 1 .. 6) {
					for (dToss2: Int in 1 .. 6) {
						val aTossH: Int
						val aTossS: Int
						when {
							aToss1 >= aToss2 && aToss1 >= aToss3 -> {
								aTossH = aToss1
								aTossS = maxOf(aToss2, aToss3)
							}
							aToss2 >= aToss1 && aToss2 >= aToss3 -> {
								aTossH = aToss2
								aTossS = maxOf(aToss1, aToss3)

							}
							else -> {
								aTossH = aToss3
								aTossS = maxOf(aToss1, aToss2)

							}
						}
						val dTossH: Int = maxOf(dToss1, dToss2)
						val dTossS: Int = minOf(dToss1, dToss2)

						when {
							aTossH > dTossH && aTossS > dTossS -> {
								result += 2.0 / (6 * 6 * 6 * 6 * 6).toDouble()
								attackerWin++
							}
							dTossH > aTossH && dTossS > aTossS -> {
								result -= 2.0 / (6 * 6 * 6 * 6 * 6).toDouble()
								defenderWin++
							}
							else -> {
								tied++
							}
						}
					}
				}
			}
		}
	}
	println("""
		Result: $result
		Attacker Win: $attackerWin (${attackerWin.toDouble() / (6 * 6 * 6 * 6 * 6).toDouble() * 100}%)
		Defender Win: $defenderWin (${defenderWin.toDouble() / (6 * 6 * 6 * 6 * 6).toDouble() * 100}%)
		Tie: $tied (${tied.toDouble() / (6 * 6 * 6 * 6 * 6).toDouble() * 100}%)
	""".trimIndent())
}