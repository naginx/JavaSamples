import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class ImageTest {
    public static void main (String[] args) throws IOException {

        // 変換後の画像の最大サイズ
        final double MAX_IMAGE_SIZE = 300;
        final String IMAGE_TYPE = "jpg";

        // 変換する画像のパスを入力
        Scanner scn = new Scanner(System.in);
        System.out.println("変換する画像ファイルの絶対パスを入力してください");
        String imagePath = scn.nextLine();

        // 画像が存在するかチェック
        File img = new File(imagePath);
        if (!img.exists()) {
            System.out.println("ファイルが存在しません。プログラムを終了します。");
            return;
        }

        // 変換方法の選択
        System.out.println(imagePath + "を変換します。変換方法を選んでください");
        System.out.println("1: AreaAveraging法");
        System.out.println("2: Graphics2D法");
        String select = scn.nextLine();

        // 入出力用のファイルを設定
        File imageFile = new File(imagePath);
        Date date = new Date();
        File output = new File(date + ".jpg");

        // 選択した方法別にファイルを出力する
        // AreaAveraging
        if (select.equals("1")) {
            BufferedImage resizedImage = resizeBuff(imageFile, MAX_IMAGE_SIZE);
            ImageIO.write(resizedImage, IMAGE_TYPE, output);
        }
        // Graphics2D
        else if (select.equals("2")) {
            BufferedImage resizedImage = resizeG2D(imageFile, MAX_IMAGE_SIZE);
            ImageIO.write(resizedImage, IMAGE_TYPE, output);
        }
        // 入力が不正
        else {
            System.out.println("入力値が不正です。プログラムを終了します。");
            return;
        }

        //////////////////////////////////////////////////////////////////////////////////////
//        // 保存時の画質向上版
//        // AreaAveraging
//        if (select.equals("1")) {
//            BufferedImage resizedImage = resizeBuff(imageFile, output, MAX_IMAGE_SIZE);
//            ImageIO.write(resizedImage, IMAGE_TYPE, output);
//        }
//        // Graphics2D
//        else if (select.equals("2")) {
//            BufferedImage resizedImage = resizeG2D(imageFile, output, MAX_IMAGE_SIZE);
//            ImageIO.write(resizedImage, IMAGE_TYPE, output);
//        }
//        // 入力が不正
//        else {
//            System.out.println("入力値が不正です。プログラムを終了します。");
//            return;
//        }
        //////////////////////////////////////////////////////////////////////////////////////

        System.out.println("画像が生成されました。");
    }

    /**
     * AreaAveragingScaleFilterを使ったリサイズ処理
     * @param imageFile
     * @param maxSize
     * @throws IOException
     * @return
     */
    private static BufferedImage resizeBuff(File imageFile, double maxSize) throws IOException {

        BufferedImage buffImage = ImageIO.read(imageFile);
        double scale = getScale(buffImage, maxSize);
        int width = (int) (buffImage.getWidth() * scale);
        int height = (int) (buffImage.getHeight() * scale);

        // リサイズの処理
        ImageFilter filter = new AreaAveragingScaleFilter(width, height);
        ImageProducer imageSource = new FilteredImageSource(buffImage.getSource(), filter);
        Image dstImage = Toolkit.getDefaultToolkit().createImage(imageSource);
        BufferedImage resizedImage = new BufferedImage( // ここで劣化
                dstImage.getWidth(null), dstImage.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(dstImage, 0, 0, null);
        g2d.dispose();
        return resizedImage;
    }

    /**
     * Graphics2DのsetRenderingHintを使ったリサイズ処理
     * @param imageFile
     * @param maxSize
     * @throws IOException
     * @return
     */
    private static BufferedImage resizeG2D(File imageFile, double maxSize) throws IOException {

        BufferedImage buffImage = ImageIO.read(imageFile);
        double scale = getScale(buffImage, maxSize);
        int width = (int) (buffImage.getWidth() * scale);
        int height = (int) (buffImage.getHeight() * scale);

        // リサイズ処理
        BufferedImage resizedImage = new BufferedImage(width, height, buffImage.getType()); // ここで劣化
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
                RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
                RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING,
                RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
                RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,
                RenderingHints.VALUE_STROKE_NORMALIZE);
        g2d.drawImage(buffImage, 0, 0, width, height, null);
        g2d.dispose();
        return resizedImage;
    }

    /**
     * 指定した画像サイズと比較してスケールを算出、縦横どちらに合わせるか確定する
     * @param buffImage
     * @param maxSize
     * @return
     */
    private static double getScale(BufferedImage buffImage, double maxSize) {
        int width = buffImage.getWidth();
        int height = buffImage.getHeight();
        double widthScale = maxSize / (double) width;
        double heightScale = maxSize / (double) height;
        return Math.min(widthScale, heightScale);
    }

}
