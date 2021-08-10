Feature: Sample Test Feature file

  Background:
    * url 'https://reqres.in/'

  @first @test
  Scenario: Demo Test Scenario
    * path 'api/users'
    * param page = 2
    * method GET
    * status 200
    * print response
    * match $.page == '#notnull'

  @second
  Scenario: Demo Test Scenario 2
    * path 'api/unkown'
    * method GET
    * status 201
# expected to fail