##Requirement
- user is able to search a hotel check availability for given dates
- user able to book rooms in a hotel 
- user able to cancel the booking 
- Admin able to add a new hotel to the inventory 
- Able to make payment via this platform
- Able to check booking history 
- Able to run marketing campaign/coupon
- Able to update pricing
- Able to send notification for various events
- Able to track housekeeping logs
- Customer can order food and rom service at any given point of time


## Flow 
###Booking Flow 
- User go the platform and search hotel accoring to various parameter 
  like location, dates, type of room ,budget
- Get room/Amenities details for selected room/hotels
- Add room to the cart and make the booking 
- apply coupon if anything applicable
- Make payment for booking 
- received confirmation notification

###Cancel flow 
- Select the booking and cancel it
- Get the refund back to your source
- Get notification for cancellation

###CheckIn/CheckOut flow







##Components

### User 
    Integer userId
    String name;
    Address Address;
    __________________
    makeABooking


###Admin extends User
    _______________
    addhotelToInventory
    removehotelFromInventory
    addRoomToAHotel
    RemoveRooomForAHotel
    updatePrice

### Search<Interface>
    search()

###Guest extends User impliments Search
    _______________
    addhotelToInventory
    removehotelFromInventory
    addRoomToAHotel
    RemoveRooomForAHotel
    updatePrice

### Receptionist extend User impliment Search 

###Address
    String street 
    String city 
    String state

###HotelManagementSystem
    List<Hotel> hotels;
    List<User> users;
###Hotel 
    Integer id;
    String name;
    Address address
    List<Room> rooms;
    List<HotelAmenity> amenities;
    List<Booking> bookings


    

    

### HotelAmenities
    Bathtub


###Room Amenities <Enum>
    Bathtub
    Balcony 
    
    
###Room
    Integer id;
    Integer hotelId;
    String dimention;
    List<RoomAmenities> roomAmenities
    


###RoomPrice
    List<Integer, Integer> roomPrice
    
    

###Booking 
    Integer id;
    BookingType bookingtype => online/offline
    BookingStatus bookingStatus => Inprogress/ success/cancel
    user bookedBy
    TimeStamp bookingTime
    Payment payment;
    Service services;
    



###Service
    Integer id;
    Integer  bookingId;
    List<HouseKeepingLog> housekeepingLog;
    List<ServiceOrder> serviceOrder;
    _____________________________
    makeHouseKeepingRequest()
    makeServiceOrder()


###HouseKeepingLog
    Integer id;
    User houseKeeper
    TimeStamp houseKeepingTimeStamp
    _____________________
    doHouseKeeping()


###ServiceOrder
    Integer id;
    Integer serviceId
    OrderStatus orderStatus
    Payment payment
    Time orderTime
    _________________________
    makeServicePayment()

###FooDServiceOrder extends ServiceOrder
    Integer id
    List<FoodItems> items
    
###SpaService extends ServiceOrder 
    Integer id;
    List<SpaService> items


###Payment
    Integer id 
    Amount bookingAmount
    String paymentMethod


###Notification
    Integer id;
    String content
    TimeStamp createdOn;

###EmailNotification extends Notification
    String destinationAddress;
    _______________________________
    sendEmail

### SMSNotification extends Notification
    String destinationMobileNumber
    _________________________________
    sendSms()




    
    
    










