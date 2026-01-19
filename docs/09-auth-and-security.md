# 09 - Authentication & Security — Learnify NUST

This document outlines the authentication and security mechanisms for the Learnify NUST platform.

---

## 1. Authentication

### 1.1 JWT (JSON Web Tokens)
- **Purpose:** Securely authenticate users and protect API endpoints.
- **Mechanism:**
  - After login, backend generates a JWT token containing:
    - User ID
    - Role
    - Expiration timestamp
  - Token is signed with a secret key.
  - Client stores the token (localStorage or HttpOnly cookie).
  - Each protected request includes the token in the `Authorization` header:
    ```
    Authorization: Bearer <JWT_TOKEN>
    ```
  - Backend verifies the token before granting access.

### 1.2 Registration & Login
- Users register with **email, password, name, and role**.
- Passwords are **hashed** using a secure hashing algorithm (e.g., BCrypt) before storage.
- Login returns a JWT token upon successful authentication.

---

## 2. Password Security

- **Hashing:** Use BCrypt or Argon2 for hashing passwords.
- **Never store plain text passwords**.
- **Password policies:**  
  - Minimum 8 characters  
  - At least one uppercase, one lowercase, one number  
  - Optional special character requirement
- **Password reset:**  
  - Secure token sent via email  
  - Token expires after short period (e.g., 15–30 mins)  

---

## 3. Role-Based Access Control (RBAC)

| Role      | Access Permissions                                      |
|-----------|--------------------------------------------------------|
| STUDENT   | View courses, videos, notes, and track progress       |
| SENIOR    | All STUDENT permissions + add videos and notes        |
| ADMIN     | Full access: manage users, courses, videos, notes     |

- Backend enforces access rules on every protected endpoint.
- Example:
  - `POST /api/courses` → Only ADMIN
  - `POST /api/courses/{id}/notes` → SENIOR or ADMIN
  - `GET /api/users/{id}/progress` → Only the user themselves or ADMIN

---

## 4. API Security Best Practices

- **HTTPS:** All API traffic must use HTTPS.
- **CORS:** Restrict allowed origins for frontend requests.
- **Rate Limiting:** Prevent brute-force attacks on login endpoint.
- **Input Validation:** Validate all incoming data to prevent SQL injection or XSS.
- **Error Handling:** Avoid exposing sensitive information in error messages.
- **Token Expiration & Refresh:**
  - Short-lived access tokens (e.g., 15–30 mins)
  - Optional refresh tokens to issue new access tokens securely
- **Logging & Monitoring:**
  - Log failed login attempts
  - Monitor unusual activity patterns

---

## 5. Optional Enhancements

- Two-factor authentication (2FA) for sensitive roles (SENIOR / ADMIN)
- CAPTCHA on login/registration to prevent bots
- Account lockout after multiple failed login attempts
- Audit logs for user actions (add/edit/delete courses, videos, notes)

---

**Summary:**  
The authentication & security system ensures that:
- Users are securely identified (JWT + hashed passwords)
- Access is granted based on roles (RBAC)
- Sensitive operations are protected
- Best practices prevent common security vulnerabilities
-
- <img width="1536" height="1024" alt="9 Auth" src="https://github.com/user-attachments/assets/04d512fc-5a79-4b32-b4cd-375cdd71c41e" />


