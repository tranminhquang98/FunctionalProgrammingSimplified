def multipleFIP[A, B, C]: ((A, B) => C, (A, B) => C, A, B) => (C, C) =
  (f1, f2, n1, n2) => (f1(n1, n2), f2(n1, n2))

def mul2Num: (Int, Int) => Int = _ * _

def add2Num: (Int, Int) => Int = _ + _

val q = Person(10, "Quang")

multipleFIP(add2Num, mul2Num, 4, 4)

case class Person(age: Int, name: String)

def multiplyBy: Int => Int => Int = a => b => a * b

val multiplyBy10: Int => Int = multiplyBy(10)(_)

println(q.age)
val list = 1 :: 2 :: 3 :: Nil

println(multiplyBy10(5))

