public class LEDStrip {
    private int red;
    private int green;
    private int blue;
    private int dimmer;

    public LEDStrip() {
        this.red = 0;
        this.green = 0;
        this.blue = 0;
        this.dimmer = 255;
    }

    public boolean setColorByName(String colorName) {
        switch (colorName.toLowerCase()) {
            case "red":
                red = 255;
                green = 0;
                blue = 0;
                return true;
            case "green":
                red = 0;
                green = 255;
                blue = 0;
                return true;
            case "blue":
                red = 0;
                green = 0;
                blue = 255;
                return true;
            case "purple":
                red = 255;
                green = 0;
                blue = 255;
                return true;
            case "orange":
                red = 255;
                green = 165;
                blue = 0;
                return true;
            case "sun":
                red = 201;
                green = 141;
                blue = 38;
                return true;
            default:
                return false;
        }
    }

    public String getColorName() {
        if (red == 255 && green == 0 && blue == 0)
            return "red";
        if (red == 0 && green == 255 && blue == 0)
            return "green";
        if (red == 0 && green == 0 && blue == 255)
            return "blue";
        if (red == 255 && green == 0 && blue == 255)
            return "purple";
        if (red == 255 && green == 165 && blue == 0)
            return "orange";
        if (red == 201 && green == 141 && blue == 38)
            return "sun";
        return "unknown";
    }

    public void adjustDimmer(int percentage) {
        if (percentage >= 0 && percentage <= 100) {
            dimmer = (255 * percentage) / 100;
        }
    }
}
