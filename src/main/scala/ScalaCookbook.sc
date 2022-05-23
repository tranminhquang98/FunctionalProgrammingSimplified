import java.io.{FileNotFoundException, IOException}
import scala.annotation.switch

// 2.1 Testing String Equality
val s1 = "Hello"
val s2 = "HeLLo"
s1 equalsIgnoreCase s2 //true
s1 == s2 //false
s2 == null //false

// 2.2 Creating Multiline Strings
val foo =
  """This is
    |a multiline
    |String""".stripMargin
//.replaceAll("\n", " ")
foo

// 2.3 Splitting Strings
val s = "eggs, milk, butter, Cocoa Puffs"
s.split(",").filter(!_.startsWith("e")).map(_.trim)

// 3.1 Parsing a Number from a String
"1".toInt

// 3.6 Handling Large Numbers
val bi = BigInt(1234567890)
val bd = BigDecimal(123456.789)
// BigDecimal is often used to represent currency because it offers
// control over rounding behavior.
0.1 + 0.2
BigDecimal(0.1) + BigDecimal(0.2)

// 4.6 Using a Match Expression Like a switch Statement
val day = (5: @switch) match {
  case 0 => "Sunday"
  case 1 => "Monday"
  case 2 => "Tuesday"
  case 3 => "Wednesday"
  case 4 => "Thursday"
  case 5 => "Friday"
  case 6 => "Saturday"
  case _ => "invalid day"
}
day
/*
• The matched value must be a known integer.
• The matched expression must be “simple.” It can’t contain any type checks, if
statements, or extractors.
• The expression must have its value available at compile time.
• There should be more than two case statements.
 */

// 4.7 Matching Multiple Conditions with One Case Statement
/*
Place the match conditions that invoke the same business logic on one line, separated
by the | (pipe) character:
*/

5 match {
  case 1 | 3 | 5 | 7 | 9 => println("odd")
  case 2 | 4 | 6 | 8 | 10 => println("even")
  case _ => println("too big")
}

// 4.15 Matching One or More Exceptions with try/catch
try
  1 + 1
catch {
  case _: FileNotFoundException | IOException =>
    println(s"Had an IOException trying to read")
}

