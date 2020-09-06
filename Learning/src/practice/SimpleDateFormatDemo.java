package practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleDateFormatDemo {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String format(ThreadLocal<SimpleDateFormat> tl, Date date) {
        return tl.get().format(date);
    }

    public static Date parse(ThreadLocal<SimpleDateFormat> tl, String date) throws ParseException {
        return tl.get().parse(date);

    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        Date date = new Date();

        for (int i = 0; i < 30; i++) {

            executorService.execute(() -> {
                for (int j = 0; j < 10; j++) {
                    ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<>();
                    tl.set(new SimpleDateFormat());
                    String format = format(tl, date);
                    Date parse = null;
                    try {
                        parse = parse(tl, format);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    System.out.println(parse);
                }
            });
        }

        executorService.shutdown();
    }
}
