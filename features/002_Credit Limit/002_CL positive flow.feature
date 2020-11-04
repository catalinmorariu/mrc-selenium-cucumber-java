    
  Feature: Credit Limit positive flow

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
    And I click on element having xpath "//*[@id="react"]/div/main/form/div[3]/button[2]"
    
   

  Scenario: Credit details

    Given I click on element having xpath "//*[@id="react"]/div/main/form/div[3]/button[2]"
    Then I wait for page loading but no more than 2 seconds
    Given I click on element having xpath "//*[@id="react-tabs-3"]/div/div/div/div[2]/table/tbody/tr[4]/td[6]/span"
    When I click on element having xpath "//*[@id="react-tabs-3"]/div/div/div/div[2]/table/tbody/tr[6]/td/div[2]/div[2]/div[1]/div[2]/div/span"
    When I enter "255000" into input field having xpath "//*[@id="react-tabs-3"]/div/div/div/div[2]/table/tbody/tr[6]/td/div[2]/div[2]/div[2]/div[1]/div/div/div/input"
    When I enter "15" into input field having id ""
    Given I click on element having xpath "//*[@id="react-tabs-3"]/div/div/div/div[2]/table/tbody/tr[6]/td/div[2]/div[2]/div[2]/div[1]/div/div/div"
    And I click on element having xpath "//*[@id="react"]/div/main/form/div[3]/button[2]"
    
    
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
    And I click on element having id "mrc-approve-button"
    
    Scenario: HALJ approval
  
    Given I click on element having xpath "//*[@id="react"]/div/div/div/div[1]/ul/li[2]/a/img"
    Then I click on element having xpath "//*[@id="react"]/div/main/div/div[1]/div/div[2]/label/div"
    Then I wait for page loading but no more than 2 seconds
    Then I click on element having xpath "//*[@id="9c637263-0179-4d22-ac52-715ccb0fa429"]/div[1]/a/span/ul/li[2]/span[1]/p"
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
    And I click on element having id "mrc-approve-button"
    
    
    
    Scenario: HOT approval
  
    Given I click on element having xpath "//*[@id="react"]/div/div/div/div[1]/ul/li[2]/a/img"
    Then I click on element having xpath "//*[@id="react"]/div/main/div/div[1]/div/div[2]/label/div"
    Then I wait for page loading but no more than 2 seconds
    Then I click on element having xpath "//*[@id="7d939f0c-f030-46b7-9c30-3750e7b6198b"]/div[1]/a/span/ul/li[2]/span[1]/p"
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
    And I click on element having id "mrc-approve-button"
    
    
    Scenario: CFO approval
  
    Given I click on element having xpath "//*[@id="react"]/div/div/div/div[1]/ul/li[2]/a/img"
    Then I click on element having xpath "//*[@id="react"]/div/main/div/div[1]/div/div[2]/label/div"
    Then I wait for page loading but no more than 2 seconds
    Then I click on element having xpath "//*[@id="8bda4f6c-78f9-4b85-9da0-dfec782b80c6"]/div[1]/a/span/ul/li[2]/span[1]/p"
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
    And I click on element having id "mrc-approve-button"
    
    
    
    Scenario: CEO approval
  
    Given I click on element having xpath "//*[@id="react"]/div/div/div/div[1]/ul/li[2]/a/img"
    Then I click on element having xpath "//*[@id="react"]/div/main/div/div[1]/div/div[2]/label/div"
    Then I wait for page loading but no more than 2 seconds
    Then I click on element having xpath "//*[@id="09e94b7b-2b4b-44a2-8887-38d2f5db6803"]/div[1]/a/span/ul/li[2]/span[1]/p"
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








	


    
	
