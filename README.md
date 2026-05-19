# 🛠️ EcoMarket - Microservicio de Soporte (soporteservice)

Este repositorio contiene el microservicio de Soporte (`soporteservice`) perteneciente al proyecto fullstack **EcoMarket**. Este servicio es responsable de centralizar y gestionar toda la interacción de ayuda, atención al cliente y feedback de la plataforma.

---

## 📋 Características Principales

El microservicio está diseñado para manejar los siguientes dominios de negocio:

* **Gestión de Tickets:** Creación, categorización (`CategoriaTicket`) y seguimiento del ciclo de vida de las solicitudes de soporte (`EstadoTicket`).
* **Chat de Soporte:** Administración del historial y flujo de mensajes de soporte en tiempo real (`MensajeChat`).
* **Sistema de Reseñas:** Gestión de valoraciones y feedback de los usuarios sobre productos o el servicio (`Resena`).
* **Notificaciones:** Generación de alertas y avisos al usuario a través de distintos canales de comunicación (`Notificacion`, `CanalNotificacion`).
* **Integración de Clientes:** Comunicación síncrona con el microservicio de usuarios/clientes para enriquecer la información de soporte (usando `ClienteDTO` y `RestTemplate`).

---

## 🏗️ Arquitectura y Estructura del Proyecto

El proyecto sigue una arquitectura clásica de capas de Spring Boot:

* **`config/`**: Contiene clases de configuración global. Incluye `RestTemplateConfig.java` para habilitar la comunicación HTTP con otros microservicios del ecosistema EcoMarket.
* **`controller/`**: Controladores REST que exponen los endpoints (API) para que el frontend u otros servicios interactúen con el módulo de soporte.
* **`model/`**: Entidades de dominio y DTOs (Data Transfer Objects) que mapean la base de datos y la información en tránsito.
* **`repository/`**: Interfaces de Spring Data JPA para la persistencia y acceso a datos en la base de datos.
* **`service/`**: Contiene la lógica de negocio central, sirviendo como puente entre los controladores y los repositorios.

---

## 🚀 Tecnologías Utilizadas

* **Lenguaje:** Java
* **Framework:** Spring Boot
* **Gestor de Dependencias:** Maven
* **Comunicación Inter-servicios:** `RestTemplate`
* **Base de datos:** MySQL

---

## ⚙️ Configuración y Ejecución Local

### Prerrequisitos
* Java Development Kit (JDK) 25.
* Maven instalado.
* Motor de base de datos en ejecución.
