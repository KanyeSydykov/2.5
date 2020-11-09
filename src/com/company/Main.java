package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatchUploaders = new CountDownLatch(1) ;

        Semaphore semaphore = new Semaphore(3,true);

        CountDownLatch countDownLatchDownloaders = new CountDownLatch(10);

   Uploader uploader = new Uploader(countDownLatchUploaders);
   uploader.start();

        for (int i = 1; i <11 ; i++) {
            new Downloader("person" + i, semaphore,countDownLatchDownloaders,countDownLatchUploaders).start();
        }



        countDownLatchDownloaders.await();
        System.out.println("Файл удаляется из сервера");






    }
}
