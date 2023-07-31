package org.example;

public class Radio {
    public int currentStation; //Текущая частота станции
    public int currentVolume; //Текущая громкость звука

// 1. РАДИОЧАСТОТЫ
    public int getCurrentStation() { //Получение значения станции
        return currentStation;
    }
    public void setNextStation(int newCurrentStation) { //Переключение станций вперед
        if (newCurrentStation >= 9) {
            currentStation = 0;
        } else {
            currentStation = newCurrentStation + 1;
        }
    }
    public void setPrevCurrentStation(int newCurrentStation) { //Переключение станций назад
        if (newCurrentStation <= 0) {
            currentStation = 9;
        } else {
            currentStation = newCurrentStation - 1;
        }
    }
// 2. ГРОМКОСТЬ
public int getCurrentVolume() { //Получение значения громкости
    return currentVolume;
}
    public void setIncreaseVolume (int newVolume) { //Повышение громкости (граничные значения от 0 до 100)
        if (newVolume >= 100) {
            currentVolume = 100;
        } else {
            currentVolume = newVolume + 1;
        }
    }
    public void setDecreaseVolume (int newVolume) { //Понижение громкости (граничные значения от 0 до 100)
        if (newVolume <= 0) {
            currentVolume = 0;
        } else {
            currentVolume = newVolume - 1;
        }
    }



}





