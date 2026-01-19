# API Design — Learnify NUST

This document provides a high-level overview of REST APIs for the Learnify NUST platform. It covers endpoints, HTTP methods, input/output structure, and user roles.

---

## Authentication

### 1. User Registration
- **Endpoint:** `POST /api/auth/register`
- **Description:** Registers a new user.
- **Request Body:**
```json
{
  "name": "string",
  "email": "string",
  "password": "string",
  "role_id": "integer"
}
```
### Response: 
```json
{
  "message": "User registered successfully",
  "user_id": 1
}
```
No auth required

### 1.2 Login
- **Endpoint:** `POST /api/auth/login`
- **Description:** Authenticates a user and returns a JWT token.
- **Request Body:**
```json
{
  "email": "john@example.com",
  "password": "string"
}

```
### Response: 
```json
{
  "token": "jwt_token",
  "user": {
    "id": 1,
    "name": "John Doe",
    "role": "STUDENT"
  }
}

```
No auth required

### 1.3 Get Current User
- **Endpoint:** `GET /api/auth/me`
- **Description:** Retrieves details of the logged-in user.
- **Request Body:**
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john@example.com",
  "role": "STUDENT"
}

```
### Response: 
```json
{
  "message": "User registered successfully",
  "user_id": 1
}
```
 auth required

 ### 2. Course
- **Endpoint:** `GET /api/courses`
- **Description:** Returns all available courses.
- **Response Body:**
```json
[
  {
    "id": 1,
    "name": "Introduction to CS",
    "description": "Basic CS course",
    "semester": 1
  }
]
```
optional auth required

### 2.2 Get Course by id
- **Endpoint:** `GET /api/courses/{courseId}`
- **Description:** Returns course details, including videos and notes.
- **Response Body:**
```json
{
  "id": 1,
  "name": "Introduction to CS",
  "description": "Basic CS course",
  "videos": [
    { "id": 1, "title": "Lesson 1", "youtube_id": "abc123" }
  ],
  "notes": [
    { "id": 1, "title": "Lecture Notes", "content": "..." }
  ]
}

```

Optional auth required

### 3. Videos
- **Endpoint:** `GET /api/videos/{videoId}`
- **Description:** Returns video details, including associated notes.
- **Response Body:**
```json
{
  "id": 1,
  "title": "Lesson 1",
  "youtube_id": "abc123",
  "notes": [
    { "id": 1, "title": "Lesson Notes", "content": "..." }
  ]
}


```

Auth required
### 3. Videos
- **Endpoint:** `GET /api/videos/{videoId}`
- **Description:** Returns video details, including associated notes.
- **Response Body:**
```json
{
  "id": 1,
  "title": "Lesson 1",
  "youtube_id": "abc123",
  "notes": [
    { "id": 1, "title": "Lesson Notes", "content": "..." }
  ]
}


```

Auth required

### 3. Videos
### 3.1 Get Video by Id
- **Endpoint:** `GET /api/videos/{videoId}`
- **Description:** Returns video details, including associated notes.
- **Response Body:**
```json
{
  "id": 1,
  "title": "Lesson 1",
  "youtube_id": "abc123",
  "notes": [
    { "id": 1, "title": "Lesson Notes", "content": "..." }
  ]
}


```

Auth required
### 3.2 Add Videos(Senior / Admin Only)
- **Endpoint:** `POST /api/videos`
- **Description:** Adds a new video to a course.
- - **Request Body:**
```json
{
  "course_id": 1,
  "title": "Lesson 2",
  "youtube_id": "def456"
}
```
- **Response Body:**
```json
{
  "message": "Video added successfully",
  "video_id": 2
}

```

Auth required (Role Senior/Admin)

### 4. Notes
- **Endpoint:** `GET /api/courses/{courseId}/notes`
- **Description:** Returns all notes for a course.
- **Response Body:**
```json
[
  { "id": 1, "title": "Lecture Notes", "content": "..." },
  { "id": 2, "title": "Chapter 2 Notes", "content": "..." }
]
```

Auth required
### 4.2 Add note
- **Endpoint:** `POST /api/courses/{courseId}/notes`
- **Description:** Adds a new note to a course.
- - **Request Body:**
```json
{
  "title": "New Lecture Notes",
  "content": "..."
}

```
- **Response Body:**
```json
{
  "message": "Note added successfully",
  "note_id": 3
}
```
Auth required (Role = SENIOR / ADMIN)


### 5. Progress Tracking
- **Endpoint:** `GET /api/users/{userId}/progress`
- **Description:** Returns progress of a student across all videos.
- **Response Body:**
```json
[
  { "video_id": 1, "watched": true },
  { "video_id": 2, "watched": false }
]
```

Auth required

### 5.2 Update Progress
- **Endpoint:** `PUT /api/users/{userId}/progress`
- **Description:** Updates user's progress for a video.
- - **Request Body:**
```json
{
  "video_id": 2,
  "watched": true
}
```
- **Response Body:**
```json
{ "message": "Progress updated successfully" }
```
Auth required

### 6. Roles
- **Endpoint:** `GET /api/roles`
- **Description:** Lists all available roles.
- **Response Body:**
```json
[
  { "id": 1, "name": "STUDENT" },
  { "id": 2, "name": "SENIOR" },
  { "id": 3, "name": "ADMIN" }
]
```

Optional Auth required

