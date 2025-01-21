class Partecipante extends Thread {
    private Posto[] sedie;
    private int id;
    private String risultato;

    public Partecipante(Posto[] sedie, int id) {
        this.sedie = sedie;
        this.id = id;
    }

    public String getRisultato() {
        return risultato;
    }

    @Override
    public void run() {
        try {
            sleep((int) (Math.random() * 1000));

            for (int i = 0; i < sedie.length; i++) {
                if (sedie[i].occupa()) {
                    risultato = "Partecipante " + id + " si è seduto sul posto " + i;
                    System.out.println(risultato);
                    return;
                }
            }
            risultato = "Partecipante " + id + " ha perso.";
            System.out.println(risultato);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
