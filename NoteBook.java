import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class NoteBook {
    /*
    Создать класс Notebook с полями:
    1. Стоимость (int)
    2. Оперативная память (int)
        Нагенерить объектов этого класса, создать список и отсортировать его в трех вариантах:
    1. По возрастанию цены
    2. По убыванию цены
    3. По оперативке по убыванию. Если оперативки равны - по убыванию цены.
*/
    
    public static void main(String[] args) {
        Random r = new Random();
        List<NoteBook> notebooks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            notebooks.add(new NoteBook(r.nextInt(30000, 100000), r.nextInt(4, 17)));
        }
        PriceComparator priceComparator = new PriceComparator();
        RamComparator ramComparator = new RamComparator();
        System.out.println(notebooks);
        notebooks.sort(priceComparator);
        System.out.println(notebooks);
        Collections.reverse(notebooks);
        System.out.println(notebooks);
        notebooks.sort(ramComparator);
        System.out.println(notebooks);

    }
    private int price;
    private int ram;

    NoteBook(int price, int ram){
        this.price = price;
        this.ram = ram;
    }

    @Override
    public String toString() {
        return String.format("price: %d Rub, ram: %d Gb", this.price, this.ram);
    }


    static class PriceComparator implements Comparator<NoteBook>{
        @Override
        public int compare(NoteBook o1, NoteBook o2) {
            return o1.price - o2.price;
        }
    }

    static class RamComparator implements Comparator<NoteBook>{
        @Override
        public int compare(NoteBook o1, NoteBook o2) {
            if (o1.ram < o2.ram) return 1;
            else if (o1.ram > o2.ram) return -1;
            else return o2.price - o1.price;
        }
    }

}

