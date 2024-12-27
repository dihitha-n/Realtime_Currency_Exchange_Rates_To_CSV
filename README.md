# Real-time Currency Exchange Rates To CSV
This project allows you to fetch real-time currency exchange rates from an API and save the data in a CSV file. The exchange rates are retrieved from the **apilayer.net** API, and the data is processed and written into a CSV file. This can be used for business intelligence reporting or any system that requires real-time currency rate information

## Features
- Fetches real-time currency exchange rates from the **apilayer.net** API.
- Saves the exchange rate data for all currencies against USD in a CSV file.
- Easy-to-use solution for business intelligence reporting purposes.

## Script Overview
- **Fetches Exchange Rates:** The script sends an HTTP GET request to the API endpoint using the requests library to retrieve real-time exchange rates.
- **Parses the Response:** The JSON response is parsed to extract the exchange rates.
- **Writes Data to CSV:** The script processes the rates and writes them into a CSV file with the currency code and its corresponding rate against USD.

## API Key Setup
To fetch real-time currency exchange rates, you'll need an API key from apilayer.net. You can sign up and get your API key from apilayer.net.
<br>Replace the access_key parameter in the url variable with your personal API key:

url = "http://apilayer.net/api/live?access_key=YOUR_API_KEY&source=USD&format=1"
