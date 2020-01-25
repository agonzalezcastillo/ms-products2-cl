Feature: Products operations

  Scenario: Client makes call to GET rest product endpoint
    Given some products have been stored in the database
    When the client makes a call to get rest product endpoint
    Then the client gets a list of products

  Scenario: Client can update Products quantity
    Given some products have been stored in the database
    When the client makes a call to PUT rest product endpoint
    Then the client gets product quantity updated to 1