val q = Person(10, "Quang")

def multipleFIP[A, B, C]: ((A, B) => C, (A, B) => C, A, B) => (C, C) =
  (f1, f2, n1, n2) => (f1(n1, n2), f2(n1, n2))

def add2Num: (Int, Int) => Int = _ + _

multipleFIP(add2Num, mul2Num, 4, 4)

def mul2Num: (Int, Int) => Int = _ * _

case class Person(age: Int, name: String)

println(q.age)
