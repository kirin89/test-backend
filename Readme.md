Test project for Genting

This simple project contains 2 APIs:

1. To list all currencies
/api/v1/currency/<br />
e.g. <br />
[{"name":"USD","buyRate":1.3392,"sellRate":1.3574},{"name":"HKD","buyRate":0.1738,"sellRate":0.1698}]

2. To convert a currency
/api/v1/currency/{currencyName}/{Action}/{Amount}<br />
e.g.<br />
{"action":"sell","baseCurrency":"SGD","convertedCurrency":"HKD","baseAmount":200.0,"convertedAmount":1177.86,"suggestedBaseAmount":203.76,"suggestedConvertedAmount":1200}
<br /><br />suggestedBaseAmount and suggestedConvertedAmount would be 0 for buy action