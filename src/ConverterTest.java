import java.util.Scanner;

public class ConverterTest {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        String answer = "yes";
        while (answer.equals("yes")) {
            System.out.println("Метод для тестирования:");
            System.out.println("1) nConvert");
            System.out.println("2) convert");
            System.out.println("3) printConvertOnRussian");
            System.out.println("0) Выход");
            int selectMethod = scan.nextInt();
            if(selectMethod < 0 || selectMethod > 3) {
                System.out.println("Неверный ввод, попробуйте еще раз: ");
                continue;
            }
            switch (selectMethod) {
                case 1:
                    nConvertTest(converter);
                    break;
                case 2:
                    convertTest(converter);
                    break;
                case 3:
                    printConvertOnRussianTest(converter);
                    break;
                default: return;
            }
            System.out.print("Хотите продолжить? (yes/Y): ");
            answer = scan.next();
            if(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("yes"))
                answer = "yes";
            else answer = "no";
        }
    }

    private static void nConvertTest(CurrencyConverter converter) {
        boolean isInput = true;
        int n = -1;
        while (isInput) {
            System.out.print("Введите количество конвертаций: ");
            n = scan.nextInt();
            isInput = n < 0;
        }
        System.out.print("Введите код валюты для конвертации (USD / BYN / RUB): ");
        String fromCurrency = scan.next();
        System.out.print("Введите код валюты результата конвертации (USD / BYN / RUB): ");
        String toCurrency = scan.next();
        CurrencyType from = typeFromString(fromCurrency);
        CurrencyType to = typeFromString(toCurrency);
        int[] nums = new int[n];
        System.out.print("Введите количество конвертируемой валюты: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        converter.nConverts(nums, from, to);
    }

    private static void convertTest(CurrencyConverter converter) {
        System.out.print("Введите код валюты для конвертации (USD / BYN / RUB): ");
        String fromCurrency = scan.next();
        System.out.print("Введите код валюты результата конвертации (USD / BYN / RUB): ");
        String toCurrency = scan.next();
        System.out.print("Введите количество конвертируемой валют: ");
        int num = scan.nextInt();
        CurrencyType from = typeFromString(fromCurrency);
        CurrencyType to = typeFromString(toCurrency);
        System.out.printf("%d %s = %.3f %s\n", num, fromCurrency, converter.convert(from, to, num), toCurrency);
    }

    private static void printConvertOnRussianTest(CurrencyConverter converter) {
        System.out.print("Введите код валюты для конвертации (USD / BYN / RUB): ");
        String fromCurrency = scan.next();
        System.out.print("Введите код валюты результата конвертации (USD / BYN / RUB): ");
        String toCurrency = scan.next();
        System.out.print("Введите количество конвертируемой валют: ");
        int num = scan.nextInt();
        converter.printConvertOnRussian(typeFromString(fromCurrency), typeFromString(toCurrency), num);
    }

    private static CurrencyType typeFromString(String type) {
        CurrencyType res;
        switch (type) {
            case "BYN":
                res = CurrencyType.BELARUSIAN_RUBLE;
                break;
            case "RUB":
                res = CurrencyType.RUBLES;
                break;
            default:
                res = CurrencyType.USD;
        }
        return res;
    }

    private static String stringFromType(CurrencyType type) {
        String res;
        switch (type) {
            case RUBLES:
                res = "RUB";
                break;
            case BELARUSIAN_RUBLE:
                res = "BYN";
                break;
            default:
                res = "USD";
        }
        return res;
    }
}
