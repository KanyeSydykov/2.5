package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloader extends  Thread {

    private int size = 500;

    private int speed = 100;
    private Semaphore Oks;
    private CountDownLatch downloaders;
    private CountDownLatch uploaders;

    public Downloader(String name, Semaphore oks, CountDownLatch downloaders, CountDownLatch uploaders) {
        super(name);
        Oks = oks;
        this.downloaders = downloaders;
        this.uploaders = uploaders;
    }

    @Override
    public void run() {
        try {

            uploaders.await();
            Oks.acquire();
            System.out.println(getName() + "Начал скачивать");
            sleep(size /speed * 100);
            System.out.println(getName() + "Скачал");

            Oks.release();
            downloaders.countDown();


        }catch (Exception ignore ){}
        }
    }

