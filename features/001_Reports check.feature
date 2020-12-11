Feature: Reports check

  Scenario: Prerequisites
  Given I want to test against "https://mrc-pp.metrosystems.net/"
  And I want to use user "catalin.morariu@metrosystems.net" with password "Sindo.074438!"
  And I want to use default timeout 20 seconds for each operation

  Scenario: I login with valid credential
  Given I go to the host
  When I enter user into input field having id "user_id"
  And I enter password into input field having id "password"
  When I click on element having id "submit"
  Then I wait for page loading but no more than 20 seconds
