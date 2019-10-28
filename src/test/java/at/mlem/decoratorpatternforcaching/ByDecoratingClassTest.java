package at.mlem.decoratorpatternforcaching;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@DisplayName("Decorating a class")
public class ByDecoratingClassTest {


    @SpringBootTest
    @Nested
    @DisplayName("the cached version")
    public class CachedServiceTest {

        @Autowired
        ByDecoratingClass.OtherService cachedSomeOtherService;

        @Test
        @DisplayName("should return always the same result for 30 seconds")
        void alwaysSameResult() {

            String firstResult = cachedSomeOtherService.fetchSomethingBig();

            assertThat(cachedSomeOtherService.fetchSomethingBig(), is(firstResult));
            assertThat(cachedSomeOtherService.fetchSomethingBig(), is(firstResult));
            assertThat(cachedSomeOtherService.fetchSomethingBig(), is(firstResult));
            assertThat(cachedSomeOtherService.fetchSomethingBig(), is(firstResult));
            assertThat(cachedSomeOtherService.fetchSomethingBig(), is(firstResult));
            assertThat(cachedSomeOtherService.fetchSomethingBig(), is(firstResult));
            assertThat(cachedSomeOtherService.fetchSomethingBig(), is(firstResult));
            assertThat(cachedSomeOtherService.fetchSomethingBig(), is(firstResult));
            assertThat(cachedSomeOtherService.fetchSomethingBig(), is(firstResult));
            assertThat(cachedSomeOtherService.fetchSomethingBig(), is(firstResult));
            assertThat(cachedSomeOtherService.fetchSomethingBig(), is(firstResult));
        }
    }

    @SpringBootTest
    @Nested
    @DisplayName("the original implementation")
    public class NotCachedTest {

        @Autowired
        ByDecoratingClass.SomeOtherService notCachedService;

        @Test
        @DisplayName("should give us random results")
        void notCachedServicesGivesUsRandomResults() {
            assertThat(notCachedService.fetchSomethingBig(), is("bar"));
            assertThat(notCachedService.fetchSomethingBig(), is("foo"));
            assertThat(notCachedService.fetchSomethingBig(), is("foo"));
            assertThat(notCachedService.fetchSomethingBig(), is("foo"));
            assertThat(notCachedService.fetchSomethingBig(), is("foo"));
            assertThat(notCachedService.fetchSomethingBig(), is("foo"));
            assertThat(notCachedService.fetchSomethingBig(), is("foo"));
            assertThat(notCachedService.fetchSomethingBig(), is("bar"));
            assertThat(notCachedService.fetchSomethingBig(), is("bar"));
            assertThat(notCachedService.fetchSomethingBig(), is("bar"));
        }
    }

}
