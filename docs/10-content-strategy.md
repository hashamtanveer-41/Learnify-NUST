# 10 - Content Strategy — Learnify NUST

This document defines the **content strategy** for Learnify NUST, covering types of content, organization, sourcing, quality control, and delivery.

---

## 1. Content Types

| Type             | Description                                                                 | Format                  |
|-----------------|-----------------------------------------------------------------------------|------------------------|
| Lecture Videos   | Recorded lectures from senior students or faculty                            | YouTube embeds, MP4     |
| Notes & Summaries | Written summaries, lecture notes, or slide decks                           | PDF, Markdown, HTML     |
| Playlists       | Curated sequences of videos and notes organized by course or topic          | Web-based playlists     |
| Quizzes & Tests  | Optional self-assessment material                                           | MCQs, coding exercises  |
| Progress Tracking | Student activity and progress on videos or courses                          | Backend database + frontend dashboard |

---

## 2. Content Organization

- **By Course:** Each course has its own page with all videos, notes, and quizzes.
- **By Section/Semester:** Courses are grouped according to semester and department.
- **By Topic:** Playlists for specific topics or concepts for targeted learning.
- **Search & Filter:** Students can search by course, semester, topic, or keywords.

---

## 3. Content Sourcing

- **Senior Students:** Record lectures, create notes, and upload resources.
- **Faculty (Optional):** Validate content accuracy and provide official lectures.
- **External Sources:** YouTube videos can be embedded, with proper credit and relevance check.

---

## 4. Quality Control

- **Review Process:** Seniors or Admins review all content before publishing.
- **Consistency:** Ensure uniform naming conventions, formatting, and content length.
- **Update Cycle:** Courses and notes are updated every semester or as syllabus changes.

---

## 5. Content Delivery

- **Frontend:** React-based dashboard displays courses, playlists, and notes.
- **Backend:** Spring Boot API serves video links, notes, and progress data.
- **Progress Tracking:** Students can mark videos as watched; backend tracks completion.
- **Notifications (Future):** Optional email or in-app alerts for new content uploads.

---

## 6. Accessibility & Usability

- Videos with captions or transcripts for accessibility.
- Notes in readable formats (Markdown/PDF).
- Responsive design for desktop and mobile devices.
- Clear labeling of content by semester, course, and section.

---

## 7. Metrics & Feedback

- Track content usage and engagement (video views, notes downloads).
- Collect student feedback for content improvement.
- Monitor popular playlists or courses for further enhancement.

---

**Summary:**  
The content strategy ensures that Learnify NUST delivers **relevant, high-quality, organized, and accessible learning resources** for students while maintaining control over quality and engagement metrics.
