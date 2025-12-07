import kotlin.math.pow
import kotlin.math.sqrt

class Rectangle(var a: Double = 0.0, var b: Double = 0.0) {
	fun area(): Double {
		return a * b
	}

	fun diagonal(): Double {
		return sqrt(a.pow(2) + b.pow(2))
	}

	fun circumference(): Double {
		return 2 * (a + b)
	}
}

fun main() {
	val rec1 = Rectangle(5.0, 7.0)
	println(rec1.circumference())
}