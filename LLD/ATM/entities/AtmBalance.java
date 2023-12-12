package ATM.entities;

import ATM.entities.ATM;

import java.util.ArrayList;
import java.util.List;

public class AtmBalance {
    Integer currentBalance;
    List<AvailableCurrency> availableCurrencyList;

    public List<AvailableCurrency> ableToDisburse(){
        return new ArrayList<>();
    }
}
