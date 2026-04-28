 ADS Assignment 2
Name: Abdysadykov Daniyar
Group: IT - 2504
# Mini Banking System (ADS Assignment 2)
## Ab0out the Project

This project is a simple banking system written in Java.  
The main goal was to use different data structures and show how they work in a real life situation.

In this system, a user can create accounts, deposit and withdraw money, manage transactions, and simulate basic banking operations such as bill payments and account requests.

## What I Implemented

### Bank Accounts using LinkedList

All accounts are stored in a LinkedList.  
I chose LinkedList because the number of accounts can change, and it allows easy addition and searching.

The system supports adding a new account, displaying all accounts, and searching by username.

### Deposit and Withdraw

Each account has a balance that can be updated.  
Deposit adds money to the account.  
Withdraw removes money only if there is enough balance.

### Transaction History using Stack

I used a Stack to store transactions.  

This allows viewing the last transaction and undoing the last operation.  

Stack works in LIFO order which means the last operation is handled first.

### Bill Payment System using Queue

Bill payments are stored in a Queue.  

The first bill that is added is the first one processed.  

This follows FIFO behavior which is similar to a real waiting line.

### Account Opening Requests using Queue

New account requests are also stored in a Queue.  

The admin can view all requests and approve them one by one.  

Approved accounts are then added to the main system.

### Fixed Accounts using Array

I used an array to store three predefined accounts.  

This part shows how arrays work as a fixed size structure in memory.

## Menus in the Program

### Bank Menu

Add account  
Show accounts  
Search account  
Deposit  
Withdraw  
Add bill  
Submit request  
Show last transaction  
Undo transaction  
Show history  

### ATM Menu

Check balance  
Withdraw money  

### Admin Menu

View account requests  
Approve requests  
View bills  
Process bills  

## How to Run the Program

Open the project in IntelliJ IDEA  
Run the Main class  
Follow the menu options in the console  

## Screenshots
Main Menu
<img width="1904" height="1079" alt="image" src="https://github.com/user-attachments/assets/5a3253a5-7593-4f00-82f2-e56cef3a2517" /> 
Add Account
<img width="1908" height="991" alt="image" src="https://github.com/user-attachments/assets/e79e4b44-4334-4c10-8e37-99c3ced0615a" />
 Display Accounts
<img width="1907" height="743" alt="image" src="https://github.com/user-attachments/assets/1df34c39-999e-4807-beb1-519987ba51cd" />
Deposit
<img width="1892" height="1012" alt="image" src="https://github.com/user-attachments/assets/23728c29-50d4-4fe1-8b55-2175959b00ad" />
Withdraw
<img width="1917" height="1010" alt="image" src="https://github.com/user-attachments/assets/401fa231-b0da-4bc2-aee0-40710ec92192" />
Stack
<img width="1830" height="932" alt="image" src="https://github.com/user-attachments/assets/d0f0a556-bf59-41d5-a4de-5e38d394e010" />
<img width="1292" height="441" alt="image" src="https://github.com/user-attachments/assets/3607af3d-0331-47dc-a1dd-0f7cb4f02e3e" />
Bill Queue
<img width="853" height="351" alt="image" src="https://github.com/user-attachments/assets/03e0067a-2274-4c46-9d96-ed66891f3ae5" />
ATM Menu
<img width="1115" height="480" alt="image" src="https://github.com/user-attachments/assets/5acd98ab-87d0-4d22-818a-7fe376ffd107" />
Array
<img width="1082" height="454" alt="image" src="https://github.com/user-attachments/assets/84b6d129-2ecb-4966-826d-ede1f028ef78" />



 Conclusion

In this project, I used different data structures depending on the situation.  

LinkedList is used for storing accounts because it is dynamic.  
Stack is used for transaction history because it supports undo operations.  
Queue is used for bill payments and requests because they follow order.  
Array is used to demonstrate fixed size memory structure.  

This project helped me understand how each data structure works and where it can be used in real applications.


