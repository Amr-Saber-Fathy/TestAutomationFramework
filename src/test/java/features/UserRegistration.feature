Feature: User Registration
User can register successfully

Scenario Outline: User can register successfully with valid data

Given User is on the main page
When User click on Register
And User enters valid "<firstName>", "<lastName>", "<email>", "<password>"
Then Successful Registration page appear

Examples:
| firstName | lastName | email          | password |
| Amr       | Saber    | asf2@gmail.com | 12345678 |
| test      | number1  | test2@gmail.com| 12345678 |