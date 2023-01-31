# customer-rewards-api
Customer Retail Rewards API

## Swagger UI path:
[http://localhost:8080//swagger-ui/index.html]()

### Available Test Customers
Three customers with customer id 1,2 and 3 are available for testing the service.
This data is loaded from `import.sql` file from the classpath during startup.

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
