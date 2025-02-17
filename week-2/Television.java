public class Television {
    private String brand;
    private String model;
    private int volume;
    private int channel;
    private String childLockCode;
    private boolean isChildLockActive;

    public Television(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.volume = 50;
        this.channel = 1;
        this.isChildLockActive = false;
        this.childLockCode = null;
    }

    public void increaseVolume() {
        if (volume < 100) {
            volume++;
        }
    }

    public void decreaseVolume() {
        if (volume > 0) {
            volume--;
        }
    }

    public void increaseChannel() {
        if (!isChildLockActive && channel < 75) {
            channel++;
        }
    }

    public void decreaseChannel() {
        if (!isChildLockActive && channel > 1) {
            channel--;
        }
    }

    public boolean setChannel(int channel) {
        if (!isChildLockActive && channel >= 1 && channel <= 75) {
            this.channel = channel;
            return true;
        }
        return false;
    }

    public boolean setChildLock(String code) {
        if (code != null && code.length() == 4) {
            this.childLockCode = code;
            this.isChildLockActive = true;
            return true;
        }
        return false;
    }

    public boolean removeChildLock(String code) {
        if (isChildLockActive && code.equals(childLockCode)) {
            this.isChildLockActive = false;
            return true;
        }
        return false;
    }

    public boolean isChildLockEnabled() {
        return isChildLockActive;
    }
}
