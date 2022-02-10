Feature: test configuration

@test @demo
Scenario: test TC001
#Given Print "testing the cucumber configuration" statement
  Given Open "googleURL" Website
  Then capture screenshot
  Then Print "logs in reports" statement