
public class Calculator implements java.io.Serializable {
	private double operandUno;
	private double operandDos;
	private char operation;
	private double result;

	// Construction
	public Calculator() {
	}

	public Calculator(double num1, double num2, char operator) {
		this.operandUno = num1;
		this.operandDos = num2;
		this.operation = operator;
	}

	// getters and setters
	public double getOperandUno() {
		return operandUno;
	}

	public void setOperandUno(double num) {
		operandUno = num;
	}

	public double getOperandDos() {
		return operandDos;
	}

	public void setOperandDos(double num) {
		operandDos = num;
	}

	public char getOperation() {
		return operation;
	}

	public void setOperation(char operator) {
		operation = operator;
	}

	public double getResults() {
		return result;
	}

	public void setResults(double result) {
		this.result = result;
	}

	// Methodology
	public void performOperation() {
		// enter an operand save as result
		// read & set operation
		// enter another operand; result = performOperation.
		// read & set operation, if "=" then display result.
		// enter c to continue or q to quit

		String continuing = " ";
		boolean going = false;
		double operand1 = 0.0;
		double operand2 = 0.0;
		String selection = " ";
		while (!selection.equals("q")) {
			operand1 = 0.0;
			operand2 = 0.0;
			String operatorStr = "";
			continuing = " ";
			System.out.println("1vEnter an operand: ");
			String operandStr = System.console().readLine();
			operand1 = Double.parseDouble(operandStr);
			while (!continuing.equals("no")) {
				if (going == true) {
					operand1 = result;
					System.out.println("+, - or = : ");
					operatorStr = System.console().readLine();
					if (!operatorStr.equals("=")) {
						System.out.println("goingEnter an operand: ");
						operandStr = System.console().readLine();
						operand2 = Double.parseDouble(operandStr);
					}
				} else {
					if (!operatorStr.equals("=")) {
						System.out.println("+, - or = :  ");
						operatorStr = System.console().readLine();
						System.out.println("2vEnter an operand: ");
						operandStr = System.console().readLine();
						operand2 = Double.parseDouble(operandStr);
					}
				}
				if (operatorStr.equals("+")) {
					setResults(operand1 + operand2);
					going = true;
				} else if (operatorStr.equals("-")) {
					setResults(operand1 - operand2);
					going = true;
				} else if (operatorStr.equals("*")) {
					setResults(operand1 * operand2);
					going = true;
				} else if (operatorStr.equals("/")) {
					setResults(operand1 / operand2);
					going = true;
				} else if (operatorStr.equals("=")) {
					System.out.println("Result: " + getResults());
					going = false;
					break;
				} else if (!operatorStr.equals("/") || !operatorStr.equals("*") || !operatorStr.equals("-")
						|| !operatorStr.equals("+")) {
					System.out.println("Invalid operator...");
					continuing = "no";
				}
			}
			System.out.println("Enter any key to continue with another operation or 'q' to quit.");
			selection = System.console().readLine();
		}
	}

	public double performOperation(double num1, double num2, char operator) {
		if (operator == '+') {
			setResults(num1 + num2);
		} else if (operator == '-') {
			setResults(num1 - num2);
		} else if (operator == '*') {
			setResults(num1 * num2);
		} else if (operator == '/') {
			setResults(num1 / num2);
		} else {
			System.out.println("Invalid operator...");
		}

		System.out.println("Result is: " + result);
		return result;
	}

	public void thumbs() {
		System.out.println(
				"Welcome to the calculator thumbs interface.  Her you can give two numbers a type of operation and perform siad operation for a result.");
		System.out.print("Please enter any character other than 'q' to continue: ");
		String selection = System.console().readLine();

		while (!selection.equals("q")) {
			System.out.print("Enter a number to be your first operand: ");
			String num1 = System.console().readLine();
			operandUno = Double.parseDouble(num1);
			System.out.print("Enter a number to be your second operand: ");
			String num2 = System.console().readLine();
			operandDos = Double.parseDouble(num2);
			System.out.print("...and what operation would you like to perform? " + num1 + "__" + num2 + " : ");
			String operator = System.console().readLine();
			operation = operator.charAt(0);

			performOperation(operandUno, operandDos, operation);
			System.out.print("Enter any letter to continue or 'q' to exit the thumb interface.");
			selection = System.console().readLine();
		}
	}

}
