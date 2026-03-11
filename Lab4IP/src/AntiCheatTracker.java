public class AntiCheatTracker {
    private final NotificationDispatcher dispatcher;
    private boolean fullscreenEnforced;
    private boolean copyPasteDisabled;
    private int tabSwitchWarningsCount;
    private final int maxWarningsAllowed;

    public AntiCheatTracker(NotificationDispatcher dispatcher, boolean fullscreenEnforced, boolean copyPasteDisabled, int maxWarningsAllowed) {
        this.dispatcher = dispatcher;
        this.fullscreenEnforced = fullscreenEnforced;
        this.copyPasteDisabled = copyPasteDisabled;
        this.maxWarningsAllowed = maxWarningsAllowed;
        this.tabSwitchWarningsCount = 0;
    }

    public void detecteazaSchimbareTab(String studentId, String testId) {
        tabSwitchWarningsCount++;

        System.out.println("\n[Anti-Cheat Tracker] ALERTA! Schimbare tab detectata!");
        System.out.println("[Anti-Cheat Tracker] Setari active - Fullscreen: " + fullscreenEnforced + ", Block Copy/Paste: " + copyPasteDisabled);
        System.out.println("[Anti-Cheat Tracker] Avertismente curente: " + tabSwitchWarningsCount + "/" + maxWarningsAllowed);

        if (tabSwitchWarningsCount >= maxWarningsAllowed) {
            System.out.println("[Anti-Cheat Tracker] Numar maxim de avertismente atins. Test blocat.");
            dispatcher.dispatchEvent(
                    NotificationDispatcher.EventType.CHEAT_WARNING,
                    studentId,
                    "Test blocat din cauza incalcarilor repetate ale regulilor."
            );
        } else {
            dispatcher.dispatchEvent(
                    NotificationDispatcher.EventType.CHEAT_WARNING,
                    studentId,
                    "Avertisment (" + tabSwitchWarningsCount + "/" + maxWarningsAllowed + "): Ai parasit fereastra testului."
            );
        }
    }
}