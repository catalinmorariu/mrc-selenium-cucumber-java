Feature: MRC Login
  As a user I should able to login into MRC.
  Scenario: Prerequisites

    Given I want to test against "https://mrc-pp.metrosystems.net" as "test.user@metrosystems.net"
    And Idam login if required for "user_id" as user and "password" as password and "submit"

