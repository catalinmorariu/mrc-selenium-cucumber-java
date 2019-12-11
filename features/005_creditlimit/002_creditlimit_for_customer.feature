Feature: Credit limit for customer

  Scenario: Type customer
    Given I enter "39/22044" into input field having id "search-input"
    Then element having xpath "//section[@class='mrc-search-result']//a[@class='no-underline']/div/h2" should have text as "39/22044"
    And element having xpath "//section[@class='mrc-search-result']//li[@class='result-summary']/span" should have partial text as "RESULT"
    When I click on element having xpath "//section[@class='mrc-search-result']//a[@class='no-underline']/div/h2/../.."
    Then I wait for page loading but no more than 20 seconds

  Scenario: Credit limit status page
    Then element having xpath "//div[@class='customer-info']//div[@class='infos']/h2" should have text as "39/22044"
    And element having xpath "//div[@class='mrc-status-bar']/span" should have text as "Current Limit: €100"
    And element having xpath "//section[@class='mrc-info-row']/div[@class='infos']/h1" should have text as "Dr. Annette Leurs Sugarbird Cupcakes"
    And element having xpath "//section[@class='mrc-info-row']/div[@class='infos']/h2" should have text as "39/22044"
    And element having xpath "//div[@class='mrc-pre-checks']/p" should have text as "Pre-checks for 4 customers succeeded."
    And element having xpath "//div[@class='mrc-btn']/button" should have text as "REQUEST CREDIT"
    And element having xpath "//div[@class='recent-requests']/p" should have text as "CREDIT HISTORY"

  Scenario: Credit limit go to checks
    Given I click on element having xpath "//div[@class='customer-info']//section[@class='mrc-info-row']"
    Then I wait for page loading but no more than 20 seconds
    Then I navigate back
    Then I wait for page loading but no more than 20 seconds
    Then I click on element having class "mrc-primary-button"
    Then I wait for page loading but no more than 20 seconds

  Scenario: Credit limit page checks
    Then element having xpath "//div[@class='mrc-progress-bar']/section[@class='details']/span" should have text as "INITIALIZATION"
    And element having class "react-tabs__tab--selected" should have text as "CUSTOMER DETAILS"
    And element having id "react-tabs-0" should have text as "CUSTOMER DETAILS"
    And element having id "react-tabs-2" should have text as "CREDIT DETAILS"
    And element having id "react-tabs-4" should have text as "SALES"
    And element having id "react-tabs-6" should have text as "COMMENTS"
    And element having id "react-tabs-8" should have text as "ATTACHMENTS"
    And element having id "mrc-cancel-button" should have text as "CANCEL"
    And element having class "mrc-primary-button" should have text as "SUBMIT REQUEST"

  Scenario: Switch to German
    Given I select "de" option by text from dropdown having id "language-select"
    Then element having class "launchpad" should have attribute "alt" with value "Kreditportal"
    And element having class "limitcheck" should have attribute "alt" with value "Kundenprüfung"
    And element having class "quickcheck" should have attribute "alt" with value "Quick Check"
    And element having class "history" should have attribute "alt" with value "Historie"
    And element having class "inbox" should have attribute "alt" with value "Inbox"
    And element having xpath "//div[@class='mrc-progress-bar']/section[@class='details']/span" should have text as "INITIALISIERUNG"
    And element having class "react-tabs__tab--selected" should have text as "KUNDEN"
    And element having id "react-tabs-0" should have text as "KUNDEN"
    And element having id "react-tabs-2" should have text as "KREDIT"
    And element having id "react-tabs-4" should have text as "UMSATZ"
    And element having id "react-tabs-6" should have text as "KOMMENTARE"
    And element having id "react-tabs-8" should have text as "ANHÄNGE"
    And element having id "mrc-cancel-button" should have text as "ABBRECHEN"
    And element having class "mrc-primary-button" should have text as "ANFRAGE PRÜFEN"

  Scenario: Switch to Spanish
    Given I select "es" option by text from dropdown having id "language-select"
    Then element having class "limitcheck" should have attribute "alt" with value "Revisión de límite"
    And element having class "history" should have attribute "alt" with value "Histórico"
    And element having class "inbox" should have attribute "alt" with value "Inbox"
    And element having xpath "//div[@class='mrc-progress-bar']/section[@class='details']/span" should have text as "INICIAR"
    And element having class "react-tabs__tab--selected" should have text as "INFORMACIÓN DEL CLIENTE"
    And element having id "react-tabs-0" should have text as "INFORMACIÓN DEL CLIENTE"
    And element having id "react-tabs-2" should have text as "INFORMACIÓN DEL CRÉDITO"
    And element having id "react-tabs-4" should have text as "VENTAS"
    And element having id "react-tabs-6" should have text as "COMENTARIOS"
    And element having id "react-tabs-8" should have text as "ANEXOS"
#    And element having id "mrc-cancel-button" should have text as "ABBRECHEN"
    And element having class "mrc-primary-button" should have text as "Solicitud de crédito"

  Scenario: Switch back to English
    Given I select "en" option by text from dropdown having id "language-select"
    Then element having xpath "//div[@class='mrc-progress-bar']/section[@class='details']/span" should have text as "INITIALIZATION"
    And element having class "react-tabs__tab--selected" should have text as "CUSTOMER DETAILS"
    And element having id "react-tabs-0" should have text as "CUSTOMER DETAILS"
    And element having id "react-tabs-2" should have text as "CREDIT DETAILS"
    And element having id "react-tabs-4" should have text as "SALES"
    And element having id "react-tabs-6" should have text as "COMMENTS"
    And element having id "react-tabs-8" should have text as "ATTACHMENTS"
    And element having id "mrc-cancel-button" should have text as "CANCEL"
    And element having class "mrc-primary-button" should have text as "SUBMIT REQUEST"

  Scenario: Switching between tabs
    Given I click on element having id "react-tabs-2"
    Then I wait for page loading but no more than 20 seconds
    Then I click on element having id "react-tabs-4"
    Then I wait for page loading but no more than 20 seconds
    Then I click on element having id "react-tabs-6"
    Then I wait for page loading but no more than 20 seconds
    Then I click on element having id "react-tabs-8"
    Then I wait for page loading but no more than 20 seconds


  Scenario: Add comments
    Given I click on element having xpath "//div[@class='react-tabs']//li[text()='Comments']"
    And I click on element having xpath "//div[@class='react-tabs']//div[@class='mrc-comments']//textarea"
    Then I enter "my test comment" into input field having xpath "//div[@class='mrc-comments']//textarea"
    And I click on element having xpath "//div[@class='mrc-comments']/button[@class='mrc-secondary-button']"
    Then I enter "\\nmy test\\n comment" into input field having xpath "//div[@class='mrc-comments']//textarea"
    And I click on element having xpath "//div[@class='mrc-comments']/button[@class='mrc-secondary-button']"

  Scenario: Back to main limit check search page and reenter into created limit check request
    Given I click on element having class "limitcheck"
    Then I enter "39/22044" into input field having id "search-input"
    And element having xpath "//section[@class='mrc-search-result']//a[@class='no-underline']/div/h2" should have text as "39/22044"
    And element having xpath "//section[@class='mrc-search-result']//li[@class='result-summary']/span" should have partial text as "RESULT"
    Then I click on element having xpath "//section[@class='mrc-search-result']//a[@class='no-underline']/div/h2/../.."
    Then I wait for page loading but no more than 20 seconds

  Scenario: Customer status page for customer with existing request
    Then element having xpath "//div[@class='customer-info']//div[@class='infos']/h2" should have text as "39/22044"
    And element having xpath "//div[@class='mrc-status-bar']/span" should have text as "Current Limit: €100"
    And element having xpath "//section[@class='mrc-info-row']/div[@class='infos']/h1" should have text as "Dr. Annette Leurs Sugarbird Cupcakes"
    And element having xpath "//section[@class='mrc-info-row']/div[@class='infos']/h2" should have text as "39/22044"
    And element having xpath "//section[@class='mrc-info-row']/div[@class='icon']/p" should have text as "Edit"
    And element having xpath "//div[@class='mrc-pre-checks']/p" should have text as "The Pre-checks found 1 errors."
    And element having xpath "//div[@class='recent-requests']/p" should have text as "CREDIT HISTORY"

  Scenario: Customer status page for customer with existing request (in Spanish)
    Given I select "es" option by text from dropdown having id "language-select"
    Then element having xpath "//div[@class='customer-info']//div[@class='infos']/h2" should have text as "39/22044"
    And element having xpath "//div[@class='mrc-status-bar']/span" should have text as "Límite actual €100"
    And element having xpath "//section[@class='mrc-info-row']/div[@class='infos']/h1" should have text as "Dr. Annette Leurs Sugarbird Cupcakes"
    And element having xpath "//section[@class='mrc-info-row']/div[@class='infos']/h2" should have text as "39/22044"
    And element having xpath "//section[@class='mrc-info-row']/div[@class='icon']/p" should have text as "Editar"
    And element having xpath "//div[@class='mrc-pre-checks']/p" should have text as "El Pre-chequeo encontro 1 errores"
    And element having xpath "//div[@class='recent-requests']/p" should have text as "HISTORIAL DE CRÉDITO"

  Scenario: Customer status page for customer with existing request (in German)
    Given I select "de" option by text from dropdown having id "language-select"
    Then element having xpath "//div[@class='customer-info']//div[@class='infos']/h2" should have text as "39/22044"
    And element having xpath "//div[@class='mrc-status-bar']/span" should have text as "Kreditlimit: €100"
    And element having xpath "//section[@class='mrc-info-row']/div[@class='infos']/h1" should have text as "Dr. Annette Leurs Sugarbird Cupcakes"
    And element having xpath "//section[@class='mrc-info-row']/div[@class='infos']/h2" should have text as "39/22044"
    And element having xpath "//section[@class='mrc-info-row']/div[@class='icon']/p" should have text as "Bearbeiten"
    And element having xpath "//div[@class='mrc-pre-checks']/p" should have text as "1 Ergebnisse der Datenprüfungen:"
    And element having xpath "//div[@class='recent-requests']/p" should have text as "HISTORIE"

  Scenario: Customer status page for customer with existing request (back to English)
    Given I select "en" option by text from dropdown having id "language-select"
    Then element having xpath "//div[@class='customer-info']//div[@class='infos']/h2" should have text as "39/22044"
    And element having xpath "//div[@class='mrc-status-bar']/span" should have text as "Current Limit: €100"
    And element having xpath "//section[@class='mrc-info-row']/div[@class='infos']/h1" should have text as "Dr. Annette Leurs Sugarbird Cupcakes"
    And element having xpath "//section[@class='mrc-info-row']/div[@class='infos']/h2" should have text as "39/22044"
    And element having xpath "//section[@class='mrc-info-row']/div[@class='icon']/p" should have text as "Edit"
    And element having xpath "//div[@class='mrc-pre-checks']/p" should have text as "The Pre-checks found 1 errors."
    And element having xpath "//div[@class='recent-requests']/p" should have text as "CREDIT HISTORY"
    And I wait for page loading but no more than 20 seconds

  Scenario: Cancel the request
    Given I click on element having xpath "//div[@class='pending-request-info']//section[@class='mrc-info-row']"
    Then I wait for page loading but no more than 20 seconds
    And element having xpath "//div[@class='mrc-progress-bar']/section[@class='details']/span" should have text as "INITIALIZATION"
    And element having class "react-tabs__tab--selected" should have text as "CUSTOMER DETAILS"
    And element having id "react-tabs-0" should have text as "CUSTOMER DETAILS"
    And element having id "react-tabs-2" should have text as "CREDIT DETAILS"
    And element having id "react-tabs-4" should have text as "SALES"
    And element having id "react-tabs-6" should have text as "COMMENTS"
    And element having id "react-tabs-8" should have text as "ATTACHMENTS"
    And element having id "mrc-cancel-button" should have text as "CANCEL"
    And element having class "mrc-primary-button" should have text as "SUBMIT REQUEST"
    And I click on element having id "mrc-cancel-button"
    And I wait for page loading but no more than 20 seconds


   # Then I wait for page loading but no more than 20 seconds
   # And element having xpath "//div[@class='mrc-detail']/h2" should have text as "Quick Check requested."