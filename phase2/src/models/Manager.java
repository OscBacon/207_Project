package models;

import controllers.Restaurant;

public class Manager implements Listener{

    public Manager() {
    }

    public void handleEvent(String[] inputArray) {

        switch (inputArray[0]) {
            case "add waiter":
                addWaiter(inputArray[1]);
                break;
            case "remove waiter":
                removeWaiter(inputArray[1]);
                break;
            case "add cook":
                addWaiter(inputArray[1]);
                break;
            case "remove cook":
                removeWaiter(inputArray[1]);
                break;
            case "requested undelivered dishes":
                Restaurant.getUndeliveredDishes();
                break;
        }
    }

    private void addWaiter(String name) {
        if (!Restaurant.getWaiterNameList().contains(name)) {
            Restaurant.getWaiterNameList().add(name);
            Restaurant.getListenerList().put("Waiter " + name, new Waiter(name));
            Restaurant.setWaiterListModified(true);
            printToScreen("Waiter " + name + " added.");
        }
        else {
            printToScreen("Can't add " + name + ", a waiter with the same name already exists");
        }
    }

    private void removeWaiter(String name) {
        if (Restaurant.getWaiterNameList().contains(name)) {
            Restaurant.getWaiterNameList().remove(name);
            Restaurant.getListenerList().remove("Waiter " + name);
            Restaurant.setWaiterListModified(true);
            printToScreen("Waiter " + name + " removed.");
        }
        else {
            printToScreen(name + " is not a waiter, cannot be removed.");
        }
    }

    private void addCook(String name) {
        if (!Restaurant.getCookNameList().contains(name)) {
            Restaurant.getCookNameList().add(name);
            Restaurant.setCookListModified(true);
            printToScreen("Cook " + name + " added.");
        }
        else {
            printToScreen("Can't add " + name + ", a cook with the same name already exists");
        }
    }

    private void removeCook(String name) {
        if (Restaurant.getCookNameList().contains(name)) {
            Restaurant.getCookNameList().remove(name);
            Restaurant.setCookListModified(true);
            printToScreen("Cook " + name + " removed.");
        }
        else {
            printToScreen(name + " is not a cook, cannot be removed.");
        }
    }

    public void printToScreen(String s) {
        System.out.println("Manager: " + s);
    }
}
