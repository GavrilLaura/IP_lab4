public class ManagerDeProg {
    
    // Atribute simple
    private String statusProgres;

    public ManagerDeProg() {
        this.statusProgres = "Inceput";
    }

    // Metoda ceruta de diagrama: "Actualizeaza progresul"
    public void actualizeazaProgres(int cursId, int procentaj) {
        System.out.println("[ManagerProgres] Se actualizeaza cursul " + cursId + " la " + procentaj + "%");
        this.statusProgres = "Progres: " + procentaj + "%";
        // Aici ar veni logica de JDBC pentru "Baza de Date"
    }

    public String getStatus() {
        return statusProgres;
    }
}