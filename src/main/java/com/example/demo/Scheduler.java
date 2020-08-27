package com.example.demo;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
   /* final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

   @Scheduled(cron = "0 * 9 * * ?")
   public void cronJobSch() {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
      Date now = new Date();
      String strDate = sdf.format(now);
      System.out.println("Java cron job expression:: " + strDate);
   }
   @Scheduled(fixedRate = 2000)
   public void scheduleTaskWithFixedRate() {

	   System.out.println("Fixed Rate Task :: Execution Time - {}"+dateTimeFormatter.format(LocalDateTime.now()) );
   }
   @Scheduled(fixedDelay = 2000)
   public void scheduleTaskWithFixedDelay() {
	   System.out.println("Fixed delay Task :: Execution Time - {}"+dateTimeFormatter.format(LocalDateTime.now()) );
       try {
           TimeUnit.SECONDS.sleep(5);
       } catch (InterruptedException ex) {
           throw new IllegalStateException(ex);
       }
   }
   @Scheduled(fixedRate = 2000, initialDelay = 5000)
   public void scheduleTaskWithInitialDelay() {
	   System.out.println("Fixed rate Task with initial delay:: Execution Time - {}"+dateTimeFormatter.format(LocalDateTime.now()) );
   }
   
   
   @Scheduled(cron = "0 * * * * ?")
   public void scheduleTaskWithCronExpression() {
	   System.out.println("Cron Task :: Execution Time - {}"+ dateTimeFormatter.format(LocalDateTime.now()));
	   
   }
   */
   
   
}