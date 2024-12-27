import requests
import json

url = "http://apilayer.net/api/live?access_key=3afda89335dda091e63492a7534798dd&source=USD&format=1"

response = requests.get(url)
data = response.text
print(data)
parsed = json.loads(data)


quotes = parsed["quotes"]

print(quotes)

csv_file = open(r'C:\CSVOP\CurrencyExchange.csv', "w")
csv_file.write("Curr_Code, USDXUNIT"+"\n") 
csv_file.close()

for country, rate in quotes.items():
    csv_file = open(r'C:\CSVOP\CurrencyExchange.csv', "a")
    csv_file.write(country[3:6] + "," + str(rate) +"\n")
    csv_file.close()