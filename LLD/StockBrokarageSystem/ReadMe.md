## Requirement

-  Able to add new Stock 
-  Able to see the stock price in a timeperiod
-  Buy/Sell Stock 
-  Able to place order
-  Should support different type of order 
-  Limit order, market order 
-  Able to create user
-  Able to see the potfolio
-  Able to see the order made by a given user 
-  Able to make payment through this platform 
-  Can create watchlist
-  Able to get update

## Flow 

1. Admin can add stock to the stock broker 
2. User make crud Operation on stock broker
3. Search stock
4. Place Order 
5. match Order
6. execute Order and make the payment
7. update Order Status
8. update user Portfolio for executed order



Add WishList 
    


   





##Component
    


###User
    Integer id 
    String name
    Portfolio userPortfolio
    List<WishList> wishLists;
    Wallet wallet 
    __________________________
    CRUD watchList
    
    


    


###Order
    id;
    OrderType => BUY/SELL
    TimeStamp
    StockId
    UserId orderPlacedBy
    Status => Placed/Inprogress/complete
    __________________________________
    getOrderHistory()
    depositMoney()
    withdrawMoney()
    
    


###LimitOrder extend Order
    Integer quantity
    Integer targetPrice

###MarketOrder extend Order
    Integer quantity;    



###WishList
    List<Integre> stockLists;
    

###Wallet 
    CurrentBalence
    Transactionhistory
    


###TransactionHistory 
    TransactionType => debit/credit
    Amount


###Amount
    Currency currency
    Integre value;
    
###Stock 
    id
    name
    currentPrice
    StockHisoty


###StockHistory 
    stockId 
    List<StockPriceTimeLine> stockHistory

###StockPriceTimeLine
    Date TimeStamp
    Integer price 
    

###Portfolio
    Integer userId
    List<PortfolioStock> portFolioStockList;
    

###PortfolioStock
    Integer stockId
    Float averagePrice
    Integer quantity
    

###StockExchange
    List<Stocks> stocks
    List<User> users;
    List<Order> orders
    ______________________
    placeOrder()
    CRUD User()
    sendNotification()
    
###Statement
    Integer userId
    TimeStammp StatementReleaseTime


###Notification
    Integer notificationId
    TimeStamp createdAt
    String Contenet
    _____________________
    send()


##Admin
    id
    name
    _____________________
    addStock();
    removeStock();
    

