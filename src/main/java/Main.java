import java.util.Arrays;

/*1. Написать метод, на вход которому подается двумерный строковый массив размером 4х4.
 При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
   Если в каком-то элементе преобразование не удалось (например, если в ячейке лежит символ или текст вместо числа),
   надо бросить исключение MyArrayDataException с детализацией, в какой ячейке неверные данные.
  3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException
  и MyArrayDataException и вывести результат расчета.

 */
public class Main {
    public static void main(String[] args) {
        String[][] myInvalidArray =
                {{"1", "2", "2", "3"},
                        {"A", "2", "6", "w"},
                        {"1", "22", "2,5", "6"},
                        {"2", "2", ">", "9"},
                        //{"Five"}
                };
        try {
            System.out.println(myArray(myInvalidArray));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }


    public static int myArray(String[][] twoDimensionalStringArray) throws MyArrayDataException, MyArraySizeException {
        if (twoDimensionalStringArray.length != 4) {
            throw new MyArraySizeException("The length of the array is not equal to 4");
        }
        for (String[] array : twoDimensionalStringArray) {
            if (array.length != 4) {
                throw new MyArraySizeException("The height of the array is not equal to 4");

            }
        }
        int sum = 0;
        for (int i = 0; i < twoDimensionalStringArray.length; i++) {
            for (int j = 0; j < twoDimensionalStringArray.length; j++) {
                try {
                    sum += Integer.parseInt(twoDimensionalStringArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Not a number in the element:" + i + "," + j);
                }
            }
        }
        return sum;
    }
}