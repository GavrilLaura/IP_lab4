public class Main {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("    INITIALIZARE SISTEM EDUCONNECT        ");
        System.out.println("==========================================");

        NotificationDispatcher mockDispatcher = new NotificationDispatcher() {
            @Override
            public void dispatchEvent(EventType eventType, String userId, String message) {
                System.out.println(">>> [Dispatcher Notificari] Trimit alerta Node.js...");
                System.out.println("    -> Tip   : " + eventType);
                System.out.println("    -> User  : " + userId);
                System.out.println("    -> Mesaj : " + message);
            }
        };

        ProgressManager mockProgressManager = new ProgressManager() {
            @Override
            public void actualizeazaProgres(String studentId, String cursId, double scor, boolean aTrecut) {
                System.out.println(">>> [Manager de Progres] UPDATE progres curs in DB...");
                System.out.println("    -> Student: " + studentId + " | Scor: " + scor + "% | Admis: " + aTrecut);
            }
        };

        AntiCheatTracker antiCheatTracker = new AntiCheatTracker(mockDispatcher, true, true, 3);
        MotorDeTeste motorDeTeste = new MotorDeTeste(mockProgressManager, 60, 50.0, 2, true);

        System.out.println("Sistem initializat cu succes.\n");

        String currentStudentId = "STUDENT_RX90";
        String currentCourseId = "CURS_PROGRAMARE_WEB";

        System.out.println("--- SCENARIU 1: Studentul incalca regulile ---");
        antiCheatTracker.detecteazaSchimbareTab(currentStudentId, currentCourseId);
        antiCheatTracker.detecteazaSchimbareTab(currentStudentId, currentCourseId);

        System.out.println("\n--- SCENARIU 2: Evaluare finala test ---");
        motorDeTeste.evalueazaTest(currentStudentId, currentCourseId, 35, 40, 45);

        System.out.println("\n==========================================");
        System.out.println("            FINAL SIMULARE                ");
        System.out.println("==========================================");
    }
}