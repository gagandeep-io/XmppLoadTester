package com.xmpp.loadtest;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        String[] profiles = {"10000013", "10000033", "10000048", "10000074"};//, "10000092", "10000133", "10000162", "10000197", "10000208", "10000211", "10000230", "10000234", "10000258", "10000299", "10000315", "10000336", "10000359", "10000388", "10000424", "1000044", "10000457", "10000469", "10000474", "10000486", "10000539", "10000543", "10000561", "10000575", "1000058", "1000062", "10000668", "10000674", "10000684", "10000686", "10000693", "10000695", "10000721", "10000775", "10000782", "10000810", "10000834", "10000865", "10000871", "10000933", "10000955", "10000966", "10000975", "10000985", "10001003", "10001010", "10001022", "10001033", "10001079", "10001100", "10001124", "10001156", "10001170", "10001186", "10001193", "10001200", "10001216", "10001233", "10001249", "10001255", "10001312", "10001316", "10001324", "10001365", "10001379", "10001429", "10001448", "10001486", "10001494", "10001504", "10001510", "10001525", "10001567", "10001641", "10001652", "10001669", "10001673", "10001681", "10001732", "10001738", "10001750", "10001779", "10001836", "10001852", "10001857", "10001879", "10001890", "10001898", "10001905", "10001921", "10001928", "10001947", "10001980", "10002000", "10002056", "10002073", "10002165", "10002180", "10002191", "10002194", "10002216", "10002226", "10002273", "10002295", "10002321", "10002333", "10002345", "10002359", "10002379", "10002401"};
        /*Jedis jedis = new Jedis("172.16.3.187");
        Set<String> profilesredis = jedis.smembers("xmpploadtestingprofile");*/

//        String[] profiles = profilesredis.toArray(new String[]{});

        Scheduler scheduler = new Scheduler(new DefaultConnectionFactory());
        scheduler.connect(Arrays.asList(profiles));
        Thread.sleep(5000);
        for (String profile : profiles) {
            scheduler.submitOperation(profile, new PrintRosterOperation());
        }
        Thread.sleep(20000);

        scheduler.disconnect(profiles);
    }
}
