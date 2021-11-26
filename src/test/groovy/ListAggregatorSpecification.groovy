import com.aor.numbers.GenericListDeduplicator
import com.aor.numbers.ListAggregator
import com.aor.numbers.ListDeduplicator
import spock.lang.Specification

class ListAggregatorSpecification extends Specification {
    def listDefault = List<Integer>
    def aggregator = ListAggregator
    def setup(){
        aggregator = new ListAggregator()
        listDefault = Arrays.asList(1,2,4,2,5)
    }
    def "distinct_bug_8726"(){
        given:
        GenericListDeduplicator deduplicator = Mock(GenericListDeduplicator)
        deduplicator.deduplicate(_) >> Arrays.asList(1, 2, 4)
        when:
        def result = deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2))
        then:
        result == Arrays.asList(1,2,4)
    }
    def "max_bug_7263"(){
        when:
        def result = aggregator.max(Arrays.asList(-1,-4,-5))
        then:
        result == -1
    }
    def "sum"(){
        when:
        def result = aggregator.sum(listDefault)
        then:
        result == 14
    }
    def "max"(){
        when:
        def result = aggregator.max(listDefault)
        then:
        result == 5
    }
    def "min"(){
        when:
        def result = aggregator.min(listDefault)
        then:
        result == 1
    }
    def "distinct"(){
        given:
        ListDeduplicator deduplicator = new ListDeduplicator()
        when:
        def result = aggregator.distinct(listDefault, deduplicator)
        then:
        result == 4
    }
}
