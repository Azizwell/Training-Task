user-service
для получение пользователи с компаниями:

method: GET
http://localhost:8080/user-service/users/users-company

создание пользователя

method: POST
http://localhost:8080/user-service/users
body:
{
"firstName": "",
"lastName": "",
"phone": ""
}

изменит существующий пользователь

method: PUT
http://localhost:8080/user-service/users
body:
{
"id": 1,
"firstName": "",
"lastName": "",
"phone": ""
}

удаление пользователя

method: DELETE
http://localhost:8080/user-service/users/7

<----------------------------------------------------------------------------------------------->

company-service

для получение компании с пользователями:

method: GET
http://localhost:8080/company-service/companies/company-users

создание компания

method: POST
http://localhost:8080/company-service/companies
body:
{
"name": "",
"budget": 200.0
}

изменит существующий компанию

method PUT
http://localhost:8080/company-service/companies
body:
{
"id": 8,
"name": "",
"budget": 3.5
}

удаление компание
method: DELETE
http://localhost:8080/company-service/companies/5





