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


        //Runtime.getRuntime().exec("gnome-terminal --geometry=100x40 --working-directory=/usr/lib/mongodb/2.0.6/bin/ -x bash -c \"ls; cat\"");
        //Runtime.getRuntime().exec("/usr/bin/xterm -e /usr/lib/mongodb/2.0.6/bin/");
        //Runtime.getRuntime().exec("xterm -e 'cd /usr/lib/mongodb/2.0.6/bin/; ./mongo; bash'");
        //Runtime.getRuntime().exec("cmd /K start cmd.exe /K \"cd C:\\Development\\mongodb-win32-i386-2.0.2-rc1\\bin && mongod --repair\"");
        //Thread.sleep(10000);
        //Runtime.getRuntime().exec("cmd /K start cmd.exe /K \"cd C:\\Development\\mongodb-win32-i386-2.0.2-rc1\\bin && mongod --replSet modset --keyFile modkey --maxConns 200\"");
        //Runtime.getRuntime().exec("cmd /K start cmd.exe /K \"cd C:\\Development\\mongodb-win32-i386-2.0.2-rc1\\bin && mongod --replSet modset --keyFile modkey\"");
        //Thread.sleep(10000);
        //Runtime.getRuntime().exec("cmd /K start cmd.exe /K \"cd C:\\Development\\burp && java -version:\"1.6\" -jar burpsuite_pro_v1.4.jar\"");
        //Thread.sleep(1000);
        //Runtime.getRuntime().exec("cmd /K start cmd.exe /K \"cd C:\\Development\\mongodb-win32-i386-2.0.2-rc1\\bin && mongo landing -u landinguser -p landingpass\"");
        //Thread.sleep(1000);
        //Runtime.getRuntime().exec("cmd /K start cmd.exe /K \"cd C:\\Development\\apache-tomcat-6.0.33\\bin && startup.bat\"");
        //Thread.sleep(1000);
        //Runtime.getRuntime().exec("cmd /K start cmd.exe /K \"cd C:\\Development\\apache-jmeter-2.6\\bin && jmeter.bat\"");
        //Thread.sleep(1000);
        //Runtime.getRuntime().exec("cmd /K start cmd.exe /K \"cd C:\\Development\\jvmstat\\bat && jvmstat\"");
        //Thread.sleep(1000);
        //Runtime.getRuntime().exec("cmd /K start cmd.exe /K \"cd C:\\Users\\ettlesj && runevery.bat -p mongo -s 2\"");
    }
}