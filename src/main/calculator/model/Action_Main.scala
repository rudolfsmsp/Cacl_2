package calculator.model

  class Action_Main(calc: Calculator) extends State(calc) {

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
      calc.rhs = number.toString
      calc.display = calc.rhs.toDouble
      calc.state = new RHS(calc)

    }

    override def dividePressed(): Unit = {
      calc.action = (lhs: Double, rhs: Double) => lhs / rhs

    }

    override def multiplyPressed(): Unit = {
      calc.action = (lhs: Double, rhs: Double) => lhs * rhs

    }

    override def subtractPressed(): Unit = {
      calc.action = (lhs: Double, rhs: Double) => lhs - rhs

    }

    override def addPressed(): Unit = {
      calc.action = (lhs: Double, rhs: Double) => lhs + rhs

    }

    override def equalsPressed(): Unit = {
      calc.state = new LHS(calc)

    }

    override def decimalPressed(): Unit = {
      calc.rhs += "."
      calc.state = new RHS(calc)

    }

}
