import kotlin.math.pow
import kotlin.math.sqrt

class Rectangle(var a: Double = 0.0, var b: Double = 0.0) {
	val area: Double get() = a * b

	fun diagonal(): Double {
		return sqrt(a.pow(2) + b.pow(2))
	}

	fun circumference(): Double {
		return 2 * (a + b)
	}
}

fun main() {
	val rec1 = Rectangle(5.0, 7.0)
	println("Circumference: ${rec1.circumference()}")
	println("Area: ${rec1.area}")
	rec1.a = 10.0
	println("New Area: ${rec1.area}")
}