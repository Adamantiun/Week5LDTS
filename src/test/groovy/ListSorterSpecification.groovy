import com.aor.numbers.ListSorter
import spock.lang.Specification

class ListSorterSpecification extends Specification{
    def "sort"(){
        given:
        def list = Arrays.asList(3, 2, 6, 1, 4, 5, 7)
        def expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7)
        def sorter = new ListSorter()
        when:
        List<Integer> sorted = sorter.sort(list)
        then:
        expected == sorted
    }
}
