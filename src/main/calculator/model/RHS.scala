package calculator.model

class RHS(calc: Calculator) extends State(calc) {

  override def displayNumber(): Double = {
    calc.display
  }

  override def clearPressed(): Unit = {
    calc.display = 0.0
    calc.lhs = "0"
    calc.rhs = "0"
    calc.state = new LHS(calc)
  }

  override def numberPressed(number: Int): Unit = {
    calc.rhs += number.toString
    calc.display = calc.rhs.toDouble
  }

  override def dividePressed(): Unit = {
    calc.lhs = calc.operation(calc.lhs.toDouble, calc.rhs.toDouble).toString
    calc.action = (lhs: Double, rhs: Double) => lhs/rhs
    calc.rhs = "0"
    calc.state = new Action_Main(calc)
  }

  override def multiplyPressed(): Unit = {
    calc.lhs = calc.action(calc.lhs.toDouble, calc.rhs.toDouble).toString
    calc.action = (lhs: Double, rhs: Double) => lhs*rhs
    calc.state = new Action_Main(calc)
    calc.rhs = "0"

  }

  override def subtractPressed(): Unit = {
    calc.lhs = calc.action(calc.lhs.toDouble, calc.rhs.toDouble).toString
    calc.action = (lhs: Double, rhs: Double) => lhs-rhs
    calc.state = new Action_Main(calc)
    calc.rhs = "0"

  }

  override def addPressed(): Unit = {
    calc.lhs = calc.action(calc.lhs.toDouble, calc.rhs.toDouble).toString
    calc.action = (lhs: Double, rhs: Double) => lhs+rhs
    calc.rhs = "0"
    calc.state = new Action_Main(calc)

  }

  override def equalsPressed(): Unit = {
    calc.lhs = calc.action(calc.lhs.toDouble, calc.rhs.toDouble).toString
    calc.display = calc.lhs.toDouble
    calc.rhs = "0"
    calc.state = new LHS_Decimal(calc)
  }

  override def decimalPressed(): Unit = {
    calc.rhs += "."
    calc.state = new RHS_Decimal(calc)
  }


}