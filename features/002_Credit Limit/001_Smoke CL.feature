Feature: Smoke CL

  Feature: MRC Login
  As a user I should able to login into MRC.
  Scenario: Prerequisites
    Given I want to test against "https://mrc-pp.metrosystems.net"
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
	When I enter "Please check again" into input field having xpath "/html/body/div[1]/div/main/div/div[4]/div[1]/div/section/div/div/div[2]/div/div/div[2]/textarea"
	And I click on element having xpath "//*[@id="react-tabs-1"]/div/section/div/div/div[2]/div/div/div[3]/button[1]"



















	


    
	
