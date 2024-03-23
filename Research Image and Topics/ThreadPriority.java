class A extends Thread {
  public void run() {
    System.out.println("Thread A started");
    for (int i = 1; i <= 5; i++) {
      System.out.println("\tFrom Thread A : i= " + i);
    }
    System.out.println("Exit from A");
  }
}

class B extends Thread {
  public void run() {
    System.out.println("Thread B started");
    for (int i = 1; i <= 5; i++) {
      System.out.println("\tFrom Thread B : i= " + i);
    }
    System.out.println("Exit from B");
  }
}

class C extends Thread {
  public void run() {
    System.out.println("Thread C started");
    for (int i = 1; i <= 5; i++) {
      System.out.println("\tFrom Thread C : i= " + i);
    }
    System.out.println("Exit from C");
  }
}

class ThreadPriority {
  public static void main(String args[]) {
    A threadA = new A();
    B threadB = new B();
    C threadC = new C();

    threadC.setPriority(Thread.MAX_PRIORITY);
    threadB.setPriority(threadA.getPriority()+1);    // (Thread.NORM_PRIORITY)
    threadA.setPriority(Thread.MIN_PRIORITY);

    System.out.println("Start thread A");
    threadA.start();

    System.out.println("Start thread B");
    threadB.start();

    System.out.println("Start thread C");
    threadC.start();
  }
}
