user-service
для получение пользователи с компаниями:

method: GET
http://localhost:8080/user-service/users/users-company/4

создание пользователя

method: POST
http://localhost:8080/user-service/users
body:
{
"firstName": "",
"lastName": "",
"phone": "",    
"companyId": 2
}

изменит существующий пользователь

method: PUT
http://localhost:8080/user-service/users
body:
{
"id": 1,
"firstName": "",
"lastName": "",
"phone": "",
"companyId": 2
}

удаление пользователя

method: DELETE
http://localhost:8080/user-service/users/7

<----------------------------------------------------------------------------------------------->

company-service

для получение компании с пользователями:

method: GET
http://localhost:8080/company-service/companies/company-users/1

создание компания

method: POST
http://localhost:8080/company-service/companies
body:
{
"name": "",
"budget": 200.0,
"userIds": [6,7,8]
}

изменит существующий компанию

method PUT
http://localhost:8080/company-service/companies
body:
{
"id": 8,
"name": "",
"budget": 3.5
"userIds": [6,7,8]
}

удаление компание
method: DELETE
http://localhost:8080/company-service/companies/5





