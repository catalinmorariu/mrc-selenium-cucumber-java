Feature: Reports check

  Scenario: Prerequisites
  Given I want to test against "https://mrc-pp.metrosystems.net" as "test.user@metrosystems.net"
  And I want to use default timeout 20 seconds for each operation
  And Idam login if required for "user_id" as user and "password" as password and "submit"


