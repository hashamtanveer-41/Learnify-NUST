# 07 - Database Design

This document outlines the database schema for the Learnify NUST platform. It includes the main tables, their relationships, and the rationale behind the design.

---

## **1. Users Table**

| Column    | Type         | Constraints                        | Description                         |
|-----------|-------------|-----------------------------------|-------------------------------------|
| id        | SERIAL       | PRIMARY KEY                        | Unique identifier for each user     |
| name      | VARCHAR(100) | NOT NULL                            | User's full name                     |
| email     | VARCHAR(100) | NOT NULL, UNIQUE                    | User's email address (used for login) |
| password  | VARCHAR(255) | NOT NULL                            | Hashed password                       |
| role_id   | INT          | NOT NULL, FOREIGN KEY → roles(id)  | Reference to the user's role        |

**Notes:**
- Each user has **one role**.
- Roles are stored in a separate table to allow flexibility and easy role management.

---

## **2. Roles Table**

| Column | Type        | Constraints       | Description                  |
|--------|------------|-----------------|------------------------------|
| id     | SERIAL      | PRIMARY KEY      | Unique identifier for role   |
| name   | VARCHAR(50) | NOT NULL, UNIQUE | Role name (e.g., STUDENT, SENIOR, ADMIN) |

**Notes:**
- Roles define the type of user.
- Roles are reusable across multiple users.

---

## **3. Courses Table**

| Column       | Type         | Constraints                        | Description                   |
|-------------|-------------|-----------------------------------|-------------------------------|
| id          | SERIAL       | PRIMARY KEY                        | Unique course identifier      |
| name        | VARCHAR(255) | NOT NULL                            | Course name                   |
| description | TEXT         |                                     | Brief description of course   |
| semester    | INT          | NOT NULL                            | Semester in which the course is taught |

---

## **4. Videos Table**

| Column     | Type         | Constraints                        | Description                       |
|-----------|-------------|-----------------------------------|-----------------------------------|
| id        | SERIAL       | PRIMARY KEY                        | Unique video identifier           |
| course_id | INT          | NOT NULL, FOREIGN KEY → courses(id)| Course this video belongs to      |
| title     | VARCHAR(255) | NOT NULL                            | Video title                       |
| youtube_id| VARCHAR(50)  | NOT NULL, UNIQUE                    | YouTube video ID                  |
| duration  | INT          |                                     | Video duration in seconds         |

---

## **5. Notes Table**

| Column     | Type         | Constraints                        | Description                        |
|-----------|-------------|-----------------------------------|------------------------------------|
| id        | SERIAL       | PRIMARY KEY                        | Unique note identifier             |
| course_id | INT          | NOT NULL, FOREIGN KEY → courses(id)| Course this note belongs to        |
| title     | VARCHAR(255) | NOT NULL                            | Note title                         |
| content   | TEXT         |                                     | Note content (markdown / text)     |
| created_by| INT          | FOREIGN KEY → users(id)            | User who created the note          |

---

## **6. Progress Table**

| Column     | Type         | Constraints                        | Description                        |
|-----------|-------------|-----------------------------------|------------------------------------|
| id        | SERIAL       | PRIMARY KEY                        | Unique progress record             |
| user_id   | INT          | NOT NULL, FOREIGN KEY → users(id)  | User who is progressing            |
| video_id  | INT          | NOT NULL, FOREIGN KEY → videos(id) | Video being tracked                |
| status    | VARCHAR(50)  | NOT NULL                            | e.g., NOT_STARTED, IN_PROGRESS, COMPLETED |
| updated_at| TIMESTAMP    | DEFAULT CURRENT_TIMESTAMP           | Last update of progress           |

---

## **7. Relationships Summary**

- **User ↔ Role:** Many users can have one role (One-to-Many)
- **Course ↔ Video:** One course can have many videos (One-to-Many)
- **Course ↔ Notes:** One course can have many notes (One-to-Many)
- **User ↔ Progress ↔ Video:** Many-to-Many relationship via progress table

---

**Design Principles:**

- Normalized database for maintainability.
- Roles as separate entity for flexibility and security.
- Tracks user progress efficiently for personalized experience.
- Supports phased content addition: YouTube embeds → Senior recorded content → Notes.


