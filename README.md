# School Microservices (Java Springboot - Docker)
![Untitled Diagram drawio (1)](https://github.com/Alhuzsyam/school-microservices/assets/64511435/963c120d-6c13-4175-b003-c2d05ac4ab30)

## Introduction

This application is a school management system that aims to track schools, students, and their achievements. It consists of 5 interconnected services:

1. **api-gateway-service**
2. **student-service**
3. **school-service**
4. **achievement-service**
5. **eureka-service-discovery**

Each service serves a distinct purpose, with the Eureka service facilitating communication between them. Eureka Server is a service registry server in the Netflix OSS (Open Source Software) suite. It provides service discovery for microservices in a distributed environment by maintaining a registry of available microservices. This allows client microservices to discover and communicate with each other.

### API Gateway

An API Gateway is an intermediary that sits between your microservices and the client applications that consume them. It acts as a single entry point for all API requests, providing a unified interface for your microservices and simplifying the client-side architecture.

Benefits of using an API Gateway include:

- **Routing:** Directs requests to the appropriate microservice based on the request URL or other attributes.
- **Load Balancing:** Distributes incoming requests across multiple instances of a microservice to improve reliability and availability.
- **Caching:** Caches frequently requested data to reduce load on the microservices and improve performance.
- **Security:** Provides authentication and authorization for incoming requests, securing the microservices.
- **Monitoring:** Offers monitoring and logging for all API requests, facilitating issue diagnosis and performance monitoring.

Overall, an API Gateway provides a centralized and efficient way to manage access to your microservices, improving reliability, security, and performance.

## Getting Started

1. Ensure that your PC has Docker and Docker Compose installed.
2. Clone this repository.
3. Navigate to the directory containing the files.
4. Run the command `docker-compose up -d`.
5. If Docker is unavailable, manually set up the services on your local computer.
6. Install OpenJDK-17 and Apache Maven 3.8.6 on your computer.
7. After installation, open all services and run the command `mvn springboot:run`. This command is used to run the Spring Boot Java services.
8. Setup Finish
9. NB: Pay attention to the use of ports for api endpoints because they have differences between services that are setup in docker and on the local pc.
10. NB : You can check the port at application.properties

# API Documentation

## School Service

**Add New School**

**Method:** POST  

**API Endpoint:** `http://localhost:18087/school`

**Request Body:**
```json
{
    "schoolName": "SMKN 1 Malang",
    "location": "MALANG",
    "principalName": "Mr.JATMIKO"
}
```
**Response:**

```json
{
    "id": 352,
    "schoolName": "SMKN 1 Malang",
    "location": "MALANG",
    "principalName": "Mr.JATMIKO"
}
```
**Get All Schools**

**Method:** GET 

**API Endpoint:** `http://localhost:18087/school`

**Response:**
```json
[
    {
        "id": 202,
        "schoolName": "SMK 12 JAKARTA",
        "location": "JAKARTA",
        "principalName": "Mrs.Brad"
    },
    {
        "id": 252,
        "schoolName": "SMK 10 JAKARTA",
        "location": "JAKARTA",
        "principalName": "Mr.Brad"
    }
]
```
**Get Spesifict Schools**

**Method:** GET

**API Endpoint:** `http://localhost:18087/school/302`

**Response:**
```json
{
	"id": 302,
	"schoolName": "SMK 11 JAKARTA",
	"location": "JAKARTA",
	"principalName": "Mr.Alhuz"
}
```
## Student Service
**Add New Student**

**Method:** POST

**API Endpoint:** `http://localhost:18087/student`

**Request Body**
```json
{
	"nisn": 456,
	"name": "ALFI",
	"age": 17,
	"gender": "LAKI-LAKI",
	"schoolId": 302,
	"major": "IPA",
	"noIjazah": "098765",
	"statusAkhir": "LULUS",
	"statusAwal": "SISWA BARU"
}
```
**Response**
```json
{
	"nisn": 456,
	"name": "ALFI",
	"age": 17,
	"gender": "LAKI-LAKI",
	"schoolId": 302,
	"major": "IPA",
	"noIjazah": "098765",
	"statusAkhir": "LULUS",
	"statusAwal": "SISWA BARU"
}
```
**Get all Student**

**Method:** GET

**API Endpoint:** `http://localhost:18087/student`

**Response**
```json
[
	{
		"nisn": "123",
		"name": "NASRUL",
		"age": 17,
		"gender": "MALE",
		"schoolId": 202,
		"major": "IPA",
		"statusAwal": "SISWA BARU",
		"statusAkhir": "LULUS",
		"noIjazah": "0192810IQO"
	},
	{
		"nisn": "321",
		"name": "ALHUZ",
		"age": 17,
		"gender": "LAKI-LAKI",
		"schoolId": 252,
		"major": "IPA",
		"statusAwal": "SISWA BARU",
		"statusAkhir": "LULUS",
		"noIjazah": "098765"
	}
]
```

**Get spesifict Student**

**Method:** GET

**API Endpoint:** `http://localhost:18087/student/321`

**Response**
```json
{
	"nisn": "321",
	"name": "ALHUZ",
	"age": 17,
	"gender": "LAKI-LAKI",
	"major": "IPA",
	"school": {
		"id": 252,
		"schoolName": "SMK 10 JAKARTA",
		"location": "JAKARTA",
		"principalName": "Mr.Brad"
	},
	"statusAwal": "SISWA BARU",
	"statusAkhir": "SISWA BARU",
	"noIjazah": "098765"
}
```

## Acheivement Service
**Create new Data**

**Method:** POST

**API Endpoint:** `http://localhost:18087/achievement`

**Requestbody**
```json
{
  "nisn":"456",
  "capaian": "2nd Place Achievement",
  "lomba": "Asian Coding Competition",
  "tahun": "2024",
  "schoolId": 302
}
```
**Response**
```json
{
   "nisn":"456",
  "capaian": "2nd Place Achievement",
  "lomba": "Asian Coding Competition",
  "tahun": "2024",
  "schoolId": 302
}
```

**Get all data**

**Method:** GET

**API Endpoint:** `http://localhost:18087/achievement`

**Response**
```json
[
	{
		"nisn": "1234",
		"capaian": "1st Place Achievement",
		"lomba": "Line Follower Competition",
		"tahun": "2024",
		"schoolId": 202
	},
	{
		"nisn": "123",
		"capaian": "1st Place Achievement",
		"lomba": "Line Follower Competition",
		"tahun": "2024",
		"schoolId": 1
	}
]
```
**Get spesifik data**

**Method:** GET

**API Endpoint:** `http://localhost:18087/achievement/456`

**Response**
```json
{
	"nisn": "456",
	"lomba": "Asian Coding Competition",
	"capaian": "2nd Place Achievement",
	"tahun": "2024",
	"school": {
		"id": 302,
		"schoolName": "SMK 11 JAKARTA",
		"location": "JAKARTA",
		"principalName": "Mr.Alhuz"
	},
	"student": {
		"nisn": 456,
		"name": "ALFI"
	}
}
```
### conclusion
The ports for the API endpoints have been mapped using the API Gateway, so the original ports are not used. One of the main functions of the API Gateway is as a load balancer. The lb://SERVICE-NAME syntax in the uri field tells Spring Cloud Gateway to use the load balancer to resolve the service instances registered under the given SERVICE-NAME. This helps in distributing the load among available service instances and provides resilience and high availability for microservices.



