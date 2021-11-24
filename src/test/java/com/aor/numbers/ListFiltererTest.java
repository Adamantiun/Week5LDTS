package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {

    @Test
    public void filterPos() {
        List<Integer> list = Arrays.asList(-1,2,-4,2,-5);
        List<Integer> expected = Arrays.asList(2, 2);
        PositiveFilter PosFilter = new PositiveFilter();
        ListFilterer MyFilter = new ListFilterer(PosFilter);
        List<Integer> distinct = MyFilter.filter(list);

        Assertions.assertEquals(expected, distinct);
    }
    @Test
    public void filterDiv() {
        List<Integer> list = Arrays.asList(-1,2,-4,2,-5);
        List<Integer> expected = Arrays.asList(2, -4, 2);
        DivisibleByFilter DivFilter = new DivisibleByFilter(2);
        ListFilterer MyFilter = new ListFilterer(DivFilter);
        List<Integer> distinct = MyFilter.filter(list);

        Assertions.assertEquals(expected, distinct);
    }
}
