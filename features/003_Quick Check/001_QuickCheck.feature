Feature: Quick Check

  Scenario: Prerequisites
  Given I want to test against "https://mrc-dev.metrosystems.net/"
  And I want to use user "test.user@metrosystems.net" with password "Mc.074438!"
  And I want to use default timeout 20 seconds for each operation

  Scenario: I login with valid credential
  Given I go to the host
  When I enter user into input field having id "user_id"
  And I enter password into input field having id "password"
  When I click on element having id "submit"
  Then I wait for page loading but no more than 20 seconds
      
  Feature: Quickcheck for customer

  Scenario: Type customer
    Given I enter "15/1222" into input field having id "search-input"
    Then element having xpath "//section[@class='mrc-search-result']//a[@class='no-underline']/div/h2" should have text as "15/1222"
    And element having xpath "//section[@class='mrc-search-result']//li[@class='result-summary']/span" should have partial text as "RESULT"
    When I click on element having xpath "//section[@class='mrc-search-result']//a[@class='no-underline']/div/h2/../.."
    Then I wait for page loading but no more than 20 seconds

  Scenario: Quickcheck status page
    Then element having xpath "//div[@class='customer-info']//div[@class='infos']/h2" should have text as "15/1222"
    And element having xpath "//div[@class='mrc-pre-checks']/p" should have text as "Pre-checks for 2 customers succeeded."
    And element having xpath "//div[@class='mrc-btn']/button" should have text as "QUICK CHECK"
    And element having xpath "//div[@class='recent-requests']/p" should have text as "CREDIT HISTORY"

  Scenario: Quickcheck
    Given I click on element having class "mrc-primary-button"
    Then I wait for page loading but no more than 20 seconds
    And element having xpath "//div[@class='mrc-detail']/h2" should have text as "Quick Check requested."
	


    
	
