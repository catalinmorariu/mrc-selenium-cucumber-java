Feature: MRC Login
  As a user I should able to login into MRC.
  Scenario: Prerequisites

    Given I want to test against "https://mrc-pp.metrosystems.net" as "test.user@metrosystems.net"
    And I want to use default timeout 50 seconds for each operation
    And Idam login if required for "user_id" as user and "password" as password and "submit"
    And go to "history" tile at launchpad
    And enter "15/1222" into "search-input" and pick it from the list
#    And go to report "Running Requests" and wait
