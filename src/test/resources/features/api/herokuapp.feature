@api
Feature:API Testing

  @tc02
  Scenario: TC02 Testing for authentication api
    Given  User sends a POST request for authentication
    Then  User verifs that  status code is 200
    Then User verifs that token value is not empty


  @tc03
  Scenario: TC03 Testing for booking api
    Given  User sends a GET request for booking
    Then  User verifs that  status code is 200
    Then User verifs that booking value contains "471"

  @tc04
  Scenario: TC04 Testing for create booking api
    Given  User sends a POST request for create booking
    Then  User verifs that  status code is 200
    Then  User verifs that  firstname is "Turgay" for creation booking
    Then  User verifs that  lastname is "lastname" for creation booking
    Then  User verifs that  total price is "totalprice" for creation booking
    Then  User verifs that  deposit paid "depositpaid" for creation booking
    Then  User verifs that  checkin  is "2018-01-01" for creation booking
    Then  User verifs that  checkout  is "2019-01-01" for creation booking

    @tc05
    Scenario: TC05 Testing for booking api with id
      Given  User sends a GET request for booking with id "70"
      Then  User verifs that  status code is 200
      Then  User verifs that  firstname is "Turgay"
      Then  User verifs that  lastname is "Uludag"
      Then  User verifs that  total price is "1500"
      Then  User verifs that  deposit paid "true"
      Then  User verifs that  checkin  is "2025-06-06"
      Then  User verifs that  checkout  is "2025-07-07"


  @tc06
  Scenario: TC06 Testing for update booking api
    Given  User sends a PUT request for update booking
    Then  User verifs that  status code is 200
    Then  User verifs that  firstname is "updated" for update booking




