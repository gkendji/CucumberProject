Feature: Search and Place the order for products
Scenario: Search experience for product search in both home and offers page


Given User is on GreenCart landing page
When user search for shortname "Tom" and extract atual name of product
Then  user searched for "Tom" shortname in offers page
And validate product name in offers page matches with Landing Page 