# UI Automation framework
This is automation of typical Wordpress based web site. Framework can be used wor any wordpress site automation (at least I think so).
## Technologies used.
* java
* selenium / webdriver
* testng
## How to run test

To execute test type the following command in terminal (assuming all necessary software ws installed, and configurations were made).

> mvn -Dtest=<TEST_CLASS_NAME> -Duser.name=<USER_NAME> -Duser.password=<PASS_PHRASE> test

## Test Cases List
|#|test class name| description|
|---|---|---|
|**TC1**|LoginTestCase|Login to the user account|
|**TC2**|LogoutTestCase|Logout from the user account|
|**TC3**|CreateNewPostTestCase|Create new post|
|**TC4**|EditPostTestCase|Edit post|
|**TC5**|DeletePostTestCase|Delete post|

