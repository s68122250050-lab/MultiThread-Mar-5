import java.util.concurrent.atomic.AtomicInteger;

class CoffeeMachine {

    private AtomicInteger count = new AtomicInteger(0); //ข้อ 5.1(แก้ปัญหา Race Condition ด้วย synchronized)

    public synchronized void brew(String menu) { //ข้อ 5.2(แก้ปัญหา Race Condition ด้วย AtomicInteger)

        System.out.println("กำลังใช้เครื่องชง: " + menu);

        try {
            Thread.sleep((long)(Math.random() * 3000)); //ข้อ 2(เปลี่ยน sleep เป็นสุ่มเวลา)
        } catch (InterruptedException e) {}

        int c = count.incrementAndGet();
        System.out.println("เครื่องดื่มเสร็จ: " + menu + " ลำดับที่ " + c);
    }
}


class CoffeeMaker implements Runnable {

    private String menu;
    private CoffeeMachine machine;

    public CoffeeMaker(String menu, CoffeeMachine machine) {
        this.menu = menu;
        this.machine = machine;
    }

    @Override
    public void run() {
        machine.brew(menu);
    }
}

public class CoffeeShop {
    public static void main(String[] args) {

        CoffeeMachine machine = new CoffeeMachine();

        //ข้อ 1(เพิ่มจำนวนเมนูเป็น 10 รายการ)
        new Thread(new CoffeeMaker("Espresso", machine)).run();//ข้อ 3(run() แทน start())
        new Thread(new CoffeeMaker("Latte", machine)).run();
        new Thread(new CoffeeMaker("Mocha", machine)).run();
        new Thread(new CoffeeMaker("Americano", machine)).run();
        new Thread(new CoffeeMaker("Cappuccino", machine)).run();
        new Thread(new CoffeeMaker("Macchiato", machine)).run();
        new Thread(new CoffeeMaker("Flat White", machine)).run();
        new Thread(new CoffeeMaker("Caramel Latte", machine)).run();
        new Thread(new CoffeeMaker("Vanilla Latte", machine)).run();
        new Thread(new CoffeeMaker("Iced Coffee", machine)).run();
        
        System.out.println("End main");//ข้อ 4(ใส่ System.out.println("End main"))
    }
}