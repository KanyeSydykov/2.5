package com.company;

import java.util.concurrent.CountDownLatch;

public class Uploader extends  Thread  {

    private CountDownLatch Sosko;


    private int sizeOf = 500;

    public Uploader(CountDownLatch sosko) {
        Sosko = sosko;

    }


    @Override
    public void run() {
        try{
            System.out.println("Началась загрузка файла и сервера " );
            sleep(2000);
            System.out.println("Загрузка завершена ");
            Sosko.countDown();

        }catch (Exception Ignore ) {




        }
    }
}
