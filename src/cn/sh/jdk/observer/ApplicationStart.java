package cn.sh.jdk.observer;

/**
 * @author sh
 */
public class ApplicationStart {

    /**
     * 两块温度面板订阅温度变化
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        WeatherData weatherData = new WeatherData();
        FirstDisplayBoard firstDisplayBoard = new FirstDisplayBoard();
        SecondDisplayBoard secondDisplayBoard = new SecondDisplayBoard();
        weatherData.addObserver(firstDisplayBoard);
        weatherData.addObserver(secondDisplayBoard);

        int i = 10;
        while (i++ < 30) {
            weatherData.setTemp(i);
            Thread.sleep(1000);
        }
    }
}
