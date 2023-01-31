# customer-rewards-api
Customer Retail Rewards API

## Swagger UI path:
swagger-ui/index.html

---
Curls for supported API calls
### Save Customer
`curl --location --request POST 'localhost:8080/v1/api/customer' \
--header 'Content-Type: application/json' \
--data-raw '    {"customerName":"Foo Bar"}'`

### Save Transaction
`curl --location --request POST 'localhost:8080/v1/api/transaction/customer/1' \
--header 'Content-Type: application/json' \
--data-raw '    {"transactionDate":"2023-01-01",
"transactionAmount":122.0}'`

### Get Total Reward Points
`curl --location --request GET 'localhost:8080/v1/api/reward/customer/1/totalPoints'`

### Get Monthly Rewards
`curl --location --request GET 'localhost:8080/v1/api/reward/customer/1/monthlyReport'`
