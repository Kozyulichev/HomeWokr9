public class HomeWork9 {
    public static class MyArraySizeException extends Exception {
    }

    public static class MyArrayDataException extends Exception {
        private int i;
        private int j;

        MyArrayDataException(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        String[][] arr = new String[][]{{"1", "1", "1", "1"}, {"2", "2", "2", "2"}, {"3", "3", "3", "3"}, {
                "4", "4", "4", "4"}
        };
        try {
            try {
                int result = exeptionTest(arr);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                System.err.println("Размер массива превышен");
            }
        } catch (MyArrayDataException e) {
            System.err.println("Неправильное значение");
            System.err.println("Ошибка в массиве: порядковый номер " + e.i + " ячейка " + e.j);
        }
    }

    public static int exeptionTest(String[][] arr) throws MyArrayDataException, MyArraySizeException {
        int count = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count = count + Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }
        return count;
    }
}


