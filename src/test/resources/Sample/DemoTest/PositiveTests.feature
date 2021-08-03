Feature: Sample Test Feature file

  Background:
    * url 'https://reqres.in/'

  @first
  Scenario: Demo Test Scenario
    * path 'api/users'
    * param page = 2
    * method GET
    * status 200
    * match $.page == '#notnull'

  @second
  Scenario: Demo Test Scenario
    * path 'api/unkown'
    * method GET
    * status 200
    * match $.page == '#notnull'