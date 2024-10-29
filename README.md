# Demo Threads
En Java, les threads sont des processus légers permettant d'exécuter des tâches simultanément, souvent utilisés pour des applications nécessitant une gestion de plusieurs tâches en parallèle, telles que l'affichage et les calculs complexes. Voici les mots-clés et concepts importants des threads en Java, accompagnés d'exemples de code.

### Mots-clés importants pour les threads
1. **Thread** : Classe permettant de créer un thread.
2. **Runnable** : Interface fonctionnelle pour définir la logique d'exécution d'un thread.
3. **start()** : Démarre l'exécution d'un thread.
4. **run()** : Contient le code exécuté par le thread.
5. **sleep()** : Met en pause le thread pour une durée spécifiée.
6. **join()** : Permet à un thread d’attendre la fin d’un autre thread.
7. **synchronized** : Mot-clé pour gérer l'accès synchronisé aux ressources partagées.
8. **wait()** et **notify()** : Méthodes pour gérer la communication entre threads, en particulier dans les situations de producteur-consommateur.

### Exemples de code

1. **Création de threads en étendant `Thread`**

   ```java
   class MyThread extends Thread {
       public void run() {
           System.out.println("Le thread " + Thread.currentThread().getId() + " est en cours d'exécution.");
       }
   }

   public class Main {
       public static void main(String[] args) {
           MyThread thread1 = new MyThread();
           thread1.start(); // Démarre le thread
       }
   }
   ```

   Dans cet exemple, on crée une classe `MyThread` qui hérite de `Thread`. La méthode `run()` définit la tâche du thread, et `start()` lance le thread, permettant l'exécution de `run()` en parallèle.

2. **Création de threads en implémentant `Runnable`**

   ```java
   class MyRunnable implements Runnable {
       public void run() {
           System.out.println("Thread en cours d'exécution : " + Thread.currentThread().getName());
       }
   }

   public class Main {
       public static void main(String[] args) {
           Thread thread = new Thread(new MyRunnable());
           thread.start(); // Démarre le thread
       }
   }
   ```

   En implémentant `Runnable`, on peut définir des tâches dans `run()`. Cela permet une meilleure flexibilité, notamment pour utiliser des pools de threads.

3. **Synchronisation de threads**

   ```java
   class Compteur {
       private int count = 0;

       public synchronized void increment() {
           count++;
       }

       public int getCount() {
           return count;
       }
   }

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

   public class Main {
       public static void main(String[] args) throws InterruptedException {
           Compteur compteur = new Compteur();

           Thread t1 = new CompteurThread(compteur);
           Thread t2 = new CompteurThread(compteur);

           t1.start();
           t2.start();

           t1.join(); // Attend que le thread t1 termine
           t2.join(); // Attend que le thread t2 termine

           System.out.println("Valeur finale du compteur : " + compteur.getCount());
       }
   }
   ```

   Ici, `synchronized` protège l'accès à la méthode `increment()`. Cela garantit que seul un thread à la fois peut accéder à cette méthode pour éviter des incohérences dans les données partagées.

4. **Utilisation de `wait()` et `notify()`**

   ```java
   class Compteur {
       private int count = 0;

       public synchronized void attendreEtIncrémenter() throws InterruptedException {
           while (count < 10) {
               wait(); // Attend une notification
           }
           count++;
           notify(); // Notifie un autre thread en attente
       }

       public synchronized void increment() {
           count++;
           notify(); // Notifie les threads en attente
       }

       public int getCount() {
           return count;
       }
   }
   ```

   Avec `wait()` et `notify()`, les threads peuvent attendre certaines conditions avant de continuer leur exécution, ce qui est utile dans des situations de type producteur-consommateur【23†source】【29†source】【24†source】.

Ces exemples couvrent les principales bases de l’utilisation des threads en Java. Ils illustrent différentes façons de les créer, de les synchroniser et d'utiliser des méthodes avancées pour gérer leur exécution et la communication.