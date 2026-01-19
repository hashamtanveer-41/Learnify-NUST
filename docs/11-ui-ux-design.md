# 11 - UI/UX Design — Learnify NUST

This document outlines the **user interface and user experience design** for Learnify NUST, including layout, navigation, wireframes, and design principles.

---

## 1. Design Goals

- **Intuitive Navigation:** Students should find courses, videos, and notes easily.
- **Responsive Layout:** Works seamlessly on desktop, tablet, and mobile.
- **Accessibility:** Text readability, video captions, and keyboard navigation.
- **Engaging Experience:** Playlists, progress tracking, and content highlights.

---

## 2. User Interface Components

| Component           | Description |
|--------------------|-------------|
| Header / Navbar     | Contains logo, search bar, login/logout, and user profile. |
| Sidebar (optional)  | Navigation by semester, department, or topic. |
| Course Cards        | Display course title, description, semester, and progress badge. |
| Playlist Section    | Grouped videos for each topic or lecture series. |
| Video Player        | Embedded YouTube player with notes and captions. |
| Notes Viewer        | Markdown-rendered notes, download option for PDF. |
| Progress Tracker    | Shows video completion, overall course progress, and quizzes completed. |
| Footer              | Contact info, links to documentation, and terms of use. |

---

## 3. Navigation Flow

1. **Login / Register:** Users authenticate using university email.
2. **Dashboard:** Shows all courses by semester, department, or topic.
3. **Course Page:** Displays videos, notes, and quizzes in organized sections.
4. **Video Page:** Embedded player, notes on the side, progress tracking.
5. **Profile & Progress:** User can track overall progress and completed courses.
6. **Admin Panel (Optional):** Manage courses, videos, notes, and users.

---

## 4. Wireframes

### 4.1 Login / Register Page
- Simple form with university email and password.
- Clear call-to-action buttons.
- Option for “Forgot Password.”

### 4.2 Dashboard
- Header with search bar and profile.
- Main section: List of courses (cards or tiles).
- Sidebar (optional): Filter by semester, department, or topic.
- Quick progress summary for logged-in student.

### 4.3 Course Page
- Course title and description at the top.
- Video playlists grouped by topics.
- Notes section accessible per video or as a general course resource.
- Progress bar showing completion percentage.

### 4.4 Video Page
- Embedded video at the top.
- Notes on the right or below (responsive for mobile).
- “Mark as Watched” button.
- Related videos / playlist links below.

### 4.5 Profile & Progress Page
- User info at the top.
- List of enrolled courses with progress bars.
- Option to view detailed progress for each video and notes.

### 4.6 Admin Panel (Optional)
- Table of users, courses, videos, and notes.
- CRUD (Create, Read, Update, Delete) operations for content management.
- Role assignment for users.

---

## 5. Design Principles

- **Consistency:** Uniform buttons, colors, fonts, and spacing.
- **Minimalism:** Focus on learning content; avoid unnecessary clutter.
- **Feedback:** Show success/error messages for actions like progress update or note creation.
- **Accessibility:** High-contrast colors, readable font sizes, and responsive design.
- **Mobile-first:** Prioritize mobile layout, then scale to larger screens.

---

## 6. Suggested Color Palette (Optional)

| Element        | Color        | Hex      |
|----------------|-------------|----------|
| Primary        | Blue        | #1E3A8A |
| Secondary      | Light Blue  | #60A5FA |
| Background     | White       | #FFFFFF |
| Text           | Dark Gray   | #111827 |
| Buttons        | Accent Blue | #2563EB |

---

**Summary:**  
The UI/UX design ensures that Learnify NUST is **intuitive, responsive, accessible, and engaging**, allowing students to focus on learning efficiently. Wireframes guide the development team in building a consistent and user-friendly interface.
