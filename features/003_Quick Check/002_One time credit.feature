    
  Feature: One time credit QC

  Scenario: Customer search and submit request
  
    Given I click on element having xpath "//*[@id="react"]/div/main/div/div[1]/a[2]/label/h2"
    When I enter "15/108105" into input field having id "search-input"
    Then I click on element having xpath "//*[@id="react"]/div/main/div/section[2]/ul/li[2]/a/div"
    And I click on element having xpath "//*[@id="react"]/div/main/div/div[3]/div[2]/button"
    Then I wait for page loading but no more than 2 seconds
    
    
  Scenario: QC inbox
  
    Given I click on element having xpath "//*[@id="react"]/div/div/div/div[1]/ul/li[2]/a/img"
    Then I click on element having xpath "//*[@id="react"]/div/main/div/div[1]/div/div[2]/label/div"
    Then I wait for page loading but no more than 2 seconds
    Then I refresh page
    Then I wait for page loading but no more than 2 seconds
    Then I refresh page
    Then I click on link having partial text "Quick Check REJECTED"
    And I click on element having id "react-tabs-2"
		And I click on element having id "react-tabs-4"
    And I click on element having id "react-tabs-6"
    And I click on element having id "react-tabs-8"
    And I click on element having id "react-tabs-10"
    And I click on element having id "react-tabs-12"
    And I click on element having id "react-tabs-14"
    And I click on element having id "react-tabs-16"
    And I click on element having id "react-tabs-18"

    
    
    

    
    
    
    








	


    
	
