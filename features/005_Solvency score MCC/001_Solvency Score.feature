
Feature: Solvency Score

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
      
  Scenario: Solvency score test
  Given I click on element having xpath "//*[@id="react"]/div/main/div/div[1]/a[1]/label/h2"
  When I enter "23/62009" into input field having id "search-input"
  Then I click on element having xpath "/html/body/div/div/main/div/section[2]/ul/li[2]/a/div/h1"
  Then I wait for page loading but no more than 20 seconds
  
  Then I click on element having xpath "//*[@id="react"]/div/div/div/div[1]/ul/li[2]/a/img"
  Then I click on element having xpath "//*[@id="react"]/div/main/div/div[1]/div/div[2]/label/div"
  Then I click on element having xpath "//*[@id="29bdaa45-a55a-40e0-84d1-30b9cdb98f99"]/div[1]/a/span/ul/li[2]/span[1]"
	
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
	And I click on element having id "react-tabs-8"
	And I click on element having id "addScore"
	
	Given I select "MCC Score" option by text from dropdown having id "selectagency"
	When I enter "2" into input field having id "inputcustomerid"
	When I enter "3" into input field having id "inputscore"
	Then I enter "8000" into input field having id "inputmaxlimit"
	#And I click on element having id "addScore"
	
	And I click on element having id "react-tabs-0"
	And I click on element having id "react-tabs-14"
	Then I wait for page loading but no more than 5 seconds
	And I click on element having xpath "//*[@id="react-tabs-15"]/div/div[1]/button"
	
	
	#When I enter "For testing purposes only" into input field having xpath "/html/body/div[1]/div/main/div/div[4]/div[8]/div/div[2]/div/textarea"
	And I click on element having xpath "//*[@id="react-tabs-15"]/div/div[1]/div/div[2]/div/div/div[2]/button[2]"
	And I click on element having id "react-tabs-0"
	
	And element having xpath "//*[@id="react-tabs-1"]/div/div[3]/section[2]/div[2]/div[1]/div[2]/span[1]/span" should have class "t-text t-color-green t-size-5" with value "Good"
	
