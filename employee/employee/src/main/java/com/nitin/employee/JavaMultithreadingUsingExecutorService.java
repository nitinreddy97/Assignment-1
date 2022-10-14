package com.nitin.employee;

import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.concurrent.*;

public class JavaMultithreadingUsingExecutorService {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Step 1: Fixing thread pool for memory allocation
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        String fullName = "Nitin reddy";

        // Using supplyAsync for async calls
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> getFistName(fullName),executorService);
        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> getLastName(fullName),executorService);


        task1.join();
        task2.join();
        System.out.println(task1.get()+" "+task2.get());

    }


    // Method 1 - Accepting String as argument and returns string
    private static String getFistName(String fullName) {
        System.out.println("getLastName method start : "+LocalDateTime.now());
        if(!StringUtils.isEmpty(fullName)){
            return  fullName.split(" ")[0];
        }
        return "";
    }


    //Method 2 - Accepting String as argument and returns string
    private static String getLastName(String fullName) {
        System.out.println("getFistName method start: "+LocalDateTime.now());
        if(!StringUtils.isEmpty(fullName)){
            String[] nameArray = fullName.split(" ");
            return  nameArray.length > 1 ? nameArray[1] : "";
        }
        return "";
    }
}
