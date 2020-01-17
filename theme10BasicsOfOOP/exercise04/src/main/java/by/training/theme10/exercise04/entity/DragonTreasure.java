package by.training.theme10.exercise04.entity;

import java.util.*;

public class DragonTreasure {
    private ArrayList<Treasure> treasures;
    SelectedTreasures selectedTreasures;

    public DragonTreasure() {
        treasures = new ArrayList<>();
        selectedTreasures = new SelectedTreasures();
    }

    public DragonTreasure(List<Treasure> treasures) {
        this.treasures = new ArrayList<>(treasures);
        selectedTreasures = new SelectedTreasures();
    }

    public void addTreasure(List<String> params) {
        treasures.add(new Treasure(params));
    }

    public void addTreasure(String adjective, String noun, double price) {
        treasures.add(new Treasure(adjective, noun, price));
    }

    public void addTreasureToSelected(Treasure treasure) {
        selectedTreasures.addTreasureToSelected(treasure);
    }

    public ArrayList<Treasure> getTreasures() {
        return treasures;
    }

    public Set<Treasure> getSelectedTreasures() {
        return selectedTreasures.getSelectedTreasures();
    }

    public SelectedTreasures getSelectedTreasuresObject() {
        return selectedTreasures;
    }

    public void setTreasures(ArrayList<Treasure> treasures) {
        this.treasures = treasures;
    }

    public class Treasure {
        private String adjective;
        private String noun;
        private double price;

        public Treasure(String adjective, String noun, double price) {
            this.adjective = adjective;
            this.noun = noun;
            this.price = price;
        }

        public Treasure(List<String> params) {
            adjective = params.get(0);
            noun = params.get(1);
            price = Double.parseDouble(params.get(2));
        }

        public Treasure() {
            adjective = "";
            noun = "";
            price = 0.0;
        }

        public boolean compareToParams(String adjective, String noun, double price) {
            if (this.adjective.equals(adjective) && this.noun.equals(noun) && this.price == price) {
                return true;
            } else {
                return false;
            }
        }

        public void setParams(String adjective, String noun, double price) {
            this.adjective = adjective;
            this.noun = noun;
            this.price = price;
        }

        public String getAdjective() {
            return adjective;
        }

        public void setAdjective(String adjective) {
            this.adjective = adjective;
        }

        public String getNoun() {
            return noun;
        }

        public void setNoun(String noun) {
            this.noun = noun;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Treasure)) return false;
            Treasure treasure = (Treasure) o;
            return Double.compare(treasure.getPrice(), getPrice()) == 0 &&
                    Objects.equals(getAdjective(), treasure.getAdjective()) &&
                    Objects.equals(getNoun(), treasure.getNoun());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getAdjective(), getNoun(), getPrice());
        }

        @Override
        public String toString() {
            return "Treasure{" +
                    "adjective='" + adjective + '\'' +
                    ", noun='" + noun + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    public class SelectedTreasures {
        private HashSet<Treasure> selectedTreasures;
        private double priceAvailable;
        private double sumPrice;

        public SelectedTreasures() {
            selectedTreasures = new HashSet<>();
            priceAvailable = 0.0;
            sumPrice = 0.0;
        }

        public void addTreasureToSelected(Treasure treasure) throws IllegalArgumentException {
            if ((treasure.getPrice() + sumPrice) < priceAvailable) {
                sumPrice += treasure.getPrice();
                selectedTreasures.add(treasure);
            } else {
                throw new IllegalArgumentException("Превышение суммы выбора!");

            }

        }

        public Set<Treasure> getSelectedTreasures() {
            return selectedTreasures;
        }

        public void setPriceAvailable(double priceAvailable) {
            this.priceAvailable = priceAvailable;
        }
    }
}
