import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dinner = new HashMap<>();
    Random random  = new Random();
    public void setDinner(String category, String dish) {
        //проверка на наличие категории, если нет, то создаем категорию,и добавляем блюдо
        if(!dinner.containsKey(category)) {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dish);
            dinner.put(category, dishes);
        }else{
            //если категория уже существует, то добавляем блюдо
            dinner.get(category).add(dish);
        }

        System.out.println(dinner);
    }

    public ArrayList<String> getDinnerCombo(ArrayList<String> dishesTypes) {
        ArrayList<String> dinnerCombo = new ArrayList<>(); //создаем новый список
        for(String dish : dishesTypes) {
            String randomDish = dinner.get(dish).get(random.nextInt(dinner.get(dish).size())); //выбираем случайный блюдо из списка
            dinnerCombo.add(randomDish);
        }
        //возвращаем сгенерированный список блюд
        return dinnerCombo;
    }

    public boolean hasCategory(String category) {
        return dinner.containsKey(category);
    }
}
