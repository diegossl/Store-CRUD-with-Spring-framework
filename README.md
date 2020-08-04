# Store CRUD with Spring framework

Design of a CRUD for a beauty products store.

## Setup

For the project to be configured it is recommended to use the Eclipse IDE so that when opening the project the dependencies contained in the **pom.xml** file are automatically downloaded.

To execute the project, you must have installed JDK from version 8 onwards. And also the JRE version 1.8. 
You must also configure the MongoDB database with a connection string purchased from the following website:

[https://www.mongodb.com](https://www.mongodb.com)

With the connection string in hand just add to the **application.properties** file. You must also configure the email credentials that are in the same file.

## Use

To start the server, just type the following command in the terminal:

```bash
./mvnw spring-boot:run
```

The API is now ready to be used at the address:

[https://localhost:3000](https://localhost:3000)

## Examples:

**POST** /products/register
```bash
[{
	"name": "Example",
	"description": "Example Bla bla bla ",
	"quantity": 10,
	"price": "9.90"
}]
```

**GET** /products/list
```bash
[
  {
    "id": "5f282fdf2193df2cab6e3b00",
    "name": "Example",
    "description": "Example Bla bla bla ",
    "quantity": 10,
    "price": "9.90"
  }
]
```

**GET** /products/5f282fdf2193df2cab6e3b00
```bash
[
  {
    "id": "5f282fdf2193df2cab6e3b00",
    "name": "Example",
    "description": "Example Bla bla bla ",
    "quantity": 10,
    "price": "9.90"
  }
]
```

**PUT** /products/update/5f282fdf2193df2cab6e3b00
```bash
[
  {
    "name": "Other Example",
    "description": "Other Example Bla bla bla ",
    "quantity": 20,
    "price": "19.90"
  }
]
```

**DELETE** /products/delete/5f282fdf2193df2cab6e3b00
```bash
Produto apagado com suceso.
```

**POST** /purchase/sendPurchaseOrder
```bash
{
	"buyerName": "Pessoa",
	"buyerPhone": "(00) 00000-00000",
	"productList": [
		{
			"name": "Example",
			"description": "Example Bla bla bla ",
			"price": "4.90",
			"quantityPurchased": 5
  	},
		{
			"name": "Example 2",
			"description": "Example 2 Bla bla bla ",
			"price": "14.90",
			"quantityPurchased": 2
		},
		{
			"name": "Example 3",
			"description": "Example 3 Bla bla bla ",
			"price": "9.90",
			"quantityPurchased": 3
		}
	]
}
```

## License

MIT
