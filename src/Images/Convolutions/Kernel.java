package Images.Convolutions;

public class Kernel {
    int[] kernel;
    int[] imagePixels;
    int resX, resY;

    public Kernel(int[] kernel, int[] imagePixels, int resX, int resY) {
        this.kernel = kernel;
        this.imagePixels = imagePixels;
        this.resX = resX;
        this.resY = resY;
    }

    public int[] mask() {
        int[] convulatedImg = new int[imagePixels.length];
        for (int i = 0; i < resY; i++) {
            for (int j = 0; j < resX; j++) {
                int index = i*resX + j;
                if (i == 0 || j < 1 || j == resX - 1 || i == resY - 1) {
                    convulatedImg[index] = convoluteEdge(index);
                }else {
                    convulatedImg[index] = convolute(index);
                }
            }
        }
        return convulatedImg;
    }

    public int[] rMask(int threshold) {
        int[] convolutedImg = new int[imagePixels.length];
        for (int i = 0; i < resY; i++) {
            for (int j = 0; j < resX; j++) {
                int index = i*resX + j;
                if (i == 0 || j < 1 || j == resX - 1 || i == resY - 1) {
                    int value = convoluteEdge(index);
//                    System.out.println(value);
                    if (value > threshold){
                        convolutedImg[index] = value;
                    } else {
                        convolutedImg[index] = 0xff000000;
                    }
                }else {
                    int value = convolute(index);
//                    System.out.println(value);
                    if (value < threshold) {
                        convolutedImg[index] = value;
                    } else {
                        convolutedImg[index] = 0xff000000;
                    }
                }
            }
        }
        return convolutedImg;
    }

    private int convolute(int index) {
        int value;
        value = imagePixels[index - resX - 1]*kernel[0] +
                imagePixels[index - resX]*kernel[1] +
                imagePixels[index - resX + 1]*kernel[2] +
                imagePixels[index - 1]*kernel[3] +
                imagePixels[index]*kernel[4] +
                imagePixels[index + 1]*kernel[5] +
                imagePixels[index + resX - 1]*kernel[6] +
                imagePixels[index + resX]*kernel[7] +
                imagePixels[index + resX + 1]*kernel[8];

        return value;
    }

    private int convoluteEdge(int index) {
        int value;
        if (index == 0) {
            value = imagePixels[index]*kernel[0] +
                    imagePixels[index]*kernel[1] +
                    imagePixels[index + 1]*kernel[2] +
                    imagePixels[index]*kernel[3] +
                    imagePixels[index]*kernel[4] +
                    imagePixels[index + 1]*kernel[5] +
                    imagePixels[index + resX]*kernel[6] +
                    imagePixels[index + resX]*kernel[7] +
                    imagePixels[index + resX + 1]*kernel[8];
        } else if (index < resX && index != resX - 1) {
            value = imagePixels[index - 1]*kernel[0] +
                    imagePixels[index]*kernel[1] +
                    imagePixels[index + 1]*kernel[2] +
                    imagePixels[index - 1]*kernel[3] +
                    imagePixels[index]*kernel[4] +
                    imagePixels[index + 1]*kernel[5] +
                    imagePixels[index + resX - 1]*kernel[6] +
                    imagePixels[index + resX]*kernel[7] +
                    imagePixels[index + resX + 1]*kernel[8];
        } else if (index == resX - 1) {
            value = imagePixels[index - 1]*kernel[0] +
                    imagePixels[index]*kernel[1] +
                    imagePixels[index]*kernel[2] +
                    imagePixels[index - 1]*kernel[3] +
                    imagePixels[index]*kernel[4] +
                    imagePixels[index]*kernel[5] +
                    imagePixels[index + resX - 1]*kernel[6] +
                    imagePixels[index + resX]*kernel[7] +
                    imagePixels[index + resX]*kernel[8];
        } else if (index == resX * (resY - 1)) {
            value = imagePixels[index - resX]*kernel[0] +
                    imagePixels[index - resX]*kernel[1] +
                    imagePixels[index - resX + 1]*kernel[2] +
                    imagePixels[index]*kernel[3] +
                    imagePixels[index]*kernel[4] +
                    imagePixels[index + 1]*kernel[5] +
                    imagePixels[index]*kernel[6] +
                    imagePixels[index]*kernel[7] +
                    imagePixels[index + 1]*kernel[8];
        } else if (index > resX * (resY - 1) && index < resX * resY - 1) {
            value = imagePixels[index - resX - 1]*kernel[0] +
                    imagePixels[index - resX]*kernel[1] +
                    imagePixels[index - resX + 1]*kernel[2] +
                    imagePixels[index - 1]*kernel[3] +
                    imagePixels[index]*kernel[4] +
                    imagePixels[index + 1]*kernel[5] +
                    imagePixels[index - 1]*kernel[6] +
                    imagePixels[index]*kernel[7] +
                    imagePixels[index + 1]*kernel[8];
        } else if (index == resX * resY - 1){
            value = imagePixels[index - resX - 1]*kernel[0] +
                    imagePixels[index - resX]*kernel[1] +
                    imagePixels[index - resX]*kernel[2] +
                    imagePixels[index - 1]*kernel[3] +
                    imagePixels[index]*kernel[4] +
                    imagePixels[index]*kernel[5] +
                    imagePixels[index - 1]*kernel[6] +
                    imagePixels[index]*kernel[7] +
                    imagePixels[index]*kernel[8];
        } else if (index % resX == 0) {
            value = imagePixels[index - resX]*kernel[0] +
                    imagePixels[index - resX]*kernel[1] +
                    imagePixels[index - resX + 1]*kernel[2] +
                    imagePixels[index]*kernel[3] +
                    imagePixels[index]*kernel[4] +
                    imagePixels[index + 1]*kernel[5] +
                    imagePixels[index + resX]*kernel[6] +
                    imagePixels[index + resX]*kernel[7] +
                    imagePixels[index + resX + 1]*kernel[8];
        } else if (index % resX == resX - 1) {
            value = imagePixels[index - resX - 1]*kernel[0] +
                    imagePixels[index - resX]*kernel[1] +
                    imagePixels[index - resX]*kernel[2] +
                    imagePixels[index - 1]*kernel[3] +
                    imagePixels[index]*kernel[4] +
                    imagePixels[index]*kernel[5] +
                    imagePixels[index + resX - 1]*kernel[6] +
                    imagePixels[index + resX]*kernel[7] +
                    imagePixels[index + resX]*kernel[8];
        } else return 0;
        return value;
    }
}
