Feature: Wikipedia search functionality
@outline
Scenario Outline: Wikipedia Search Functionality Title Verification
Given User is on Wikipedia Home Page
When User types "<searchKey>" in the wiki search box
And User clicks wiki search button
Then User sees "<title>" is in the wiki title

  Examples: Test data for search functionality

    | searchKey    | title        |
    | Steve Jobs   | Steve Jobs   |
    | Ricky Martin | Ricky Martin |
    | Lady Gaga    | Lady Gaga    |
    | Lionel Messi | Lionel Messi |

  #option comman L for aligning pipes automaticly --> this is for mac