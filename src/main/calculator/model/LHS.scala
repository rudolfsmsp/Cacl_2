package calculator.model

class LHS(calc: Calculator) extends State(calc) {

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
    calc.lhs += number.toString
    calc.display = calc.lhs.toDouble
  }

  override def dividePressed(): Unit = {
    calc.action = (lhs: Double, rhs: Double) => lhs/rhs
    calc.state = new Action_Main(calc)
  }

  override def multiplyPressed(): Unit = {
    calc.action = (lhs: Double, rhs: Double) => lhs*rhs
    calc.state = new Action_Main(calc)
  }

  override def subtractPressed(): Unit = {
    calc.action = (lhs: Double, rhs: Double) => lhs-rhs
    calc.state = new Action_Main(calc)
  }

  override def addPressed(): Unit = {
    calc.action = (lhs: Double, rhs: Double) => lhs+rhs
    calc.state = new Action_Main(calc)
  }

  override def equalsPressed(): Unit = {
    calc.state = new LHS(calc)
  }

  override def decimalPressed(): Unit = {
    calc.lhs += "."
    calc.state = new LHS_Decimal(calc)
  }

}
