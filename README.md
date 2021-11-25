# Sakila-Video-club
Proyecto Final ing-soft
Pruebas realizadas en Postman:
{
	"info": {
		"_postman_id": "57c551c5-f1de-4cca-a34e-8fa2333d50a7",
		"name": "Pruebas",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "http://localhost:8080/main/1",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/main/1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"main",
						"1"
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/customer",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"customerId\" : 603,\r\n    \"storeId\" : 1,\r\n    \"firstName\" : \"Prueba2\",\r\n    \"lastName\" : \"Sistema\",\r\n    \"email\" : \"PruebaSistema@ucb.bo\",\r\n    \"addressId\" : 600,\r\n    \"active\":1\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/customer",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"customer"
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/rental",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"rentalId\": 1,\r\n    \"inventoryId\": 1,\r\n    \"customerId\": 1,\r\n    \"staffId\": 1\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/rental",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"rental"
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/payment",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"paymentId\":1,\r\n    \"customerId\": 1,\r\n    \"staffId\": 1,\r\n    \"rentalId\": 1,\r\n    \"amount\": \"2.1\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/payment",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"payment"
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/address",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"addresId\":1,\r\n    \"address\":\"calle siempre viva\",\r\n    \"address2\":\"\",\r\n    \"district\":\"Springfield\",\r\n    \"city\":1,\r\n    \"postalCode\":\"+591\",\r\n    \"phone\":\"70656565\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/address",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"address"
					]
				}
			},
			"response": []
		}
	]
}
