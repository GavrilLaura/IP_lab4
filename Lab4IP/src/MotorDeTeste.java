public class MotorDeTeste {
    private final ProgressManager progressManager;
    private int timpAlocatMinute;
    private double scorMinimTrecere;
    private int numarMaximIncercari;
    private boolean intrebariRandomizate;

    public MotorDeTeste(ProgressManager progressManager, int timpAlocatMinute, double scorMinimTrecere, int numarMaximIncercari, boolean intrebariRandomizate) {
        this.progressManager = progressManager;
        this.timpAlocatMinute = timpAlocatMinute;
        this.scorMinimTrecere = scorMinimTrecere;
        this.numarMaximIncercari = numarMaximIncercari;
        this.intrebariRandomizate = intrebariRandomizate;
    }

    public void evalueazaTest(String studentId, String cursId, int intrebariCorecte, int totalIntrebari, int timpScursMinute) {
        double scor = ((double) intrebariCorecte / totalIntrebari) * 100;
        boolean aTrecut = scor >= scorMinimTrecere && timpScursMinute <= timpAlocatMinute;

        System.out.println("\n[Motor de Teste] Incep evaluarea pentru: " + studentId);
        System.out.println("[Motor de Teste] Timp scurs: " + timpScursMinute + "/" + timpAlocatMinute + " min");
        System.out.printf("[Motor de Teste] Scor calculat: %.2f%%\n", scor);
        System.out.println("[Motor de Teste] Status promovare: " + (aTrecut ? "ADMIS" : "RESPINS"));

        progressManager.actualizeazaProgres(studentId, cursId, scor, aTrecut);
    }
}