# ms-products2-cl

###### Read this in another language : [Spanish/español](https://github.com/agonzalezcastillo/ms-products2-cl/blob/master/README.spa.md)
### Installation

- clone the project from https://github.com/agonzalezcastillo/ms-products2-cl.git
- move to the folder where the project was cloned 
```sh
$ cd ms-products2-cl
```
-start the project with the following command
```sh
$ ./gradlew bootRun
```
- if everything went ok, you should be able to make a get call to the POST token endpoint **for obtaining your JWT** with the next payload/body (example data )
```sh
$ [POST] localhost:8080/token
{
	"userName": "supplier1",
	"id": 252253114,
	"role": "admin"
}
```

- if everything went ok, you should be able to make a get call to the get products endpoint
```sh
[GET] localhost:8080/rest/product/
```
with the following header , example token (copy and paste the response from the token endpoint after the "Token" string)
```sh
key : Authorization
value : Token eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdXBwbGllcjEiLCJ1c2VySWQiOiIyNTIyNTMxMTQiLCJyb2xlIjoiYWRtaW4ifQ.TySCAXYGzlDdi6O6Y8xRpnh93OjbxHmC4h1RbmDk2KeSZJArL5ELusyKTcMM-JyDjCNmssdSij75fA79fiz7JA
```

- you can obtain the **list of products** and his properties making a get request to the next endpoint including your JWT as an Authorization Header
```sh
[GET] localhost:8080/rest/product/
```
- you can **create a new supplier** with his products making a POST request to the following endpoint including your JWT as an Authorization Header with the indicated payload (example), you can store any products that you want
```sh
[POST] localhost:8080/rest/supplier/
{
	"id": 252253114,
	"name":"supplier 6",
	"products": [
		{
			"name":"Bicicleta trek",
			"description": "rin 54",
			"quantity":1,
			"price":650.36,
			"type":"MTB"
		},
		{
			"name":"Bicicleta Upland",
			"description": "rin 65",
			"quantity":1,
			"price":650.36,
			"type":"MTB"
		},
		{
			"name":"Bicicleta asd",
			"description": "rin 48",
			"quantity":1,
			"price":650.36,
			"type":"MTB"
		}
		]
}
```
##### NOTE:
###### - the system have the ability to recognize if you are a registered supplier and if the products that you are trying to create are already registered, so it will update the quantity of the existing equal products and it'll store/create the new ones

- for **deleting a supplier and his products** you can make the next DELETE request including your JWT as an Authorization Header it will return TRUE if the supplier was deleted or a Exception if the supplier id doesn't exists
```sh
[DELETE] localhost:8080/rest/supplier/{supplierId}
```
- for **deleting a product** you can make the next DELETE request including your JWT as an Authorization Header it will return TRUE if the product was deleted or a Exception if the supplier id doesn't exists
```sh
[DELETE] localhost:8080/rest/product/{productId}
```
- for **updating a product quantity** you can make the next PUT request including your JWT as an Authorization Header it will return TRUE if the product quantity was updated or a Exception if the product with the given id doesn't exists
```sh
[PUT] localhost:8080/rest/product/{productId}?qty={quantity}
```







