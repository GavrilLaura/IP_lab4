public interface NotificationDispatcher {
    enum EventType {
        NEW_COURSE_PUBLISHED, QUIZ_DEADLINE_APPROACHING,
        CHEAT_WARNING, GRADE_POSTED
    }
    void dispatchEvent(EventType eventType, String userId, String message);
}