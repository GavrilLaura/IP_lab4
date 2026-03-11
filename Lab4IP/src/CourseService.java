public class CourseService {
    
    // Dependintele din diagrama
    private ManagerDeProg managerProgres;

    public CourseService(ManagerDeProg managerProgres) {
        this.managerProgres = managerProgres;
    }

    // Actiune conform diagramei: Citeste/Scrie date si actualizeaza progresul
    public void proceseazaCurs(int studentId, int cursId) {
        System.out.println("[CourseService] Procesare date curs pentru studentul: " + studentId);
        
        // Simulam "Salveaza fisiere" via File Handler (daca ai avea clasa)
        System.out.println("[CourseService] Fisier salvat cu succes.");

        // Apelam Manager de Progres conform sagetii din diagrama
        managerProgres.actualizeazaProgres(cursId, 50);
    }
}