@api
Feature:API Testing

  @tc02
  Scenario: TC02 Testing for authentication api
    Given  User sends a POST request for authentication
    Then  User verifs that  status code is 200
    Then User verifs that token value is not empty


  @tc03 @api
  Scenario: TC03 Testing for booking api
    Given  User sends a GET request for booking
    Then  User verifs that  status code is 200
    Then User verifs that booking value contains "471"