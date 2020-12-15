Feature: Reports check

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

      Given I click on element having xpath "//*[@id="react"]/div/div/div/div[1]/ul/li[1]/a/img"
    When element having xpath "//*[@id="react"]/div/main/div/div[1]/a[1]/label/h2" should be present 
    Then I click on link having partial text "Limit Check"
    Then I navigate back
    And element having xpath "//*[@id="react"]/div/main/div/div[1]/a[2]/label/h2" should be present 
    Then I click on link having partial text "Quick Check"
    Then I navigate back
    And element having xpath "//*[@id="react"]/div/main/div/div[1]/a[3]/label/h2" should be present 
    Then I click on link having partial text "Credit Correction"
   	Then I navigate back
   	And element having xpath "//*[@id="react"]/div/main/div/div[1]/a[4]/label/h2" should be present 
    Then I click on link having partial text "History"
   	Then I navigate back
   	And element having xpath "//*[@id="react"]/div/main/div/div[1]/a[5]/label/h2" should be present 
    Then I click on link having partial text "Inbox"
   	Then I navigate back
   	And element having xpath "//*[@id="react"]/div/main/div/div[1]/a[6]/label/h2" should be present 
    Then I click on link having partial text "Batch Update"
   	Then I navigate back
   	Then I click on element having xpath "//*[@id="react"]/div/div/div/div[1]/ul/li[2]/a/img"
    Then I navigate back
    Then I click on element having xpath "//*[@id="react"]/div/div/div/div[1]/ul/li[3]/a/img"
    Then I navigate back
    Then I click on element having xpath "//*[@id="react"]/div/div/div/div[1]/ul/li[4]/a/img"
    Then I navigate back
    Then I click on element having xpath "//*[@id="react"]/div/div/div/div[1]/ul/li[5]/a/img"
    Then I navigate back
    Then I click on element having xpath "//*[@id="react"]/div/div/div/div[1]/ul/li[6]/a/img"
    Then I navigate back
    Then I click on element having xpath "//*[@id="react"]/div/div/div/div[1]/ul/li[7]/a/img"
    Then I navigate back
