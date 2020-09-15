Feature: Reports check

  Scenario: Prerequisites
  Given I want to test against "https://mrc-pp.metrosystems.net/"
  And I want to use user "catalin.morariu@metrosystems.net" with password "Sindo.0744388!"
  And I want to use default timeout 20 seconds for each operation

  Scenario: I login with valid credential
  Given I go to the host
  When I enter user into input field having id "user_id"
  And I enter password into input field having id "password"
  When I click on element having id "submit"
  Then I wait for page loading but no more than 20 seconds
      
  Scenario: Rep
  Then element having xpath "//*[@id="react"]/div/main/div/div[1]/a[7]/label/h2" should be present 
  When I click on element having xpath "//*[@id="react"]/div/main/div/div[1]/a[7]/label/h2"
  Then element having xpath "//*[@id="react"]/div/main/div/div/div/div/div[2]/div/div[1]/a/div/img" should be present
  Then element having xpath "//*[@id="react"]/div/main/div/div/div/div/div[2]/div/div[2]/a/h3" should be present
  Then element having xpath "//*[@id="react"]/div/main/div/div/div/div/div[2]/div/div[3]/a/h3" should be present
  Then element having xpath "//*[@id="react"]/div/main/div/div/div/div/div[2]/div/div[4]/a/h3" should be present
  Then element having xpath "//*[@id="react"]/div/main/div/div/div/div/div[2]/div/div[5]/a/h3" should be present
  And I click on element having xpath "//*[@id="react"]/div/main/div/div/div/div/div[2]/div/div[2]/a/h3"
  Then I navigate back
  And I click on element having xpath "//*[@id="react"]/div/main/div/div/div/div/div[2]/div/div[3]/a/h3"
  Then I navigate back
	And I click on element having xpath "//*[@id="react"]/div/main/div/div/div/div/div[2]/div/div[4]/a/h3"
	Then I navigate back
  And I click on element having xpath "//*[@id="react"]/div/main/div/div/div/div/div[2]/div/div[5]/a/h3"
  Then I navigate back
  Then I refresh page
  Then I navigate back
  Then I refresh page
 
 
 
