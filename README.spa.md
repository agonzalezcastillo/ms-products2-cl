# ms-products2-cl
[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

###### Leer en otro Idioma : [English/Inglés](https://github.com/agonzalezcastillo/ms-products2-cl/blob/master/README.md)
### Installation

- clonar proyecto desde https://github.com/agonzalezcastillo/ms-products2-cl.git
- moverse a la carpeta  donde fue clonado el proyecto
```sh
$ cd ms-products2-cl
```
-iniciar el proyecto con el siguiente comando
```sh
$ ./gradlew bootRun
```
- si todo esta ok, realizar la siguiente llamada POST con el body indicado al siguiente endpoint para obtener tu token
```sh
$ [POST] localhost:8080/token
{
	"userName": "supplier1",
	"id": 252253114,
	"role": "admin"
}
```

- si todo funciona, el sistema te retornará un token el cual podras usar como autenticacion, llamada ejemplo (listar productos)
```sh
[GET] localhost:8080/rest/product/
```
debes incluir el siguiente header 
```sh
key : Authorization
value : Token eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdXBwbGllcjEiLCJ1c2VySWQiOiIyNTIyNTMxMTQiLCJyb2xlIjoiYWRtaW4ifQ.TySCAXYGzlDdi6O6Y8xRpnh93OjbxHmC4h1RbmDk2KeSZJArL5ELusyKTcMM-JyDjCNmssdSij75fA79fiz7JA
```

- puedes obtener la **lista de productos** y sus propiedades realizando una solicitud GET al siguiente endpoint, incluyendo tu JWT como header de autorizacion
```sh
[GET] localhost:8080/rest/product/
```
- puedes **crear un nuevo proveedor** con sus productos realizando una solicitud POST al siguiente endpoint, incluyendo tu JWT como header de autorizacion
se adjunta payload/body de ejemplo, puedes crear la cantidad de productos que desees
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
##### NOTA:
###### - El sistema tiene la habilidad de reconocer si eres un proveedor registrado y si los productos que intentas crear ya existen, de ser asi, el sistema actualizara la cantidad de los productos existentes, y creará/registrará los nuevos 

- puedes **eliminar un proveedor y sus productos**  realizando la siguiente solicitud DELETE, incluyendo el id de proveedor como un parametro {supplierId} y tu JWT como header de autorizacion, retornará TRUE si el proveedor y sus productos fueron eliminados o una excepcion si el id de proveedor proporcionada no existe
```sh
[DELETE] localhost:8080/rest/supplier/{supplierId}
```
- puedes **eliminar un producto** realizando la siguiente solicitud DELETE, incluyendo el id del producto como un parametro {productId} y tu JWT como header de autorizacion, retornará TRUE si el producto fue eliminado o una excepcion si el id de producto proporcionado no existe
```sh
[DELETE] localhost:8080/rest/product/{productId}
```
- puedes **actualizar la cantidad de un producto** realizando la siguiente solicitud PUT, incluyendo el id del producto como un parametro {productId}, la cantidad que deseas setear {quantity} y tu JWT como header de autorizacion retornará TRUE si el producto fue actualizado o una excepcion si el id de producto proporcionado no existe
```sh
[PUT] localhost:8080/rest/product/{productId}?qty={quantity}
```







