# The Budget App

## A place to keep all expenses while traveling

Use *this* app to:
- Create budgets that keep track of your purchases
- Track how much money you have spent

The application I plan to create is a **budget application**. The application
helps users keep track of their purchases, shows them their past
purchases and how much money they have spent. This application can be used by any user
who wants to monitor their latest purchases, as well as have a record of them.
This project is of interest to me because, I usually forget to track my purchases. I 
try to remember my past purchases by putting them in my phone, but always forget. It would be nice
to keep track of my latest purchases and see what my activity has been like so I know
how much I am spending, as well as what I am spending my money on. I tend to travel a lot, and forget how much 
I may have spent or what I spent it on days later. This application would be a great solution to that problem.


## User Stories: 

In the context of a budget application:
- As a user, I want to be able to create a new budget
- As a user, I want to be able to add to a budget
- As a user, I want to be able to show all purchases in a budget
- As a user, I want to be able to see total money spent in a budget
- As a user, I want to be able to add a purchase to a certain budget
- As a user, I want to be able to save my budgets to file
- As a user, I want to be able to load my budgets from file



Future additions:

- As a user, I want to be able to delete a purchase in a certain budget
- As a user, I want to be able to view purchases by date in a budget
- As a user, I want to be able to view purchases by type in a budget
- As a user, I want to be able to delete a budget
- As a user, I want to be able to show all purchases of all budgets combined

Phase 4: Task 3:

Based on the design presented in my UML class diagram, I can see there is a lot of coupling within one class. If I were
to make some changes to improve my design, I would not make all my UI classes dependent on BudgetManager. I feel there
is too much dependency on one class, so I would think about breaking it up possibly, so it is not as coupled. 
Another improvement I would want to do is to refactor the application to use a map data structure, and 
eliminate the budget class all together. I feel this would be a cleaner approach to my budget application since my keys
would be the name of budget and the value would be a list of purchases unique to that key, instead of a budget 
just having a list of purchases. 
 
 