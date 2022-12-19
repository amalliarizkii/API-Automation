Feature: Get Current Weather Data

  Scenario Outline: Get Current Weather with Value lan and lon
    Given Get current weather with value lat <lat> and lon <lon> using key "<key>"
    When Send request get current weather
    Then Should return status code 200 OK
    And Get current weather with value lan and lon json schema validator
    Examples:
    | lat | lon | key |
    | 40.730610 | -73.935242 | 86eb0c93f440431fb6a43f23ee90fc28 |

