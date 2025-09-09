## Design Google Calender 

### Functional Requirement 
- We have to have centralised system which contains information about days year, current day and so on 
- User is able to see their calander
- User is able to block calender and invite multiple user in that meeting 
- Once blocking is done system is able to send notification about the meeting
- you can add reminder about a perticuller meeting
- User able to check other user calender 
- User is able to create a recurring meeting
- Meeting invite have some instruction or information(agenda, title etc)
- Able to get a status from all user invited for meeting whether they accepted or not
- Cancel an event 
- update an event
- View all event in the date range
- 

### Non functional requirement 







### Flow

- As a user i can open the app and check my calender
- User have their calender object 
- there is method through which you can see the calender of other user
- 





### Entity 

- User
  - Entity 
    - id
    - name 
    - calender
    - email
  - Method 
    - getCalender
    - createMeeting
    - DeleteMeeting
    - UpdateMeeting
    - IsFree()
  
- Calender
    - Entity 
        

Meetings





API 


### Entity 
```
Calender
{
    List<Year>
    
}

Year
{
    Name:
    List<Months> 
}

Month {
    List<Week>
}

Week {
List<Day>
}

Day {
    List<Hours>
    
}

```
```
User

{
name 
id 
calender 

}

```
```
Meeting
{
    id
    startTime
    endTime
    recurring frequency 
    recurring endtime
    description 
    guest list 
    hostUserID    
}
```
Meetings



Notification

