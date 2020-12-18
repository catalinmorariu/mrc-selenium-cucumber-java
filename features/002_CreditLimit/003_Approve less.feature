

Feature: CL approve less

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
    
    
	Credit details

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
	
		
    
    Approve less by CM
    
    Given I click on element having xpath "//*[@id="react"]/div/div/div/div[1]/ul/li[2]/a/img"
    Then I click on element having xpath "//*[@id="react"]/div/main/div/div[1]/div/div[2]/label/div"
    Then I wait for page loading but no more than 2 seconds
    Then I click on element having xpath "//*[@id="09946e01-c5ff-475e-a520-0ed4f27e152e"]/div[1]/a/span/ul/li[2]/span[1]/p"
    
    

  	Then I wait for page loading but no more than 2 seconds
    Given I click on element having id "react-tabs-4"
    Then I wait for page loading but no more than 2 seconds  
   	And I click on element having xpath "//*[@id="react-tabs-5"]/div/div/div/div[2]/table/tbody/tr[5]/td[8]/span"
   	And I click on element having xpath "//*[@id="react-tabs-5"]/div/div/div/div[2]/table/tbody/tr[8]/td/div[2]/div[2]/div[1]/div[3]/div/span"
   	Then I clear input field having css "#react-tabs-5 > div > div > div > div.mrc-ui-credit-tab-table-container.mrc-ui-grid-item > table > tbody > tr.mrc-ui-table-r.mrc-ui-table-r-form > td > div:nth-child(3) > div.mrc-ui-form-main-column > div.mrc-ui-card.mrc-ui-card-shadow > div:nth-child(2) > div > div > div > input"
    Then I enter "20000" into input field having css "#react-tabs-5 > div > div > div > div.mrc-ui-credit-tab-table-container.mrc-ui-grid-item > table > tbody > tr.mrc-ui-table-r.mrc-ui-table-r-form > td > div:nth-child(3) > div.mrc-ui-form-main-column > div.mrc-ui-card.mrc-ui-card-shadow > div:nth-child(2) > div > div > div > input"  
		And I click on element having id "react-tabs-14"
		And I click on element having xpath "//*[@id="react-tabs-15"]/div/div[1]/button"
		Then I enter "Approving less ammount of money, due to high risk" into input field having css "#react-tabs-15 > div > div.mt-5 > div > div.mrc-ui-modal > div > div > div.mrc-ui-input.clear-both > textarea"
		And I click on element having xpath "//*[@id="react-tabs-15"]/div/div[1]/div/div[2]/div/div/div[2]/button[1]"
		And I click on element having id "react-tabs-4"
		Then I wait for page loading but no more than 2 seconds
		And I click on element having xpath "//*[@id="mrc-approve-button"]"
		Then I wait for page loading but no more than 2 seconds
		And I click on element having xpath "//*[@id="react"]/div/div[1]/div/div[1]/ul/li[1]/a/img"
		
		Approve less by HOT
		
		Given I click on element having xpath "//*[@id="react"]/div/div/div/div[1]/ul/li[2]/a/img"
    Then I click on element having xpath "//*[@id="react"]/div/main/div/div[1]/div/div[2]/label/div"
    Then I wait for page loading but no more than 2 seconds
    Then I click on element having xpath "//*[@id="7adabea9-7e2a-4827-b001-7421901b1a3f"]/div[1]/a/span/ul/li[2]/span[1]/p"
    
    

  	Then I wait for page loading but no more than 2 seconds
    Given I click on element having id "react-tabs-4"
		And I click on element having xpath "//*[@id="mrc-approve-button"]"
		Then I wait for page loading but no more than 2 seconds
		And I click on element having xpath "//*[@id="react"]/div/div[1]/div/div[1]/ul/li[1]/a/img"
		
		Scenario: Customer search
		
		
		Given I click on element having xpath "//*[@id="react"]/div/main/div/div[1]/a[1]/label/h2"
    When I enter "23/44852" into input field having id "search-input"
    Then I click on element having xpath "/html/body/div/div/main/div/section[2]/ul/li[2]/a/div/h1"
    Then I wait for page loading but no more than 10 seconds

	


    
	
