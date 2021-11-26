import com.aor.numbers.GenericListDeduplicator
import spock.lang.Specification

class FirstSpecification extends Specification {
    def "numbers to the power of two"(int a, int b, int c) {
        expect:
        Math.pow(a, b) == c
        where:
        a | b | c
        1 | 2 | 1
        2 | 2 | 4
        3 | 2 | 9
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
    def "Should verify notify was called"() {
        given:
        def notifier = Mock(Notifier)
        when:
        notifier.notify('foo')
        then:
        2 * notifier.notify('foo')
    }
}
