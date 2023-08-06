package org.example;

public class Radio {
    private int currentStation; //Текущая частота станции
    private int currentVolume; //Текущая громкость звука

    public int getCurrentStation() { //Получение значения станции
        return currentStation;
    }

    public int getCurrentVolume() { //Получение значения громкости
        return currentVolume;
    }

    // ПЕРЕКЛЮЧЕНИЕ ГРОМКОСТИ
    public void setCurrentVolume(int newCurrentVolume) { //Изменение громкости в пределах допустимых значений
        if (newCurrentVolume < 0) {
            this.currentVolume = 0;
            return;
        }
        if (newCurrentVolume > 100) {
            this.currentVolume = 100;
            return;
        }
        this.currentVolume = newCurrentVolume;
    }

    public void IncreaseVolume() { //Повышение громкости
        if (currentVolume < 100) {
            currentVolume++;
            return;
        }
        currentVolume = 100;
    }

    public void DecreaseVolume() { //Уменьшение громкости
        if (currentVolume > 0) {
            currentVolume--;
            return;
        }
        currentVolume = 0;
    }

    // ПЕРЕКЛЮЧЕНИЕ СТАНЦИЙ

    public void setCurrentStation(int newCurrentStation) { //Переключение станций в пределах допустимого диапазона
        if (newCurrentStation < 0) {
            //this.currentStation = 9;
            return;
        }
        if (newCurrentStation > 9) {
            //this.currentStation = 0;
            return;
        }
        this.currentStation = newCurrentStation;
    }

    public void nextStation() { //Переключение станций вперед
        if (currentStation != 9) {
            currentStation++;
        } else {
            currentStation = 0;
        }

    }

    public void prevStation() { //Переключение станций назад
        if (currentStation > 0) {
            currentStation--;
            return;
        }
        currentStation = 9;
    }
}





