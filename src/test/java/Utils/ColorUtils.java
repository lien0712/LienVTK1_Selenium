package Utils;

import org.openqa.selenium.support.Color;

public class ColorUtils {

    public static double calculateLuminance(int r, int g, int b) {
        double[] rgb = {r / 255.0, g / 255.0, b / 255.0};

        for (int i = 0; i < rgb.length; i++) {
            if (rgb[i] <= 0.03928) {
                rgb[i] = rgb[i] / 12.92;
            } else {
                rgb[i] = Math.pow((rgb[i] + 0.055) / 1.055, 2.4);
            }
        }
        return 0.2126 * rgb[0] + 0.7152 * rgb[1] + 0.0722 * rgb[2];
    }

    public static double convertColor(String bgColor){
        // Convert sang Color object
        Color bgColorObj = Color.fromString(bgColor);

        // Lấy giá trị RGB
        int r = bgColorObj.getColor().getRed();
        int g = bgColorObj.getColor().getGreen();
        int b = bgColorObj.getColor().getBlue();

        // Tính relative luminance
        double L = calculateLuminance(r, g, b);

        // Tính contrast ratio
        double ratio = (Math.max(L, L) + 0.05) / (Math.min(L, L) + 0.05);
        return ratio;
    }
}
