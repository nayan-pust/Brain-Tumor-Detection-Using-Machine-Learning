class A extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            if (i == 1)
            Thread.yield();
            System.out.println("\t From Thread A : i= " + i);
        }
        System.out.println("Exit from A");
    }
}
class B extends Thread {
    public void run() {
        for (int j = 1; j <= 5; j++) {
            System.out.println("\t From Thread B : j= " + j);
            if (j == 3) {
                // Gracefully terminate the thread
                Thread.yield(); // same as stop() method
            }
        }
        System.out.println("Exit from B");
    }
}
class C extends Thread {
    public void run() {
        for (int k = 1; k <= 5; k++) {
            System.out.println("\t From Thread C : k= " + k);
            if (k == 1) {
                try {
                    sleep(1000); // Pause for 1 second
                } catch (InterruptedException e) {
                 
                  }
            }
        }
        System.out.println("Exit from C");
    }
}

public class ThreadMethod {   // main class
    public static void main(String[] args) {    // main method
        A threadA = new A();   // A type variable threadA  
        B threadB = new B();   // B() create a new object B type
        C threadC = new C();
        System.out.println("Start thread A");
        threadA.start();
        System.out.println("Start thread B");
        threadB.start();
        System.out.println("Start thread C");
        threadC.start();
        System.out.println("End of the main thread");
    }
}
