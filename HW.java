import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HW{

    public static void main(String[] args) {
        List<Nootebook> notebooks = new ArrayList<>();
        notebooks.add(new Nootebook("Brand1", 8, 256, "OS1", "Color1"));
        notebooks.add(new Nootebook("Brand2", 16, 512, "OS2", "Color2"));
        notebooks.add(new Nootebook("Brand3", 4, 128, "OS3", "Color3"));
        notebooks.add(new Nootebook("Brand4", 8, 512, "OS4", "Color4"));

        Map<String, Object> filterCriteria = getFilterCriteriaFromUser();
        List<Nootebook> filteredNotebooks = filterNotebooks(notebooks, filterCriteria);

        System.out.println("Результат :");
        for (Nootebook notebook : filteredNotebooks) {
            System.out.println(notebook);
        }
    }

    public static Map<String, Object> getFilterCriteriaFromUser() {
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> filterCriteria = new HashMap<>();

        System.out.println("Введите харктеристики фильтрации:");
        System.out.println("1. Брэнд");
        System.out.println("2. Оперативная память");
        System.out.println("3. ЖД");
        System.out.println("4. ОС");
        System.out.println("5. Цвет");

        String input = scanner.nextLine();
        String[] selectedOptions = input.split(",");
        for (String option : selectedOptions) {
            int optionNumber = Integer.parseInt(option.trim());
            switch (optionNumber) {
                case 1:
                    System.out.print("Введите брэнд: ");
                    String brand = scanner.nextLine();
                    filterCriteria.put("brand", brand);
                    break;
                case 2:
                    System.out.print("Введите минимальный обьем оперативной памяти: ");
                    int ram = scanner.nextInt();
                    filterCriteria.put("ram", ram);
                    break;
                case 3:
                    System.out.print("Введите минимальный обьем ЖД: ");
                    int storage = scanner.nextInt();
                    filterCriteria.put("storage", storage);
                    break;
                case 4:
                    System.out.print("Введите операционную систему: ");
                    String os = scanner.nextLine();
                    filterCriteria.put("os", os);
                    break;
                case 5:
                    System.out.print("Ведите цвет: ");
                    String color = scanner.nextLine();
                    filterCriteria.put("color", color);
                    break;
                default:
                    System.out.println("Такого параметра нет : " + optionNumber);
                    break;
            }
        }

        return filterCriteria;
    }

    public static List<Nootebook> filterNotebooks(List<Nootebook> notebooks, Map<String, Object> filterCriteria) {
        List<Nootebook> filteredNotebooks = new ArrayList<>();
        
        for (Nootebook notebook : notebooks) {
            boolean isValid = true;
            
            for (Map.Entry<String, Object> entry : filterCriteria.entrySet()) {
                if (entry.getKey().equals("brand") && !notebook.getBrand().equals(entry.getValue())) {
                    isValid = false;
                    break;
                }
                
                if (entry.getKey().equals("ram") && notebook.getRam() < (int) entry.getValue()) {
                    isValid = false;
                    break;
                }
                
                if (entry.getKey().equals("storage") && notebook.getStorage() < (int) entry.getValue()) {
                    isValid = false;
                    break;
                }
                
                if (entry.getKey().equals("os") && !notebook.getClass().equals(entry.getValue())) {
                    isValid = false;
                    break;
                }
                
                if (entry.getKey().equals("color") && !notebook.getColor().equals(entry.getValue())) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                filteredNotebooks.add(notebook);
            }
        }

        return filteredNotebooks;
    }
}
