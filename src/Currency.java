
public class Currency {
    private CurrencyType name;
    private String[] formatNames;
    private double rate;
    private String shortName;

    public Currency(CurrencyType name, double rate, String shortName, String... formatNames){
        if(formatNames.length < 1 || rate < 0) throw new IllegalArgumentException();
        this.name = name;
        this.formatNames = formatNames;
        this.rate = rate;
        this.shortName = shortName;
    }

    public Currency() {
    }

    public CurrencyType getName() {
        return name;
    }

    public void setName(CurrencyType name) {
        this.name = name;
    }

    public String[] getFormatNames() {
        return formatNames;
    }

    public void setFormatNames(String... formatNames) throws IllegalArgumentException {
        if(formatNames.length < 1)
            throw new IllegalArgumentException();
        this.formatNames = formatNames;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) throws IllegalArgumentException {
        if(rate < 0)
            throw new IllegalArgumentException();
        this.rate = rate;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
