package com.klutzynome.model;


public class ColorCalculator {
    // 0x%06X
    // X forces compliment to be in hex
    // the 0 means pad with zeros
    // 6 means give me siz digits
    public String calculateCompliment(String inputColor) {
        // return ffffff - inputColor
        int inputVal = stringToHex(inputColor);
        int white = stringToHex("ffffff");
        int compliment = white - inputVal;
        return String.format("%06X", compliment);
    }
    private int stringToHex(String inputColor) {
        int hex = Integer.parseUnsignedInt(inputColor, 16);
        return hex;
    }

    private String colorLuminance(String inputColor, double luminance) {
        String rgb = "";
        long c ;
        for (int i = 0 ; i < 3; i++) {
            c = Integer.parseInt(inputColor.substring(i*2, i*2 + 2), 16);
            c = Math.round(Math.min(Math.max(0, c + (c * luminance)),255));
            System.out.println("multiplication: " + c * luminance);
//            String cStr = String.valueOf(c);
            String cStr = Integer.toHexString((int) c);
            if (cStr.length() == 1) {
                rgb += "0" + c;
            } else {
                rgb += cStr;
            }
        }

        return rgb;
    }
    public String[] calculateMonochrome(String inputColor) {

        String[] res = new String[5];
        res[0] = inputColor;
        for (int i = 1 ; i < res.length; i++) {
            res[i] = colorLuminance(res[i - 1], 0.2 * i);
        }
        for (String color : res) {
            System.out.println("res: " + color);
        }
        // if all the entries are th same then do something else...

        return res;

    }


}
