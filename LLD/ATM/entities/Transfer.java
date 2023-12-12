package ATM.entities;

import ATM.entities.ATM;

public class Transfer extends Transaction{
    Integer SourceAccountId;
    Integer DestinationAccountId;
    Integer amount;
}
