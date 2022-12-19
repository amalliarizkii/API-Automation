Feature: Get Hourly Forecast

  Scenario Outline: Get Hourly Forecast with Postal Code
    Given Get hourly forecast with postal code <postal_code> using key "<key>"
    When Send request get hourly forecast
    Then Should return status code 200 OK
    And Get hourly forecast with postal code json schema validator
    Examples:
      | postal_code | key |
      | 28546 | 86eb0c93f440431fb6a43f23ee90fc28 |
