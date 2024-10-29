class CompteurThread extends Thread {
    private Compteur compteur;

    public CompteurThread(Compteur compteur) {
        this.compteur = compteur;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            compteur.increment();
           
        }
    }
}