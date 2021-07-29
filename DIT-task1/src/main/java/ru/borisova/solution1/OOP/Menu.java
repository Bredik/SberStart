package ru.borisova.solution1.OOP;

import ru.borisova.solution1.OOP.Actions.*;
import ru.borisova.solution1.entity.Person;

import java.util.*;

public class Menu {
    private final HashMap<String, MenuItem> items = new HashMap<>();
    private final Scanner scanner;
    private final List<Person> personList = new ArrayList<>();

    public Menu(Scanner scanner) {
        this.scanner = scanner;
        items.put("Add", new MenuItem(new Add(scanner)));
        items.put("Show", new MenuItem(new Show()));
        items.put("Uni", new MenuItem(new ShowUnique()));
        items.put("Save", new MenuItem(new WriteIntoFile()));
        items.put("Read", new MenuItem(new ReadFile()));
        items.put("Clear", new MenuItem(new ClearFile()));
    }

    public void exe() throws Exception {
        initMenu();
        boolean flag = true;
        while (flag) {
            String command = scanner.nextLine();

            if (command.equals("Exit")) {
                flag = false;
            } else if (items.containsKey(command)) {
                items.get(command).exec(personList);
            } else System.out.println("command not found");
        }
    }


    private static class MenuItem {
        private Exec exec;
        public MenuItem( Exec exec) {
            this.exec = exec;
        }
        public void exec(List<Person> personList) throws Exception {
            exec.exec(personList);
        }
    }

    private void initMenu() {
        System.out.println("Menu:");
        System.out.println("1. Add");
        System.out.println("2. Show");
        System.out.println("3. Exit");
        System.out.println("4. Show sorted unique");
        System.out.println("5. Save to file");
    }
}
