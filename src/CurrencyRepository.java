import java.util.HashMap;
import java.util.Map;

/**
 * todo Document type CurrencyRepository
 */
public class CurrencyRepository {
    private Map<CurrencyType, Currency> currencies;

    public CurrencyRepository() {
        currencies = new HashMap<>();
    }

    public Currency getCurrency(CurrencyType name) {
        return currencies.get(name);
    }

    public boolean addCurrency(Currency currency) {
        if(currencies.containsKey(currency.getName()))
            return false;
        currencies.put(currency.getName(), currency);
        return true;
    }
}
