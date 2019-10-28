package at.mlem.decoratorpatternforcaching;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

@Component
public class ByExtendingClass {

    @Service("someService")
    public class SomeService {

        private Random random = new Random(1);

        public String fetchSomethingBig() {
            return Arrays.asList("foo", "bar").get(random.nextInt(2));
        }
    }

    @Service("cachedSomeService")
    public class CachedSomeService extends SomeService {
        @Override
        @Cacheable("bigListCache-byExtending")
        public String fetchSomethingBig() {
            return super.fetchSomethingBig();
        }
    }
}
