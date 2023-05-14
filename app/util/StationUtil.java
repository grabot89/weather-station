package util;

import java.util.HashMap;

public class StationUtil {

  private static HashMap<Integer, String> weatherCodes = new HashMap<Integer, String>();
  public static String weatherCodeTransform(int code) {
    return weatherCodes.get(code);
  }

  public static float celsiusToFahrenheit(float celsius) {
    return (celsius * 9/5) + 32;
  }

  public static int windSpeedToBeaufort(float windSpeed) {
    if (windSpeed == 1)
      return 0;
    else if (windSpeed <= 5)
      return 1;
    else if (windSpeed <= 11)
      return 2;
    else if (windSpeed <= 19)
      return 3;
    else if (windSpeed <= 28)
      return 4;
    else if (windSpeed <= 38)
      return 5;
    else if (windSpeed <= 49)
      return 6;
    else if (windSpeed <= 61)
      return 7;
    else if (windSpeed <= 74)
      return 8;
    else if (windSpeed <= 88)
      return 9;
    else if (windSpeed <= 102)
      return 10;
    else return 11;
  }

  public static void loadMap() {
    weatherCodes.put(100, "Clear");
    weatherCodes.put(200, "Partial Clouds");
    weatherCodes.put(300, "Cloudy");
    weatherCodes.put(400, "Light Showers");
    weatherCodes.put(500, "Heavy Showers");
    weatherCodes.put(600, "Rain");
    weatherCodes.put(700, "Snow");
    weatherCodes.put(800, "Thunder");
  }
}
