import com.aor.numbers.DivisibleByFilter
import com.aor.numbers.ListAggregator
import com.aor.numbers.ListFilterer
import com.aor.numbers.PositiveFilter
import spock.lang.Specification

class ListFiltererSpecification extends Specification{
    def listDefault = List<Integer>
    def setup(){
        listDefault = Arrays.asList(-1,2,-4,2,-5)
    }
    def "filter pos"(){
        given:
        def expected = Arrays.asList(2, 2)
        def PosFilter = new PositiveFilter()
        when:
        def MyFilter = new ListFilterer(PosFilter)
        def distinct = MyFilter.filter(listDefault)
        then:
        expected == distinct
    }
    def "filter div"(){
        given:
        def expected = Arrays.asList(2, -4, 2)
        def DivFilter = new DivisibleByFilter(2)
        when:
        def MyFilter = new ListFilterer(DivFilter)
        def distinct = MyFilter.filter(listDefault)
        then:
        expected == distinct
    }
}
