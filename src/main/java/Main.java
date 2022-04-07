/*
  1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
     Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
     идущих после последней четверки.
     Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.

  2. Написать метод, который проверяет состав массива из чисел 1 и 4.
     Если в нем нет хоть одной четверки или единицы, то метод вернет false;
     Если есть чтото кроме 1 или 4 то вернет false;
*/
class Main {
	static int[] getAfterLastNumber(int[] arr, int number) throws RuntimeException {
		if (arr != null && arr.length > 0) {
			int i = arr.length-1;
			while (i != 0 && arr[i] != number) i--;
			if (arr[i] == number) {
				int[] newArr = new int[arr.length - i - 1];
				System.arraycopy(arr, i + 1, newArr, 0, newArr.length);
				return newArr;
			}
		}
		throw new RuntimeException();
	}

	static boolean containsValidNumbers(int[] arr, int[] validNumbers) {
		if (arr != null && validNumbers != null && arr.length > 0 && validNumbers.length > 0) {
			boolean[] hasValid = new boolean[validNumbers.length];
			boolean valid;
			for (int i : arr) {
				valid = false;
				for (int j = 0; j < validNumbers.length; j++)
					if (i == validNumbers[j]) {
						hasValid[j] = true;
						valid = true;
					}
				if (!valid) return false;
			}
			valid = true;
			for (boolean b : hasValid) valid &= b;
			return valid;
		}
		return false;
	}

	public static void main(String[] args) {}
}