package SOLID;

public class OpenClosed {
}

interface InvoiceDao{
    public void save();
}

class DatabaseInvoiceDao implements InvoiceDao{
    @Override
    public void save() {
        // Save to DB
    }
}

class FileInvoiceDao implements InvoiceDao{
    @Override
    public void save() {
        // Save to File
    }
}

interface RestaurantEmployee{
    void washDishes();
    void serveCustomer();
    void cookFood();
}

/*class Waiter implements RestaurantEmployee{

    @Override
    public void washDishes() {
        //Not Waiters Job
    }

    @Override
    public void serveCustomer() {
        //Yes, waiters job is to serve customers
        System.out.println("Serving customers");
    }

    @Override
    public void cookFood() {
        //Not Waiters Job
    }
}*/

interface WaiterInterface{
    void serverCustomer();
    void takeOrder();
}

interface ChefInterface{
    void cookFood();
    void decideMenu();
}

class Waiter implements WaiterInterface{

    @Override
    public void serverCustomer() {

    }

    @Override
    public void takeOrder() {

    }
}

class Chef implements ChefInterface{

    @Override
    public void cookFood() {

    }

    @Override
    public void decideMenu() {

    }
}

interface KeyBoard{
    public void pressCharacter();
}

class WiredKeyBoard implements KeyBoard{
    @Override
    public void pressCharacter() {
        //Press the Character
    }
}

class WirelessKeyBoard implements KeyBoard{
    @Override
    public void pressCharacter() {
        //Press the Character
    }
}

interface Mouse{
    void rightClick();
    void leftClick();
}

class WiredMouse implements Mouse{
    @Override
    public void rightClick() {
        // Right Click
    }
    @Override
    public void leftClick() {
        // Left Click
    }
}

class Computer1{
    private WiredKeyBoard wiredKeyBoard;
    private WiredMouse wiredMouse;

    public Computer1(WiredKeyBoard wiredKeyBoard,
                    WiredMouse wiredMouse) {
        this.wiredKeyBoard = wiredKeyBoard;
        this.wiredMouse = wiredMouse;
    }
}

class Computer{
    private KeyBoard keyBoard;
    private Mouse mouse;

    public Computer(KeyBoard keyBoard, Mouse mouse) {
        this.keyBoard = keyBoard;
        this.mouse = mouse;
    }
}
