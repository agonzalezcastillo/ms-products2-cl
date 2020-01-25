Feature: A supplier and his products can be retrieved

  Scenario: Client makes call to GET rest supplier endpoint
    Given i can get a supplier
    When the client receives an ok status code 200
    Then the client Receives an object

  Scenario: Client makes call to DELETE rest supplier endpoint
    Given there is a supplier stored in the database
    When the client makes a call to DELETE supplier endpoint
    Then the client Receives the list of suppliers and products updated