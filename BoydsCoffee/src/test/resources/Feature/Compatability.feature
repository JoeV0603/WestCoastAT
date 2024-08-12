Feature: Compatibility Testing

  Scenario: Cross browser compatibility on Chrome
    Given I open the browser Chrome
    When I navigate to the website
    Then the website should load correctly

  Scenario: Cross browser compatibility on Edge
    Given I open the browser Edge
    When I navigate to the website
    Then the website should load correctly1

  Scenario: Cross browser compatibility on Firefox
    Given I open the browser Firefox
    When I navigate to the website
    Then the website should load correctly2

  Scenario: Operating system compatibility on Windows
    Given I open the browser Chrome
    When I navigate to the website on Windows
    Then the website should load correctly

  Scenario: Screen resolution compatibility on 1920x1080
    Given I open the browser Chrome
    When I set screen resolution to 1920x1080
    Then the website should display correctly
    
    Scenario: Screen resolution compatibility on 1440x900
  Given I open the browser Chrome
  When I set screen resolution to 1440x900
  Then the website should display correctly

  Scenario: Screen resolution compatibility on 1366x768
    Given I open the browser Chrome
    When I set screen resolution to 1366x768
    Then the website should display correctly

  Scenario: Screen resolution compatibility on 1024x768
    Given I open the browser Chrome
    When I set screen resolution to 1024x768
    Then the website should display correctly
