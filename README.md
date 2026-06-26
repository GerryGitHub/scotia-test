To test the two end points

Request Url: http://localhost:8080/api/pet/1000003
Method: GET
Request Headers:
{
  "Accept": "*/*"
}

Request Url: http://localhost:8080/api/pet
Method: POST
Request Headers:
{
  "Accept": "*/*",
  "Content-Type": "application/json"
}

Request Body:
{
  "id": 10000030,
  "name": "testingPet1",
  "status": "available"
}
