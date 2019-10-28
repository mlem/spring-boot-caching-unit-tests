package at.mlem.decoratorpatternforcaching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class ByDecoratingClass {


    interface OtherService {
        String fetchSomethingBig();
    }


    @Service
    public class SomeOtherService implements OtherService {

        public final List<String> DATA = Arrays.asList("foo", "bar");
        private Random random = new Random(1);

        public String fetchSomethingBig() {
            return DATA.get(random.nextInt(2));
        }

    }

    @Service
    @Primary
    public class CachedSomeOtherService implements OtherService {

        private OtherService otherService;

        @Autowired
        public CachedSomeOtherService(OtherService otherService) {
            this.otherService = otherService;
        }

        @Cacheable("bigListCache-byDecorating")
        public String fetchSomethingBig() {
            return otherService.fetchSomethingBig();
        }
    }
}
