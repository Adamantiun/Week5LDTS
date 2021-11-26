import com.aor.numbers.GenericListDeduplicator
import com.aor.numbers.ListDeduplicator
import spock.lang.Specification

class ListDeduplicatorSpecification extends Specification {
    def "deduplicate"(){
        given:
        def list = Arrays.asList(1,2,4,2,5)
        def expected = Arrays.asList(1,2,4,5)
        def deduplicator = new ListDeduplicator()
        when:
        def distinct = deduplicator.deduplicate(list)
        then:
        distinct == expected
    }
}
