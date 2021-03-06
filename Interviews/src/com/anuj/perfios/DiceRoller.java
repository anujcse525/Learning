package com.anuj.perfios;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiceRoller {

	private static final String ERROR_MESSAGE = "Input is not in correct format";
	private static final String REGEX = "^\\d+D(4|6|8|10|12|20)$";
	private static List<String> operands = new LinkedList<String>();
	private static List<String> operators = new LinkedList<String>();
	private static Stack<Integer> randomNums = new Stack<Integer>();

	public static void main(String[] args) {

		if (args.length < 3) {
			throw new DiceNotValidException(
					"Usage DiceRoller <NumberOfDice>D<NumberOfSides> <Mathematical operator +/-> <NumberOfDice>D<NumberOfSides>");
		}
		// Create operator and operand list from input and save in separate
		// lists
		createOperandOperatorList(args);

		// Generate random numbers for operands and save in a stack
		generateRandomNumbers();

		// Perform mathematical operations
		int result = evaluateDiceInputs();
		System.out.println("Result is " + result);

	}

	private static int evaluateDiceInputs() throws DiceNotValidException {
		for (String operator : operators) {
			int operand1 = randomNums.pop();
			int operand2 = randomNums.pop();
			int tempResult = 0;
			if (operator.equals("+"))
				tempResult = operand1 + operand2;
			else if (operator.equals("-"))
				tempResult = operand1 - operand2;
			else
				throw new DiceNotValidException(ERROR_MESSAGE);

			randomNums.push(tempResult);
		}
		if (randomNums.isEmpty() || randomNums.size() != 1) {
			throw new DiceNotValidException(ERROR_MESSAGE);
		} else {
			return randomNums.pop();
		}
	}

	public static void createOperandOperatorList(String[] diceInput) throws DiceNotValidException {
		for (int i = 0; i < diceInput.length; i++) {
			String temp = diceInput[i].trim();
			if (temp.equals("+") || temp.equals("-")) {
				operators.add(temp);
			} else if (checkOperandFormat(temp)) {
				operands.add(temp);
			} else {
				throw new DiceNotValidException(ERROR_MESSAGE);
			}
		}
	}

	public static boolean checkOperandFormat(String operand) throws DiceNotValidException {
		Pattern pattern = Pattern.compile(REGEX);
		Matcher matcher = pattern.matcher(operand);
		return matcher.matches();
	}

	public static void generateRandomNumbers() throws DiceNotValidException {
		for (String str : operands) {
			String[] diceInfo = str.split("D");
			int numOfDice = Integer.parseInt(diceInfo[0].trim());
			int numOfSides = Integer.parseInt(diceInfo[1].trim());
			if (numOfDice == 0 || numOfSides == 0) {
				throw new DiceNotValidException(ERROR_MESSAGE);
			}
			int minRange = numOfDice;
			int maxRange = numOfDice * numOfSides;
			int randomNum = new Random().nextInt(maxRange - minRange + 1) + minRange;

			randomNums.push(randomNum + 1);
		}
	}

}
