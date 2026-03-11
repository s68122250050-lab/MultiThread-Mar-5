class CoffeeMaker implements Runnable {

    String menu;

    public CoffeeMaker(String menu) {
        this.menu = menu;
    }

    public void run() {
        System.out.println("เริ่มชง " + menu);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("เกิดข้อผิดพลาด");
        }

    }
    public static void main(String[] args) {

        Thread t1 = new Thread(new CoffeeMaker("Espresso"));
        Thread t2 = new Thread(new CoffeeMaker("Latte"));
        Thread t3 = new Thread(new CoffeeMaker("Cappuccino"));

        t1.start();
        t2.start();
        t3.start();

        System.out.println("🛎 รับออเดอร์ครบแล้ว");
    }

}