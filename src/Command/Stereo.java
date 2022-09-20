package Command;

public class Stereo {
    void on() {
        System.out.println("オーディオON");
    }

    void off() {
        System.out.println("オーディオOFF");
    }

    void setCd() {
        System.out.println("CDをセット");
    }

    void setDvd() {
        System.out.println("DVDをセット");
    }

    void setRadio() {
        System.out.println("Radioをセット");
    }

    void setVolume(int volume) {
        System.out.println("ボリュームを" + volume + "にセット");
    }
}
