# System Architecture — Learnify NUST

This section describes the high-level system architecture of Learnify NUST, explaining how different components interact to deliver a secure, scalable, and user-friendly learning platform.

---

## Architectural Style

Learnify NUST follows a **three-tier architecture**:

1. Presentation Layer (Frontend)
2. Application Layer (Backend)
3. Data Layer (Database)

This separation ensures modularity, scalability, and ease of maintenance.

---

## 1. Presentation Layer (Frontend)

**Technology:** React.js

### Responsibilities
- Render user interface components
- Handle client-side routing and state management
- Communicate with backend via REST APIs
- Embed YouTube playlists for content consumption

### Key Components
- Login & authentication UI
- Course and section browsing views
- Playlist display pages
- Admin dashboard interface

---

## 2. Application Layer (Backend)

**Technology:** Spring Boot

### Responsibilities
- Expose RESTful APIs
- Handle authentication and authorization
- Enforce business logic and validation
- Manage content submission and approval workflows

### Core Modules
- Authentication & Authorization Module
- User Management Module
- Course & Content Management Module
- Admin Moderation Module

---

## 3. Data Layer (Database)

**Technology:** PostgreSQL

### Responsibilities
- Store structured academic data
- Maintain user, course, and playlist relationships
- Ensure data integrity and consistency

### Key Entities
- Users
- Roles
- Courses
- Sections
- Playlists
- Content Submissions

---

## External Services

### YouTube Embed API
- Used for streaming video content
- Avoids storing large media files on the server
- Ensures fast and reliable content delivery

---

## Authentication Flow (High-Level)

1. User logs in using university email
2. Backend verifies credentials and domain
3. JWT or session token is issued
4. Token is used for authenticated API requests
5. Role-based access controls applied

---

## Data Flow Overview

1. User requests content from frontend
2. Frontend calls backend REST API
3. Backend processes request and queries database
4. Response sent back to frontend
5. Frontend renders structured content

---

## Deployment Architecture (Planned)

- Frontend hosted as a static application
- Backend deployed as a containerized service
- PostgreSQL hosted on managed cloud service
- HTTPS enforced for all communication

---

## Scalability & Maintainability Considerations

- Stateless backend services
- Clear API contracts
- Modular service design
- Easy addition of new features and modules

---

## Summary

The system architecture ensures:
- Clear separation of concerns
- Secure access control
- Scalability for future growth
- Maintainable and extensible design
