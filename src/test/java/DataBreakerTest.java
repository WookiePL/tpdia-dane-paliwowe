import databreaker.DataBreaker;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class DataBreakerTest extends TestCase {
    private List<String> records;

    protected void setUp() {
        this.records = new ArrayList<>();
        records.addAll(Arrays.asList(
                "2014-01-01 00:01:00;;13;1;0;0;1\n",
                "2014-01-01 00:01:00;;14;2;0;0;1\n",
                "2014-01-01 00:01:00;;15;3;0;0;1\n",
                "2014-01-01 00:01:00;;16;4;0;0;1\n",
                "2014-01-01 00:01:00;;17;1;0;0;1\n",
                "2014-01-01 00:01:00;;18;2;0;0;1\n",
                "2014-01-01 00:01:00;;19;3;0;0;1\n",
                "2014-01-01 00:01:00;;20;4;0;0;1\n",
                "2014-01-01 00:01:00;;21;1;0;0;1\n",
                "2014-01-01 00:01:00;;22;2;0;0;1\n",
                "2014-01-01 00:01:00;;23;3;0;0;1\n",
                "2014-01-01 00:01:00;;24;4;0;0;1\n",
                "2014-01-01 00:02:00;;13;1;0;0;1\n",
                "2014-01-01 00:02:00;;14;2;0;0;1\n",
                "2014-01-01 00:02:00;;15;3;0;0;1\n",
                "2014-01-01 00:02:00;;16;4;0;0;1\n",
                "2014-01-01 00:02:00;;17;1;0;0;1\n",
                "2014-01-01 00:02:00;;18;2;0;0;1\n",
                "2014-01-01 00:02:00;;19;3;0;0;1\n",
                "2014-01-01 00:02:00;;20;4;0;0;1"
        ));


    }

    @Test
    public void testSwap() {
        List<String> recordsBefore = records;
        DataBreaker dataBreaker = new DataBreaker();
        dataBreaker.swapLines(records);
        List<String> recordsAfter = records;
        assertThat(recordsBefore, is(recordsAfter));
    }
}
