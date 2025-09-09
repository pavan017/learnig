we have to follow some pattern for lld code 

Requirement and goals of the system 
1=> User able to withdraw money 
2=> User able to check the balance 
3=> User able to update personal details like password/ address etc 
4=> Provide proper error message for any user which is not possible 
5=> Able to print the account statement 
6=> Able to deposit the cash
7=> Able to transfer the funds


Component 
============

=> screen 
=> keypad 
3=> card reader 
4=> cash dispenser



flow 
======

=> user enter the card => select operation(suppose cash withdraw)=> select/insert amount
=> enter pincode => collect cash => collect account stament => transaction complete 



Actors 
========

operator/manager 
=> turning atm on/off
=> refilling the cash 
=> refill paper and ink if required 
=> collect deposit cheque/cash
=> Able to check the remaing cash in atm 
=> generate report for all the transaction happend at a given period of time 



customer
=> depoisit 
=> withdrow 
=> balance equiry 
=> deposit cheque




ATM 
=====
    => id
    => type
    => address 
    => capacity 
    => Screen 
    => keypad
    => cardreader 
    => cash despenser 
    => printer 


Account
    number 
    acount_type
    balance 
    status => active/inactive
    List<Card>

Saving Account 
Current Account




Card 
=======
    => card id 
    => account number
    => pin 
    => expiry
    

Bank 
======
    name 
    bank_id 
    List<Account>;
    List<ATM>
    

    
Transaction 
    id 
    status 
    creation date 
    

Balance Enquiry
    accountId

Deposit 
    Integer account Id
    Integer amount

    cash deposit 
    cheque deposit

    

Withdraw
    accountId
    amount
    
Transfer
    sourceAccountId
    destinationAccountId
    amount


Amount 
    Value; 
    Currency;
    


    



Customer 
==========
    => id
    => List<Card>
    => 

    










