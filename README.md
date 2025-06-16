# Microservices POC (Proof of Concept)

This project is a **Microservices Architecture Proof of Concept (POC)** built using Spring Boot, Spring Cloud (Netflix Eureka, Gateway), and Zipkin for distributed tracing. It is containerized using Docker for seamless development and deployment.

---

## 📁 Project Structure

```
microservices-poc-develop/
│
├── zipkin/               # Zipkin server for tracing
├── service-registry/     # Eureka Service Registry
├── provider/             # Sample microservice - Provider
├── facilities/           # Sample microservice - Facilities
├── cloud-gateway/        # Spring Cloud Gateway (API Gateway)
├── deployment/           # Deployment scripts including docker-compose.yml
```

---

## 🐳 Docker Compose Services

The architecture consists of the following containers:

| Service            | Port   | Description                                  |
|--------------------|--------|----------------------------------------------|
| service-registry   | 8761   | Eureka Server (Service Discovery)            |
| cloud-gateway      | 8989   | API Gateway (Spring Cloud Gateway)           |
| provider           | 9191   | Sample microservice - Provider               |
| facilities         | 9192   | Sample microservice - Facilities             |
| zipkin-server      | 9411   | Zipkin Server for distributed tracing        |

---

## 🚀 Getting Started

### Prerequisites

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

### Run All Services

Navigate to the `deployment/` folder and run:

```
docker-compose up --build
```

To stop the services:

```
docker-compose down
```

---

## 🔍 Service Discovery

Access the Eureka dashboard at:

```
http://localhost:8761
```

---

## 🌐 API Gateway

All requests should be routed through the gateway:

```
http://localhost:8989
```

Example endpoint (assuming routes are configured):

```
http://localhost:8989/provider/...
http://localhost:8989/facilities/...
```

---

## 📊 Distributed Tracing (Zipkin)

Access the Zipkin UI:

```
http://localhost:9411
```

Zipkin collects and visualizes trace data from the microservices.

---

## 📂 Logs

All services share a mounted volume at `/tmp` for logs.

---

## 🛠️ Future Improvements

- Add centralized logging with ELK or Loki stack
- Implement CI/CD for automated builds and deployments
- Add health checks and monitoring

---

## 📃 License

This project is for educational and POC purposes.
