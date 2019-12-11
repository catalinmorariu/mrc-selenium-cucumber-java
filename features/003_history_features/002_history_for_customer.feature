Feature: History for customer

  Scenario: Type customer
    Given I enter "15/1222" into input field having id "search-input"
    Then element having xpath "//section[@class='mrc-search-result']//a[@class='no-underline']/div/h2" should have text as "15/1222"
    And element having xpath "//section[@class='mrc-search-result']//li[@class='result-summary']/span" should have partial text as "RESULT"
    When I click on element having xpath "//section[@class='mrc-search-result']//a[@class='no-underline']/div/h2/../.."
    Then I wait for page loading but no more than 20 seconds

  Scenario: Check last record
    When I click on element having class "mrc-request-details"
    Then I wait for page loading but no more than 20 seconds
    Then element having class "m-tabPanel-tab-selected" should have text as "CUSTOMER DETAILS"
    And element having id "customer-data-trigger-tab" should have text as "CUSTOMER DETAILS"
    And element having id "credit-data-trigger-tab" should have text as "CREDIT DETAILS"
    And element having id "sales-trigger-tab" should have text as "SALES"
    And element having id "payments-trigger-tab" should have text as "SAP DATA"
    And element having id "scores-trigger-tab" should have text as "SCORING"
    And element having id "strategy-trigger-tab" should have text as "STRATEGY"
    And element having id "comments-trigger-tab" should have text as "COMMENTS"
    And element having id "attachments-trigger-tab" should have text as "ATTACHMENTS"
    And element having id "audit-trail-trigger-tab" should have text as "AUDIT TRAIL"

  Scenario: Switch to German
    When I select "de" option by text from dropdown having name "language"
    Then element having class "m-tabPanel-tab-selected" should have text as "KUNDEN"
    And element having id "customer-data-trigger-tab" should have text as "KUNDEN"
    And element having id "credit-data-trigger-tab" should have text as "KREDIT"
    And element having id "sales-trigger-tab" should have text as "UMSATZ"
    And element having id "payments-trigger-tab" should have text as "SAP DATEN"
    And element having id "scores-trigger-tab" should have text as "SCORING"
    And element having id "strategy-trigger-tab" should have text as "STRATEGIE"
    And element having id "comments-trigger-tab" should have text as "KOMMENTARE"
    And element having id "attachments-trigger-tab" should have text as "ANHÄNGE"
    And element having id "audit-trail-trigger-tab" should have text as "REVISIONSDATEN"

  Scenario: Switch to Spanish
    When I select "es" option by text from dropdown having name "language"
    Then element having class "m-tabPanel-tab-selected" should have text as "INFORMACIÓN DEL CLIENTE"
    And element having id "customer-data-trigger-tab" should have text as "INFORMACIÓN DEL CLIENTE"
    And element having id "credit-data-trigger-tab" should have text as "INFORMACIÓN DEL CRÉDITO"
    And element having id "sales-trigger-tab" should have text as "VENTAS"
    And element having id "payments-trigger-tab" should have text as "PAGOS"
    And element having id "scores-trigger-tab" should have text as "SCORING"
    And element having id "strategy-trigger-tab" should have text as "ESTRATEGIA"
    And element having id "comments-trigger-tab" should have text as "COMENTARIOS"
    And element having id "attachments-trigger-tab" should have text as "ANEXOS"
    And element having id "audit-trail-trigger-tab" should have text as "SEGUIMIENTO DE APROBACIÓN"

  Scenario: Switch back to English
    When I select "en" option by text from dropdown having name "language"
    Then element having class "m-tabPanel-tab-selected" should have text as "CUSTOMER DETAILS"
    And element having id "credit-data-trigger-tab" should have text as "CREDIT DETAILS"
    And element having id "sales-trigger-tab" should have text as "SALES"
    And element having id "payments-trigger-tab" should have text as "SAP DATA"
    And element having id "scores-trigger-tab" should have text as "SCORING"
    And element having id "strategy-trigger-tab" should have text as "STRATEGY"
    And element having id "comments-trigger-tab" should have text as "COMMENTS"
    And element having id "attachments-trigger-tab" should have text as "ATTACHMENTS"
    And element having id "audit-trail-trigger-tab" should have text as "AUDIT TRAIL"