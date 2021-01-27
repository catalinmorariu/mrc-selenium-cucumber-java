Feature: Quick Check

  Scenario: Login into application

    Given I want to test against "https://mrc-pp.metrosystems.net" as "test.user@metrosystems.net"
    And Idam login if required for "user_id" as user and "password" as password and "submit"
    And go to "quickCheck" tile at launchpad
    And enter "15/1222" into "search-input" and pick it from the list

  Scenario: Submit Quick check

    And go to "quickCheck" tile at launchpad
    And enter "15/1222" into "search-input" and pick it from the list
































