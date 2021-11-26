import com.aor.numbers.GenericListDeduplicator
import spock.lang.Specification

class FirstSpecification extends Specification {
    def "distinct_bug_8726"(){
        given:
        GenericListDeduplicator deduplicator = Mock(GenericListDeduplicator)
        deduplicator.deduplicate(_) >> Arrays.asList(1, 2, 4)
        when:
        def result = deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2))
        then:
        result == Arrays.asList(1,2,4)
    }
}
