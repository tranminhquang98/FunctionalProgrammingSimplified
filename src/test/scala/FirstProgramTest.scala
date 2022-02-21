import org.scalatest.FunSuite

/**
 * Created by QuangTM on 12-Feb-2022.
 */
class FirstProgramTest extends FunSuite {
  test("FirstProgram.double") {
    assert(FirstProgram.double(2) == 4)
  }

  test("FirstProgram.factorial") {
    assert(FirstProgram.factorial(4, 1) == 24)
  }

  test("FirstProgram.isEven") {
    assert(!FirstProgram.isEven(3))
  }

  test("FunctionsAreVariables.function") {
    assert(FunctionsAreVariables.function("2x")(5) == 10)
  }
}
