Feature: MRC Login
  As a user I should able to login into MRC.

  Scenario: Prerequisites
    Given I want to test against "https://mrc-pp.metrosystems.net"
    And I want to use user "catalin.morariu@metrosystems.net" with password "Era.074438!"
    And I want to use default timeout 20 seconds for each operation

  Scenario: I login with valid credential
    Given I go to the host
    When I enter user into input field having id "user_id"

    And I enter password into input field having id "password"
    When I click on element having id "submit"
    Then I wait for page loading but no more than 20 seconds
   
  Scenario: Type customer
  	Given I click on element having xpath "/html/body/div/div/main/div/div[1]/a[2]/label/h2"
    Then I enter "23/44852" into input field having id "search-input"
    Then element having xpath "//section[@class='mrc-search-result']//a[@class='no-underline']/div/h2" should have text as "23/44852"
    And element having xpath "//section[@class='mrc-search-result']//li[@class='result-summary']/span" should have partial text as "RESULT"
    When I click on element having xpath "//section[@class='mrc-search-result']//a[@class='no-underline']/div/h2/../.."
    Then I wait for page loading but no more than 20 seconds

  Scenario: Quickcheck status page
    Then element having xpath "//div[@class='customer-info']//div[@class='infos']/h2" should have text as "23/44852"
    And element having xpath "//div[@class='mrc-pre-checks']/p" should have text as "Pre-checks for 1 customers succeeded."
    And element having xpath "//div[@class='mrc-btn']/button" should have text as "QUICK CHECK"
    And element having xpath "//div[@class='recent-requests']/p" should have text as "CREDIT HISTORY"

  Scenario: Quickcheck
    Given I click on element having class "mrc-primary-button"
    Then I wait for page loading but no more than 5 seconds
    And element having xpath "//div[@class='mrc-detail']/h2" should have text as "Quick Check requested."
	Then I click on element having xpath "/html/body/div/div/main/div/div[4]/div/div/ul[1]/li/a/div/div[1]"
    Then I click on element having id "credit-data-trigger-tab"
	Then I click on element having id "sales-trigger-tab"
	Then I click on element having id "payments-trigger-tab"
	Then I click on element having id "strategy-trigger-tab"
	Then I click on element having id "scores-trigger-tab"
	Then I click on element having id "comments-trigger-tab"
	Then I click on element having id "attachments-trigger-tab"
	Then I click on element having id "customer-data-trigger-tab"
	Then I click on element having id "scores-trigger-tab"
	Then I click on element having id "audit-trail-trigger-tab"
	Then I click on element having id "credit-data-trigger-tab"
	Then I click on element having id "sales-trigger-tab"
	Then I click on element having id "payments-trigger-tab"
	Then I click on element having id "strategy-trigger-tab"
	Then I click on element having id "comments-trigger-tab"
	Then I click on element having id "attachments-trigger-tab"
	Then I click on element having id "strategy-trigger-tab"
	Then I click on element having id "scores-trigger-tab"
	Then I click on element having id "comments-trigger-tab"
	Then I click on element having id "audit-trail-trigger-tab"
	Then I click on element having id "attachments-trigger-tab"
	Then I click on element having id "customer-data-trigger-tab"
	Then I click on element having id "scores-trigger-tab"
	Then I click on element having id "credit-data-trigger-tab"
	Then I click on element having id "sales-trigger-tab"
	Then I click on element having id "payments-trigger-tab"
	Then I click on element having id "scores-trigger-tab"
	Then I click on element having id "comments-trigger-tab"
	Then I click on element having id "attachments-trigger-tab"
	Then I click on element having id "customer-data-trigger-tab"
	Then I click on element having id "scores-trigger-tab"
	Then I click on element having id "audit-trail-trigger-tab"
	Then I click on element having id "credit-data-trigger-tab"
	Then I click on element having id "sales-trigger-tab"
	Then I click on element having id "payments-trigger-tab"
	Then I click on element having id "strategy-trigger-tab"
	Then I click on element having id "comments-trigger-tab"
	Then I click on element having id "attachments-trigger-tab"
	Then I click on element having id "strategy-trigger-tab"
	Then I click on element having id "scores-trigger-tab"
	Then I click on element having id "comments-trigger-tab"
	Then I click on element having id "customer-data-trigger-tab"

  