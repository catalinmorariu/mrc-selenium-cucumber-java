Feature: Reports check

  Scenario: Prerequisites
  Given I want to test against "https://mrc-dev.metrosystems.net/"
  And I want to use user "testmrc4@mcc.net" with password "Mrc.1234!"
  And I want to use default timeout 20 seconds for each operation

  Scenario: I login with valid credential
  Given I go to the host
  When I enter user into input field having id "user_id"
  And I enter password into input field having id "password"
  When I click on element having id "submit"
  Then I wait for page loading but no more than 20 seconds

  Scenario: Edit and cancel request
		
  Given I click on element having xpath "//*[@id="react"]/div/main/div/div[5]/div/button"
  Then I wait for page loading but no more than 2 seconds
  And I click on element having id "mrc-cancel-button"
  Then I wait for page loading but no more than 2 seconds
  And I click on element having id "mrc-cancel-button"



