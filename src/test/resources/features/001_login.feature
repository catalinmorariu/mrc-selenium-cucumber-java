Feature: MRC Login
  As a user I should able to login into MRC.
  Scenario: Prerequisites
    Given I want to test against "https://mrc-pp.metrosystems.net"
    And I want to use user "catalin.morariu@metrosystems.net" with password "Rock.074438!"
    And I want to use default timeout 20 seconds for each operation

  Scenario: I login with valid credential
    Given I go to the host
    When I enter user into input field having id "user_id"
    
    And I enter password into input field having id "password"
    When I click on element having id "submit"
    Then I wait for page loading but no more than 20 seconds
    
      Scenario: Credit correction
    Given I click on element having xpath "//*[@id="react"]/div/main/div/div/a[3]/label/h2"
    Then I enter "39/22044" into input field having id "search-input"
    And element having xpath "//section[@class='mrc-search-result']//a[@class='no-underline']/div/h2" should have text as "39/22044"
    And element having xpath "//section[@class='mrc-search-result']//li[@class='result-summary']/span" should have partial text as "RESULT"
    Then I click on element having xpath "//section[@class='mrc-search-result']//a[@class='no-underline']/div/h2/../.."
    Then I click on element having xpath "//*[@id="react"]/div/main/div/div[2]/button"
    Then I enter "0" into input field having xpath "/html/body/div/div/main/form/div[2]/div[1]/div/div[3]/div/div/div/div[1]/div/input"
    Then I click on element having id "mrc-cancel-button"
    Then I wait for page loading but no more than 20 seconds
