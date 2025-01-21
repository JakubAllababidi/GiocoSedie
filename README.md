# Gioco delle Sedie

Il **Gioco delle Sedie** è un'applicazione in Java che simula il famoso gioco, in cui i partecipanti devono trovare un posto a sedere. Il numero di partecipanti e sedie viene gestito con una sedia in meno rispetto ai partecipanti.

## Funzionalità
- **Numero Dinamico di Partecipanti**: L'utente può specificare il numero di partecipanti al momento dell'avvio.
- **Salvataggio Risultati**: I risultati del gioco (posti occupati e partecipanti) vengono salvati in un file `Risultato.txt`.
- **Simulazione**: Lo stato delle sedie viene mostrato in tempo reale nella console.

## Descrizione delle Classi
### `TestGiocoSedie`
Questa è la classe principale del progetto e la sua funzione è quella di avviare l'applicazione.Vengono inizializzati gli oggetti necessari per il gioco, come le sedie, i partecipanti e il display.

### `Posto`
La classe `Posto` rappresenta una singola sedia nel gioco. Gestisce lo stato della sedia, che può essere occupata o libera.
  
- **Metodi**:
  - `libero()`: Questo metodo restituisce `true` se il posto è libero, altrimenti restituisce `false`.
  - `occupa()`: Se la sedia è libera, il metodo la occupa e restituisce `true`. Se la sedia è già occupata, restituisce `false`.

### `Partecipante`
La classe `Partecipante` simula un partecipante al gioco. Ogni partecipante è gestito come un thread separato, il che consente di simulare la competizione tra i partecipanti in tempo reale.

- **Metodo**:
  - `run()`: Ogni thread di un partecipante tenta di occupare una sedia. Il metodo cerca di occupare ciascun posto nell'array, e se trova un posto libero, si siede e stampa il numero del posto che ha occupato. Se non riesce a sedersi, stampa un messaggio indicando che ha perso.

### `Display`
La classe `Display` è responsabile per la visualizzazione dello stato delle sedie in tempo reale. Mostra nella console se una sedia è occupata o libera.

- **Metodo**:
  - `run()`: Questo metodo cicla continuamente, mostrando lo stato delle sedie (con un `*` per le sedie occupate e `0` per quelle libere). La simulazione continua finché tutte le sedie non sono occupate, al termine del quale il gioco finisce.


