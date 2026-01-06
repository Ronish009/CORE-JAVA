package CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class MoreThan2CompletableFutureCombine {

    public static void SimulateDelay(int num){
        try{
            TimeUnit.SECONDS.sleep(num);
        }catch (InterruptedException e){

        }
    }
    public CompletableFuture<String> fetchWeatherData(){
        return CompletableFuture.supplyAsync(()->{
           SimulateDelay(2);
           return "Weather : Sunny, 25 degree Celsius";
        });
    }

    public CompletableFuture<String> fetchNewsData(){
        return CompletableFuture.supplyAsync(()->{
            SimulateDelay(3);
            return "Salman has turned to 60";
        });
    }

    public CompletableFuture<String> fetchStockData(){
        return CompletableFuture.supplyAsync(()->{
            SimulateDelay(4);
            return "ADANI POWER SHARE PRICE SOURS TO 4 PERCENTAGE";
        });
    }
    static void main(String[] args) {
        //Combine independent Multiple Future more than 2
        // Weather API
        // News API
        // Stock API
        MoreThan2CompletableFutureCombine f = new MoreThan2CompletableFutureCombine();
        CompletableFuture<String> fetchWeatherData = f.fetchWeatherData();
        CompletableFuture<String> fetchNewsData = f.fetchNewsData();
        CompletableFuture<String> fetchStockData = f.fetchStockData();
        CompletableFuture<Void> c = CompletableFuture.allOf(fetchWeatherData,fetchNewsData,fetchStockData);
        // process result after the futures are completed
        c.thenRun(()->{
            String stock = fetchStockData.join();
            String news = fetchNewsData.join();
            String weather = fetchWeatherData.join();
            System.out.println("Stock: " + stock);
            System.out.println("News: " + news);
            System.out.println("Weather: " + weather);

        }).join();
        System.out.println("Main Thread Completed");

    }
}
