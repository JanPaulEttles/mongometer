package jan.mongometer;

import java.io.IOException;

/**
 * User: jan
 */
public class QuickEnvironment {

    public static void main(String[] args)
        throws IOException, InterruptedException  {

        String[] mongometer = {"bash", "-c", "xterm -e 'cp ~/IdeaProjects/mongometer/out/artifacts/mongometer_jar/mongometer.jar /usr/lib/jmeter/2.8/lib/ext; bash'"};
        Runtime.getRuntime().exec(mongometer);

        Thread.sleep(10000);

        String[] jmeter = {"bash", "-c", "xterm -e '/usr/lib/jmeter/2.8/bin/jmeter.sh; bash'"};
        Runtime.getRuntime().exec(jmeter);

        String[] jmeterLog = {"bash", "-c", "xterm -e 'tail -f jmeter.log; bash'"};
        Runtime.getRuntime().exec(jmeterLog);

        String[] mongod = {"bash", "-c", "xterm -e '/usr/lib/mongodb/2.0.6/bin/mongod --dbpath /data/db --logpath /data/db/mongod.log; bash'"};
        Runtime.getRuntime().exec(mongod);

        Thread.sleep(10000);

        String[] mongo = {"bash", "-c", "xterm -e 'cd /usr/lib/mongodb/2.0.6/bin/; ./mongo; bash'"};
        Runtime.getRuntime().exec(mongo);
   }
}