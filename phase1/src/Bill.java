import java.util.ArrayList;

public class Bill
{

    private int tableNumber;
    private Waiter server;
    private ArrayList<Dish> dishList;
    private int billId;
    private static int numOfBills;

    public Bill(int tableNumber, Waiter server) {
        this.tableNumber = tableNumber;
        this.server = server;
        numOfBills++;
    }


    /** Adds Dish to ArrayList of dishList
     * @param dish Waiter passes in a dish to the bill which is added to ArrayList dishList
     */
    public void addDish(Dish dish) {
        dishList.add(dish);
    }

    /** Removes dish from Bill.
     * @param currentDishID specific Dish ID passed to remove the dish from this specific Bill.
     */
    public void removeDish(int currentDishID) {
        for(int i = 0; i < this.dishList.size(); i++) {
            if (dishList.get(i).getDishId() == currentDishID) {
                dishList.remove(i);
            }
        }
    }

    public int getbillId() {
        return this.billId;
    }

    public int totalBillPrice() {
        int price = 0;
        for(Dish currentDish: dishList) {
            price += currentDish.getPrice();
        }
        return price;
    }

    /**Returns the formatted bill as a String containing each dish, each dish's Price, total Price, the Waiter,
     * and the table number.
     * @return String
     */
    public String toString() {
        String currentBill = "Thank you for joining us today. Your Waiter today was " + this.server + "\n" +
                " TABLE NUMBER: " + this.tableNumber;
        for(Dish currentDish: dishList) {
            currentBill += "[" + currentDish + ": " + currentDish.getPrice() + "]" + "\n";
        }
        currentBill += "TOTAL PRICE: " + totalBillPrice();
        return currentBill;
    }

}
