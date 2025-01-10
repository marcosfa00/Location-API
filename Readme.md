# Location REST API

## Overview
The Location API is a RESTful web service designed to provide geographical information about cities, countries, and continents. It allows clients to retrieve data that can be used to build profiles, generate travel statistics, or create location-based applications. This API is an integral part of **Wonderboot**, enabling users to explore, manage, and analyze travel-related data.

---

## Features
- **Cities:**
    - Retrieve a list of cities by name or partial term.
    - Fetch details of a specific city, including latitude, longitude, and associated country.
- **Countries:**
    - Search for countries by name.
    - Retrieve information about a specific country, including its continent.
- **Continents:**
    - Access details about continents, including their codes and names.

---

## API Endpoints
The API is prefixed with `/api` and provides the following endpoints:

### Cities
- **Search Cities**
    - `GET /api/cities?term={name}`
    - Retrieve a list of cities that match a name or partial term.
- **Get City by ID**
    - `GET /api/cities/{cityId}`
    - Retrieve detailed information about a specific city by its unique ID.

### Countries
- **Search Countries**
    - `GET /api/countries?term={name}`
    - Retrieve a list of countries matching a name or partial term.
- **Get Country by Code**
    - `GET /api/countries/{countryCode}`
    - Retrieve detailed information about a specific country using its unique code.

### Continents
- **List Continents**
    - Continent information is accessible indirectly via countries.

---

## Data Model
### Entity Relationships
- **Continent** ↔ **Country** ↔ **City**
    - A continent has multiple countries.
    - A country contains multiple cities.

### Database Schema
- **`Continent` Table:**
    - `code` (Primary Key)
    - `name`
- **`Country` Table:**
    - `code` (Primary Key)
    - `name`
    - `continentCode` (Foreign Key referencing `Continent`)
- **`City` Table:**
    - `id` (Primary Key)
    - `name`
    - `latitude`
    - `longitude`
    - `countryCode` (Foreign Key referencing `Country`)

---

## Configuration
- **Port:** The API runs on port `8081`.
- **Database:**
    - Uses SQL scripts (`schema.sql` and `data.sql`) for database initialization.
    - Hibernate settings:
        - Naming strategy: `PhysicalNamingStrategyStandardImpl`
        - `ddl-auto`: Disabled (`none`).

---

## Technologies Used
- **Spring Boot:**
    - REST controllers for endpoints.
    - Dependency injection with `@Service` and `@Repository`.
    - Custom path configuration with `CustomWebConfig`.
- **JPA & Hibernate:**
    - Entity management and database integration.
- **Database:**
    - SQL schema for structured data.
- **Prometheus:**
    - Enabled for monitoring (`/actuator/prometheus`).

---

## Usage
1. Clone the repository:
   ```bash
   git clone <repository-url>

	2.	Build the application:

./mvnw clean package


	3.	Run the application:

./mvnw spring-boot:run


	4.	Access the API at:

Base URL: `http://localhost:8081/api`

## Example Requests

### Search for Cities

**Request:**

```http
GET /api/cities?term=Paris
```
Response:
```Json
[
  {
    "id": 1,
    "name": "Paris",
    "latitude": 48.8566,
    "longitude": 2.3522,
    "country": {
    "code": "FR",
    "name": "France"
    }
  }
]
```

Get Country by Code
```http request
GET /api/countries/FR
```

Response:
```json
{
  "code": "FR",
  "name": "France",
  "continent": {
    "code": "EU",
    "name": "Europe"
  }
}
```
## Future Enhancements

- Add endpoints for managing continents directly.
- Provide filtering options for cities (e.g., by latitude/longitude range).
- Implement pagination for large datasets.

---

## Contact


For further inquiries or support, contact [Marcos Fdez. Avendaño] at [marcosfavendano@gmail.com].
