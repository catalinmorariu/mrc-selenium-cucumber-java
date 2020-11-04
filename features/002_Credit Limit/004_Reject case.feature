Feature: Top Management Tab

  Scenario: Prerequisites
  Given I want to test against "https://mrc-pp.metrosystems.net/"
  And I want to use user "test.user@metrosystems.net" with password "Mc.074438!"
  And I want to use default timeout 20 seconds for each operation

  Scenario: I login with valid credential
  Given I go to the host
  When I enter user into input field having id "user_id"
  And I enter password into input field having id "password"
  When I click on element having id "submit"
  Then I wait for page loading but no more than 20 seconds
      
  Scenario: Credit limit request  
  Given I click on element having xpath "//*[@id="react"]/div/main/div/div[1]/a[1]/label/h2"
  When I enter "23/44852" into input field having id "search-input"
  Then I click on element having xpath "/html/body/div/div/main/div/section[2]/ul/li[2]/a/div/h1"
  Then I wait for page loading but no more than 20 seconds
	And I click on element having xpath "//*[@id="react"]/div/div/div/div[1]/ul/li[2]/a/img"
	And I click on element having xpath "//*[@id="react"]/div/main/div/div[1]/div/div[2]/label/span/p"
	And I click on element having xpath "/html/body/div/div/main/div/div[3]/div[1]/a/span/ul/li[1]/p/mrc-date"
	And I click on element having id "react-tabs-0"
	And I click on element having id "react-tabs-2"
	And I click on element having id "react-tabs-4"	
	And I click on element having id "react-tabs-6"
	And I click on element having id "react-tabs-8"
	And I click on element having id "react-tabs-14"
	And I click on element having xpath "/html/body/div[1]/div/main/div/div[4]/div[8]/div/div[2]/div/textarea"
	When I enter "For testing purposes only" into input field having xpath "/html/body/div[1]/div/main/div/div[4]/div[8]/div/div[2]/div/textarea"
	When I enter "For testing purposes only" into input field having xpath "/html/body/div[1]/div/main/div/div[4]/div[8]/div/div[2]/div/textarea"
	When I enter "For testing purposes only" into input field having xpath "/html/body/div[1]/div/main/div/div[4]/div[8]/div/div[2]/div/textarea"
	When I enter "For testing purposes only" into input field having xpath "/html/body/div[1]/div/main/div/div[4]/div[8]/div/div[2]/div/textarea"
	And I click on element having id "react-tabs-0"
	And I click on element having xpath "/html/body/div[1]/div/main/div/div[4]/div[1]/div/section/div/button"
	When I enter "Please check the conditions, previously" into input field having xpath "/html/body/div[1]/div/main/div/div[4]/div[1]/div/section/div/div/div[2]/div/div/div[2]/textarea"
	And I click on element having xpath "/html/body/div[1]/div/main/div/div[4]/div[1]/div/section/div/div/div[2]/div/div/div[1]/div/label[1]"
	And I click on element having xpath "//*[@id="react-tabs-1"]/div/section/div/div/div[2]/div/div/div[3]/button[2]"
	And I click on element having xpath "/html/body/div[1]/div/main/div/div[4]/div[1]/div/section/div/button"
	When I enter "Please check the conditions, previously" into input field having xpath "/html/body/div[1]/div/main/div/div[4]/div[1]/div/section/div/div/div[2]/div/div/div[2]/textarea"
	And I click on element having xpath "//*[@id="react-tabs-1"]/div/section/div/div/div[2]/div/div/div[3]/button[1]"
	
	And I click on element having xpath "//*[@id="react"]/div/div/div/div[1]/ul/li[2]/a/img"
	And I click on element having xpath "//*[@id="react"]/div/main/div/div[1]/div/div[2]/label/span/p"
	And I click on element having xpath "/html/body/div/div/main/div/div[3]/div[1]/a/span/ul/li[2]"
	And I click on element having id "react-tabs-0"
	And I click on element having id "react-tabs-2"
	And I click on element having id "react-tabs-14"
	And I click on element having xpath "/html/body/div[1]/div/main/div/div[4]/div[8]/div/div[2]/div/textarea"
	When I enter "TestingTestingTesting" into input field having xpath "/html/body/div[1]/div/main/div/div[4]/div[8]/div/div[2]/div/textarea"
	When I enter "TestingTestingTesting" into input field having xpath "/html/body/div[1]/div/main/div/div[4]/div[8]/div/div[2]/div/textarea"
	And I click on element having id "react-tabs-0"
	And I click on element having xpath "/html/body/div[1]/div/main/div/div[4]/div[1]/div/section/div/button"
	When I enter "Please check the conditions, previously" into input field having xpath "/html/body/div[1]/div/main/div/div[4]/div[1]/div/section/div/div/div[2]/div/div/div[2]/textarea"
	And I click on element having xpath "/html/body/div[1]/div/main/div/div[4]/div[1]/div/section/div/div/div[2]/div/div/div[1]/div/label[1]"
	And I click on element having xpath "//*[@id="react-tabs-1"]/div/section/div/div/div[2]/div/div/div[3]/button[2]"
	And I click on element having xpath "/html/body/div[1]/div/main/div/div[4]/div[1]/div/section/div/button"
	When I enter "Positive recommendation;;;;;;;Positive recommendation" into input field having xpath "/html/body/div[1]/div/main/div/div[4]/div[1]/div/section/div/div/div[2]/div/div/div[2]/textarea"
	And I click on element having xpath "//*[@id="react-tabs-1"]/div/section/div/div/div[2]/div/div/div[3]/button[1]"





Feature: MRC Login
  As a user I should able to login into MRC.

  Scenario: Prerequisites
    Given I want to test against "https://mrc-pp.metrosystems.net"
    And I want to use user "catalin.morariu@metrosystems.net" with password "Sindo.074438!"
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





Feature: Credit Limit positive flow

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

  Scenario: Customer search and submit request
  
    Given I click on element having xpath "//*[@id="react"]/div/main/div/div[1]/a[1]/label/h2"
    When I enter "23/44852" into input field having id "search-input"
    Then I click on element having xpath "/html/body/div/div/main/div/section[2]/ul/li[2]/a/div/h1"
    Then I wait for page loading but no more than 2 seconds
    And I click on element having xpath "//*[@id="react"]/div/main/div/div[4]/div/button"
    And I click on element having id "react-tabs-2"
    And I click on element having id "react-tabs-4"
    And I click on element having id "react-tabs-6"
    And I click on element having id "react-tabs-8"
    And I click on element having id "react-tabs-0"
    And I click on element having id "react-tabs-2"
    #And I click on element having xpath "//*[@id="react"]/div/main/form/div[3]/button[2]"
    
   

  Scenario: Credit details

  	Given I click on element having xpath "//*[@id="react"]/div/main/form/div[3]/button[2]"
  	Then I wait for page loading but no more than 2 seconds
    Given I click on element having xpath "//*[@id="react-tabs-3"]/div/div/div/div[2]/table/tbody/tr[4]/td[6]/span"
    When I click on element having xpath "//*[@id="react-tabs-3"]/div/div/div/div[2]/table/tbody/tr[6]/td/div[2]/div[2]/div[1]/div[2]/div/span"
    When I enter "255000" into input field having xpath "//*[@id="react-tabs-3"]/div/div/div/div[2]/table/tbody/tr[6]/td/div[2]/div[2]/div[2]/div[1]/div/div/div/input"
    When I enter "15" into input field having id ""
    Given I click on element having xpath "//*[@id="react-tabs-3"]/div/div/div/div[2]/table/tbody/tr[6]/td/div[2]/div[2]/div[2]/div[1]/div/div/div"
    //And I click on element having xpath "//*[@id="react"]/div/main/form/div[3]/button[2]"
    
    
  	Scenario: CM approval
  
    Given I click on element having xpath "//*[@id="react"]/div/div/div/div[1]/ul/li[2]/a/img"
    Then I click on element having xpath "//*[@id="react"]/div/main/div/div[1]/div/div[2]/label/div"
    Then I wait for page loading but no more than 2 seconds
    Then I click on element having xpath "//*[@id="8fc0a16a-aa2d-4de9-ad77-e133d766614f"]/div[1]/a/span/ul/li[2]/span[1]/p"
    And I click on element having id "react-tabs-0"
    And I click on element having id "react-tabs-2"
    And I click on element having id "react-tabs-4"
    And I click on element having id "react-tabs-6"
    And I click on element having id "react-tabs-8"
    And I click on element having id "react-tabs-10"
    And I click on element having id "react-tabs-12"
    And I click on element having id "react-tabs-14"
    And I click on element having id "react-tabs-16"
    And I click on element having id "react-tabs-18"
    And I click on element having id "react-tabs-16"
    And I click on element having id "react-tabs-14"
    And I click on element having id "react-tabs-12"
    And I click on element having id "react-tabs-10"
    And I click on element having id "react-tabs-8"
    And I click on element having id "react-tabs-6"
    And I click on element having id "react-tabs-4"
    And I click on element having id "react-tabs-2"
    And I click on element having id "react-tabs-0"
    And I click on element having id "react-tabs-2"
    #And I click on element having id "mrc-approve-button"




























Feature: CL reject an approve less

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
      
  Scenario: Customer search and submit request
  
    Given I click on element having xpath "//*[@id="react"]/div/main/div/div[1]/a[1]/label/h2"
    When I enter "23/44852" into input field having id "search-input"
    Then I click on element having xpath "/html/body/div/div/main/div/section[2]/ul/li[2]/a/div/h1"
    Then I wait for page loading but no more than 10 seconds
    And I click on element having xpath "//*[@id="react"]/div/main/div/div[4]/button"
    And I click on element having id "react-tabs-2"
    And I click on element having id "react-tabs-4"
    And I click on element having id "react-tabs-6"
    And I click on element having id "react-tabs-8"
    And I click on element having id "react-tabs-0"
    And I click on element having id "react-tabs-2"
    And I click on element having id "react-tabs-2"
    
    
	#Credit details

  	Given I click on element having xpath "//*[@id="react"]/div/main/form/div[3]/button[2]"
  	Then I wait for page loading but no more than 2 seconds
    Given I click on element having xpath "//*[@id="react-tabs-3"]/div/div/div/div[2]/table/tbody/tr[4]/td[6]/span"
    When I click on element having xpath "//*[@id="react-tabs-3"]/div/div/div/div[2]/table/tbody/tr[6]/td/div[2]/div[2]/div[1]/div[2]/div/span"
    Then I wait for page loading but no more than 2 seconds
    Then I scroll to element having xpath "//*[@id="react-tabs-3"]/div/div/div/div[2]/table/tbody/tr[6]/td/div[2]/div[2]/div[2]/div[1]/div/div/div/input"   
   	And I click on element having xpath "//*[@id="react-tabs-3"]/div/div/div/div[2]/table/tbody/tr[6]/td/div[2]/div[2]/div[2]/div[1]/div/div/div/input"
    Then I enter "30000" into input field having css "#react-tabs-3 > div > div > div > div.mrc-ui-credit-tab-table-container.mrc-ui-grid-item > table > tbody > tr.mrc-ui-table-r.mrc-ui-table-r-form > td > div:nth-child(3) > div.mrc-ui-form-main-column > div.mrc-ui-card.mrc-ui-card-shadow > div:nth-child(2) > div > div > div > input"
    Then I clear input field having css "#react-tabs-3 > div > div > div > div.mrc-ui-credit-tab-table-container.mrc-ui-grid-item > table > tbody > tr.mrc-ui-table-r.mrc-ui-table-r-form > td > div:nth-child(5) > div.mrc-ui-form-main-column > div > div > input"
    Then I enter "25" into input field having css "#react-tabs-3 > div > div > div > div.mrc-ui-credit-tab-table-container.mrc-ui-grid-item > table > tbody > tr.mrc-ui-table-r.mrc-ui-table-r-form > td > div:nth-child(5) > div.mrc-ui-form-main-column > div > div > input"
 		Then I clear input field having css "#react-tabs-3 > div > div > div > div.mrc-ui-credit-tab-table-container.mrc-ui-grid-item > table > tbody > tr.mrc-ui-table-r.mrc-ui-table-r-form > td > div:nth-child(5) > div.mrc-ui-form-main-column > div > div > input"
 		Then I enter "2316546541654" into input field having css "#react-tabs-3 > div > div > div > div.mrc-ui-credit-tab-table-container.mrc-ui-grid-item > table > tbody > tr.mrc-ui-table-r.mrc-ui-table-r-form > td > div:nth-child(5) > div.mrc-ui-form-main-column > div > div > input"
 		Then I clear input field having css "#react-tabs-3 > div > div > div > div.mrc-ui-credit-tab-table-container.mrc-ui-grid-item > table > tbody > tr.mrc-ui-table-r.mrc-ui-table-r-form > td > div:nth-child(5) > div.mrc-ui-form-main-column > div > div > input"
 		Then I enter "25" into input field having css "#react-tabs-3 > div > div > div > div.mrc-ui-credit-tab-table-container.mrc-ui-grid-item > table > tbody > tr.mrc-ui-table-r.mrc-ui-table-r-form > td > div:nth-child(5) > div.mrc-ui-form-main-column > div > div > input"
		And I click on element having id "react-tabs-6"
		And I click on element having css "#react-tabs-7 > div > div.mt-5 > button"
		Then I enter "Please approve limit, due to good sales amount in the past months" into input field having css "#react-tabs-7 > div > div.mt-5 > div > div.mrc-ui-modal > div > div > div.mrc-ui-input.clear-both > textarea"
		And I click on element having css "#react-tabs-7 > div > div.mt-5 > div > div.mrc-ui-modal > div > div > div.mrc-btn-group > button.mrc-btn.mrc-primary-button.mrc-ui-button-small"
		Then I wait for page loading but no more than 4 seconds
		And I click on element having id "react-tabs-2"
		Then I wait for page loading but no more than 2 seconds
		And I click on element having xpath "//*[@id="react"]/div/main/form/div[3]/button[2]"
	
		
#		Reject by CM
		
		Given I click on element having xpath "//*[@id="react"]/div/div/div/div[1]/ul/li[2]/a/img"
    Then I click on element having xpath "//*[@id="react"]/div/main/div/div[1]/div/div[2]/label/div"
    Then I wait for page loading but no more than 2 seconds
    Then I click on element having xpath "//*[@id="cf82e55f-1baa-4846-8cdd-65738ff2d561"]/div[1]/a/span/ul/li[2]/span[1]/p"
    And I click on element having id "react-tabs-0"
    And I click on element having id "react-tabs-2"
    And I click on element having id "react-tabs-4"
    And I click on element having id "react-tabs-6"
    And I click on element having id "react-tabs-8"
    And I click on element having id "react-tabs-10"
    And I click on element having id "react-tabs-12"
    And I click on element having id "react-tabs-14"
    And I click on element having id "react-tabs-16"
    And I click on element having id "react-tabs-18"
    And I click on element having id "react-tabs-16"
    And I click on element having id "react-tabs-14"
    And I click on element having id "react-tabs-12"
    And I click on element having id "react-tabs-10"
    And I click on element having id "react-tabs-8"
    And I click on element having id "react-tabs-6"
    And I click on element having id "react-tabs-4"
    And I click on element having id "react-tabs-2"
    And I click on element having id "react-tabs-0"
    And I click on element having id "react-tabs-2"
    And I click on element having id "mrc-error-button"
    
    #Approve less by CM
    
    #Given I click on element having xpath "//*[@id="react"]/div/div/div/div[1]/ul/li[2]/a/img"
    #Then I click on element having xpath "//*[@id="react"]/div/main/div/div[1]/div/div[2]/label/div"
    #Then I wait for page loading but no more than 2 seconds
    #Then I click on element having xpath "//*[@id="09946e01-c5ff-475e-a520-0ed4f27e152e"]/div[1]/a/span/ul/li[2]/span[1]/p"
    #
    #
#
  #	Then I wait for page loading but no more than 2 seconds
    #Given I click on element having id "react-tabs-4"
    #Then I wait for page loading but no more than 2 seconds  
   #	And I click on element having xpath "//*[@id="react-tabs-5"]/div/div/div/div[2]/table/tbody/tr[5]/td[8]/span"
   #	And I click on element having xpath "//*[@id="react-tabs-5"]/div/div/div/div[2]/table/tbody/tr[8]/td/div[2]/div[2]/div[1]/div[3]/div/span"
   #	Then I clear input field having css "#react-tabs-5 > div > div > div > div.mrc-ui-credit-tab-table-container.mrc-ui-grid-item > table > tbody > tr.mrc-ui-table-r.mrc-ui-table-r-form > td > div:nth-child(3) > div.mrc-ui-form-main-column > div.mrc-ui-card.mrc-ui-card-shadow > div:nth-child(2) > div > div > div > input"
    #Then I enter "20000" into input field having css "#react-tabs-5 > div > div > div > div.mrc-ui-credit-tab-table-container.mrc-ui-grid-item > table > tbody > tr.mrc-ui-table-r.mrc-ui-table-r-form > td > div:nth-child(3) > div.mrc-ui-form-main-column > div.mrc-ui-card.mrc-ui-card-shadow > div:nth-child(2) > div > div > div > input"  
#		And I click on element having id "react-tabs-14"
#		And I click on element having xpath "//*[@id="react-tabs-15"]/div/div[1]/button"
#		Then I enter "Approving less ammount of money, due to high risk" into input field having css "#react-tabs-15 > div > div.mt-5 > div > div.mrc-ui-modal > div > div > div.mrc-ui-input.clear-both > textarea"
#		And I click on element having xpath "//*[@id="react-tabs-15"]/div/div[1]/div/div[2]/div/div/div[2]/button[1]"
#		And I click on element having id "react-tabs-4"
#		Then I wait for page loading but no more than 2 seconds
#		And I click on element having xpath "//*[@id="mrc-approve-button"]"
#		Then I wait for page loading but no more than 2 seconds
#		And I click on element having xpath "//*[@id="react"]/div/div[1]/div/div[1]/ul/li[1]/a/img"
		
		#Approve less by HOT
		
#		Given I click on element having xpath "//*[@id="react"]/div/div/div/div[1]/ul/li[2]/a/img"
    #Then I click on element having xpath "//*[@id="react"]/div/main/div/div[1]/div/div[2]/label/div"
    #Then I wait for page loading but no more than 2 seconds
    #Then I click on element having xpath "//*[@id="7adabea9-7e2a-4827-b001-7421901b1a3f"]/div[1]/a/span/ul/li[2]/span[1]/p"
    #
    #
#
  #	Then I wait for page loading but no more than 2 seconds
    #Given I click on element having id "react-tabs-4"
#		And I click on element having xpath "//*[@id="mrc-approve-button"]"
#		Then I wait for page loading but no more than 2 seconds
#		And I click on element having xpath "//*[@id="react"]/div/div[1]/div/div[1]/ul/li[1]/a/img"
		
		Scenario: Customer search
		
		
		Given I click on element having xpath "//*[@id="react"]/div/main/div/div[1]/a[1]/label/h2"
    When I enter "23/44852" into input field having id "search-input"
    Then I click on element having xpath "/html/body/div/div/main/div/section[2]/ul/li[2]/a/div/h1"
    Then I wait for page loading but no more than 10 seconds

	


    
	
