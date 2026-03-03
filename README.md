## Auth Service

Микросервис аутентификации и авторизации на базе Spring Boot 3. Система обеспечивает безопасную регистрацию пользователей, хранение учетных данных и выдачу JWT-токенов для защиты микросервисной архитектуры.

---

### Технологический стек

* **Runtime:** Java 21 (Eclipse Temurin)
* **Framework:** Spring Boot 4.0.3, Spring Security 6
* **Data:** Spring Data JPA, Hibernate 7
* **Database:** PostgreSQL 15
* **Mapping & Tools:** MapStruct, Lombok
* **DevOps:** Docker, Docker Compose (Multi-stage build)

---

### Архитектура системы

Проект реализован по слоистой архитектуре:

1. **API Layer:** REST-контроллеры для обработки входящих запросов.
2. **Security Layer:** Кастомная конфигурация SecurityFilterChain, Stateless сессии и BCrypt шифрование.
3. **Service Layer:** Бизнес-логика аутентификации и кастомная реализация UserDetailsService.
4. **Data Layer:** JPA-репозитории и PostgreSQL для персистентного хранения.

---

### Ключевой функционал

* **Stateless Authentication:** Использование JWT вместо серверных сессий.
* **Security Configuration:** Отключение CSRF для REST-взаимодействия и настройка CORS.
* **Data Mapping:** Использование MapStruct для разделения сущностей базы данных (UserEntity) и объектов передачи данных (DTO).
* **Containerization:** Оптимизированный Dockerfile с разделением этапов сборки (build) и запуска (runtime) для уменьшения веса итогового образа.

---

### Структура проекта

```text
├── src/main/java/com/github/Ashirios/auth_service
│   ├── config/          # Конфигурация бинов безопасности и шифрования
│   ├── controller/      # REST эндпоинты управления доступом
│   ├── dto/             # Request/Response DTO объекты
│   ├── entity/          # Сущности базы данных
│   ├── enums/           # Определение ролей (RBAC)
│   ├── mapper/          # Интерфейсы MapStruct
│   ├── repository/      # Слой абстракции над БД
│   ├── service/         # Реализация логики авторизации и UserDetails
│   └── util/            # Инструментарий для работы с JWT
└── docker-compose.yaml  # Описание сервисов приложения и БД

```

---

### Инструкция по развертыванию

Для локального запуска необходимо наличие Docker и Docker Compose.

1. **Клонирование репозитория:**
```bash
git clone https://github.com/Ashirios/auth-service.git
cd auth-service

```


2. **Запуск инфраструктуры:**
```bash
docker compose up --build

```


3. **Проверка работоспособности:**
Сервис будет доступен по адресу `http://localhost:8080`. База данных PostgreSQL проброшена на порт `5433` (локально) для удобства отладки.

---

### API эндпоинты

| Метод | Путь | Описание | Доступ |
| --- | --- | --- | --- |
| POST | `/api/auth/register` | Регистрация нового аккаунта | Публичный |
| POST | `/api/auth/login` | Аутентификация и получение токена | Публичный |
| GET | `/api/users/me` | Получение данных профиля | Только авторизованные |

---
