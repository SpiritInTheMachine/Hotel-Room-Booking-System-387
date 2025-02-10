# **Landon Hotel Booking System**

## **Project Overview**
The **Landon Hotel Booking System** is a full-stack web application designed to facilitate hotel reservations, room availability checks, and real-time presentation scheduling across different time zones. The system supports multi-language localization and leverages multi-threaded processing for efficient language translation and scheduling. It is containerized with Docker and deployed to the cloud for scalability and ease of deployment.

## **Key Features**
- **Room Booking & Availability** – Users can view available rooms and make reservations.
- **Time Zone Conversion** – Live presentation times are displayed in Eastern (ET), Mountain (MT), and Coordinated Universal Time (UTC).
- **Internationalization Support** – Multi-threaded processing enables language translation (English & French).
- **RESTful API Integration** – Backend APIs handle room reservations, messages, and time zone conversions.
- **Containerized Deployment** – Packaged with Docker and deployed to Azure for cloud hosting.

## **Technologies Used**
### **Frontend:**
- Angular (TypeScript)
- HTML, CSS
- Bootstrap for responsive design

### **Backend:**
- Spring Boot (Java)
- REST API for business logic
- Multi-threading for processing efficiency

### **Database:**
- MySQL for storing reservation data

### **DevOps & Deployment:**
- Docker for containerization
- Azure App Service for cloud deployment
- GitLab for version control

## **Setup & Installation**
### **Prerequisites:**
- Install **Node.js** and **Angular CLI** for frontend setup
- Install **Java 17** and **Maven** for backend setup
- Install **Docker Desktop** for containerization

### **Steps to Run Locally:**
1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd landon-hotel-booking
   ```

2. **Run Backend**
   ```bash
   cd backend
   mvn clean package
   java -jar target/D387_sample_code-0.0.2-SNAPSHOT.jar
   ```

3. **Run Frontend**
   ```bash
   cd frontend
   npm install
   ng serve --open
   ```

4. **Run with Docker**
   ```bash
   docker build -t landon-hotel-app .
   docker run -d -p 8080:8080 --name D387_sample_container landon-hotel-app
   ```

## **API Endpoints**
| Endpoint | Method | Description |
|----------|--------|-------------|
| `/api/messages` | GET | Fetches localized messages in English & French |
| `/room/reservation/v1` | GET | Retrieves available rooms based on check-in & check-out dates |
| `/api/timezones` | GET | Fetches live presentation times in ET, MT, and UTC |
| `/room/reservation/v1` | POST | Reserves a selected room |
