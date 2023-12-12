package ATM.entities;

import lombok.Builder;

import java.util.List;

@Builder
public class Bank {
    String name;
    Integer bankId;
    List<Customer> customers;
    List<ATM> atms;
    Address address;

}



