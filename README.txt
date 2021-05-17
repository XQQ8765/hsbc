1. How to build the project:
> mvn clean package

2. How to run the build jar.
> java -jar hsbc-1.0-SNAPSHOT.jar
(The jar file is built under project "target" folder by maven)

3. Project description
The application accepts "Payment" from user input or an file.
The Total payments amount for each currency will be printed out into console at each 1 min schedule.
The output is like below in console:
-------------PrintPaymentBoardTimerTask-------------
Current time is:2021-05-17T12:18:48.106Z, Total payments:
  HKD 300
  USD 3900
  CNY 2000
----------------------------------------------------



4. A demo video: demo.video.