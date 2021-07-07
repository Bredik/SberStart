package ru.sbr;

import ru.sbr.DAO.CardDAO;
import ru.sbr.entity.Cards;

import java.util.ArrayList;
import java.util.List;

public class Q {
    public static void main(String[] args) {
        List<Cards> expected = new ArrayList<>();
        expected.add(new Cards(16L, "111000000015"));
        expected.add(new Cards(19L, "111000000018"));
        expected.add(new Cards(20L, "111000000019"));

        List<Cards> actuallly = new ArrayList<>();
        expected.add(new Cards(16L, "111000000015"));
        expected.add(new Cards(19L, "111000000018"));
        expected.add(new Cards(20L, "111000000019"));


        System.out.println(expected.retainAll(actuallly));


        CardDAO cardDAO = new CardDAO();
        List<Cards> actual = cardDAO.getAllCards();
        List<Cards> expected1 = new ArrayList<>();
        expected.add(new Cards(16L, "111000000015"));
        expected.add(new Cards(19L, "111000000018"));
        expected.add(new Cards(20L, "111000000019"));

        System.out.println(expected1.retainAll(actual));
    }
}
