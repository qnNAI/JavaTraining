package by.training.theme10.exercise04.service;

import by.training.theme10.exercise04.dao.Parser;
import by.training.theme10.exercise04.dao.Writer;
import by.training.theme10.exercise04.entity.DragonTreasure;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class Service {
    public void generateTreasures(DragonTreasure dragonTreasure) {
        Random random = new Random();
        List<String> listAdjectives = new ArrayList<>();
        List<String> listNouns = new ArrayList<>();
        double leftLimit = 1000;
        double rightLimit = 100_000;

        dragonTreasure.getTreasures().clear();

        listAdjectives.add("Драгоценный");
        listAdjectives.add("Пиратский");
        listAdjectives.add("Затерянный");
        listAdjectives.add("Фамильный");
        listAdjectives.add("Легендарный");
        listAdjectives.add("Скрытый");
        listAdjectives.add("Ценный");
        listAdjectives.add("Мифический");
        listAdjectives.add("Утерянный");
        listAdjectives.add("Украденный");
        listAdjectives.add("Проклятый");

        listNouns.add("Клад");
        listNouns.add("Сундук");
        listNouns.add("Ларец");
        listNouns.add("Тайник");
        listNouns.add("Сундучок");
        listNouns.add("Самоцвет");
        listNouns.add("Изумруд");
        listNouns.add("Сапфир");
        listNouns.add("Алмаз");
        listNouns.add("Клинок");
        listNouns.add("Посох");
        listNouns.add("Амулет");
        listNouns.add("Сосуд");

        double price; // стоимость до округления
        double roundedPrice; // стоимость после округления

        for (int i = 0; i < 100; ++i) {
            price = Math.abs(random.nextDouble() * (rightLimit - leftLimit) + leftLimit); // рандомное число от 1000 до 100_000
            roundedPrice = new BigDecimal(price).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); // округляем до 2 знаков
            dragonTreasure.addTreasure(listAdjectives.get(random.nextInt(listAdjectives.size())),
                    listNouns.get(random.nextInt(listNouns.size())), roundedPrice);
        }

    }

    public void scanTreasuresFile(String filename, DragonTreasure dragonTreasure) throws IOException {
        Parser parser = new Parser();
        ArrayList<String> params;       // список строковых параметров
        dragonTreasure.getTreasures().clear();

        List<String> list = parser.parseFile(filename);     // получаем список строк с параметрами из файла
        int size = 0;

        if (list.size() > 100) {
            size = 100;
        } else {
            size = list.size();
        }

        if (list.get(0).length() < 5) {  // 5 - минимальное количество символов для сокровища
            throw new IOException("Файл пуст!");
        }

        for (int i = 0; i < size; ++i) {
            params = parseLine(list.get(i));      // получаем список параметров из одной строки файла
            dragonTreasure.addTreasure(params);   // отправляем этот список на добавление к списку продуктов
        }
    }

    public void writeTreasuresToFile(String filename, List<DragonTreasure.Treasure> treasures) throws IOException {
        Writer writer = new Writer();
        writer.writeProductsListToFile(filename, treasures, this);
    }

    public DragonTreasure.Treasure findMaxPriceTreasure(DragonTreasure dragonTreasure) throws NullPointerException {
        List<DragonTreasure.Treasure> treasures = dragonTreasure.getTreasures();
        DragonTreasure.Treasure treasure_max = treasures.get(0);

        for (int i = 1; i < treasures.size(); ++i) {
            if (treasures.get(i).getPrice() > treasure_max.getPrice()) {
                treasure_max = treasures.get(i);
            }
        }

        return treasure_max;
    }

    public void addTreasureToSelected(List<String> params, DragonTreasure dragonTreasure) throws IllegalArgumentException {
        ArrayList<DragonTreasure.Treasure> treasures = dragonTreasure.getTreasures();
        DragonTreasure.Treasure foundedTreasure = null;

        for (int i = 0; i < treasures.size(); ++i) {
            if (treasures.get(i).compareToParams(params.get(0), params.get(1), Double.parseDouble(params.get(2)))) {
                foundedTreasure = treasures.get(i);
                break;
            }
        }

        dragonTreasure.addTreasureToSelected(foundedTreasure);
    }

    public String makeStringParamsRow(DragonTreasure.Treasure treasure) {
        // параметры в строку
        StringBuilder params = new StringBuilder(70); // выделенный объём - 70

        params.append(treasure.getAdjective());  // прилагательное
        params.append(" ");
        params.append(treasure.getNoun());       // существительное
        params.append(" ");
        params.append(treasure.getPrice());      // стоимость

        params.append("\n");

        return params.toString();
    }

    public String makeStringOfTreasures(DragonTreasure dragonTreasure) throws NullPointerException {
        if (dragonTreasure.getTreasures().size() == 0) {
            throw new NullPointerException("Список сокровищ пуст!");
        }

        StringBuilder treasures_str = new StringBuilder();
        List<DragonTreasure.Treasure> treasures = dragonTreasure.getTreasures();

        for (int i = 0; i < treasures.size(); ++i) {
            treasures_str.append(makeStringParamsRow(treasures.get(i)));
        }

        return treasures_str.toString();
    }

    public void eraseSelected(DragonTreasure dragonTreasure) {
        dragonTreasure.getSelectedTreasures().clear();
    }

    public void setPriceAvailable(double price, DragonTreasure dragonTreasure) {
        dragonTreasure.getSelectedTreasuresObject().setPriceAvailable(price);
    }

    public String takeTreasures(DragonTreasure dragonTreasure) throws IllegalArgumentException {
        ArrayList<DragonTreasure.Treasure> treasures = dragonTreasure.getTreasures();
        HashSet<DragonTreasure.Treasure> selectedTreasures = new HashSet<>(dragonTreasure.getSelectedTreasures());

        DragonTreasure.Treasure templateTreasure;
        StringBuilder treasuresInfo = new StringBuilder("Выбранные сокровища: \n");

        if (selectedTreasures.size() == 0) {
            throw new IllegalArgumentException("Сокровища не выбраны!");
        }


        Iterator<DragonTreasure.Treasure> iterator = selectedTreasures.iterator();
        while (iterator.hasNext()) {
            templateTreasure = iterator.next();
            treasures.remove(templateTreasure);
            treasuresInfo.append(makeStringParamsRow(templateTreasure));
        }

        selectedTreasures.clear();

        return treasuresInfo.toString();
    }

    private ArrayList<String> parseLine(String line) {
        ArrayList<String> params = new ArrayList<>();
        char paramDelimeter = ' ';
        int index = 0;  // индекс разделителя

        for (int i = 0; i < 3; ++i) {
            index = line.indexOf(paramDelimeter);  // получаем индекс разделителя
            if (index != -1) {                     // если разделитель найден
                params.add(line.substring(0, index));   // добавляем к списку параметров строку от 0 до разделителя
                line = line.substring(index + 1);       // убираем из строки считанный параметр
            } else {                               // если не найден - берём оставшуюся строку
                params.add(line);
            }
        }
        return params;
    }

    public ArrayList<String> parseRequest(String request) {
        char paramDelimeter = ' ';
        ArrayList<String> params = new ArrayList<>();

        int index = 0;

        while (index != -1) {
            index = request.indexOf(paramDelimeter);
            if (index != -1) {
                params.add(request.substring(0, index));
                if (index + 1 < request.length()) {
                    request = request.substring(index + 1, request.length());
                } else {
                    return params;
                }
            } else {
                params.add(request);
            }
        }
        return params;
    }



}