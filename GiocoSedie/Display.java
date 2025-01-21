class Display extends Thread {
    private Posto[] sedie;
    private boolean endgame;

    public Display(Posto[] sedie) {
        this.sedie = sedie.clone();
    }

    @Override
    public void run() {
        try {
            while (!endgame) {
                int count = 0;

                sleep((int) (Math.random() * 250));

                for (int i = 0; i < sedie.length; i++) {
                    if (sedie[i].libero()) {
                        System.out.print("0");
                    } else {
                        count++;
                        System.out.print("*");
                    }
                }
                System.out.println();
                endgame = (count == sedie.length);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}