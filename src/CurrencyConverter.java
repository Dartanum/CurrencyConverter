public class CurrencyConverter {

    private CurrencyRepository repos;

    public CurrencyConverter() {
        repos = new CurrencyRepository();
        repos.addCurrency(new Currency(CurrencyType.BELARUSIAN_RUBLE, 25.6d, "Br",
            "беларусский рубль", "беларусских рубля", "беларусских рублей"));
        repos.addCurrency(new Currency(CurrencyType.RUBLES, 1d, "\u20BD",
            "российский рубль", "российских рубля", "российских рублей"));
        repos.addCurrency(new Currency(CurrencyType.USD, 70.2d, "$",
            "американский доллар", "американских доллара", "американских долларов"));
    }

    public static void help() {
        System.out.println("Данный класс позволяет конвертировать введенную" +
                "сумму денег из одной валюты в другую. " +
                "Перед началом конвертации создайте экземпляр класса CurrencyConverter." +
                " После этого можно приступить к конвертации с помощью метода convert или" +
                " printConvertOnRussian. Второй метод выводит результат на экран в виде текста, " +
                "а первый выводит целочисленное значение результата. from и to - объекты типа Currency, " +
                "которые представляют валюту. num - количество конвертируемой валюты");
    }
    public double convert(CurrencyType from, CurrencyType to, int num) {
        double rubles =  num * repos.getCurrency(from).getRate();
        return rubles / repos.getCurrency(to).getRate();
    }

    public void printConvertOnRussian(CurrencyType from, CurrencyType to, int num) {
        Currency fromCurrency = repos.getCurrency(from);
        Currency toCurrency = repos.getCurrency(to);
        double res = convert(from, to, num);
        System.out.print(num);
        correctPrint(num, fromCurrency.getFormatNames());
        String equalWord = num == 1 ? "равен " : "равны ";
        System.out.print(equalWord + res);
        correctPrint((int)res, toCurrency.getFormatNames());
        System.out.println();
    }

    public void nConverts(int[] values, CurrencyType from, CurrencyType to) {
        System.out.printf("Сумма (%s)\tСумма (%s)\n", repos.getCurrency(from).getRate(), repos.getCurrency(to).getRate());
        for(int i : values) {
            System.out.printf("%3d\t\t%15.4f\n", i, convert(from, to, i));
        }
    }
    private byte expressionFlag(int num) {
        int digit;
        if(5 <= num && num <= 20) return 2;
        else {
            digit = num % 10;
            if(digit == 1) return 0;
            else if(2 <= digit && digit <= 4) return 1;
            else return 2;
        }
    }

    private void correctPrint(int num, String... formatNames) {
        byte exprFlag = expressionFlag(num);
        if(formatNames.length >= exprFlag) {
            System.out.print(" " + formatNames[exprFlag] + " ");
        }
    }
}
