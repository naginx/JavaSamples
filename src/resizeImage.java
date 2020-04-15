import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.*;
import java.awt.image.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class resizeImage {
    public static void Main(String[] args) {
        File file = new File("java.txt");

        String str = file.getAbsolutePath();
        System.out.println("path: " + str);

    }

    public static void scaleImage(File in, File out, double scale) throws IOException {
        BufferedImage org = ImageIO.read(in);
        ImageFilter filter = new AreaAveragingScaleFilter((int)(org.getWidth() * scale), (int)(org.getHeight() * scale));
        ImageProducer p = new FilteredImageSource(org.getSource(), filter);
        java.awt.Image dstImage = Toolkit.getDefaultToolkit().createImage(p);
        BufferedImage dst = new BufferedImage(
                dstImage.getWidth(null), dstImage.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = dst.createGraphics();
        g.drawImage(dstImage, 0, 0, null);
        g.dispose();
        ImageIO.write(dst, "jpeg", out);
    }


    public static void createThumbnailImage(byte[] arrByteInput, String urlThumbnail, int imageWidth, String imageType, float imageQuality) throws IOException {
        BufferedImage img = ImageIO.read(new ByteArrayInputStream(arrByteInput));

        // 受けとった画像をリサイズして表示用画像を作成
        double scale = (double) img.getWidth(null) / (double) imageWidth;
        int height = new Double(img.getHeight(null) / scale).intValue();
        ImageFilter filter = new AreaAveragingScaleFilter(
                img.getWidth() * imageWidth, img.getHeight() * height);
        ImageProducer imageSource = new FilteredImageSource(img.getSource(), filter);
        Image dstImage = Toolkit.getDefaultToolkit().createImage(imageSource);
        BufferedImage bsi = new BufferedImage(
                dstImage.getWidth(null), dstImage.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bsi.createGraphics();
        graphics2D.drawImage(dstImage, 0, 0, null);
        graphics2D.dispose();

        // 画像形式・画質等のオプションを指定
        ImageWriter writer = ImageIO.getImageWritersByFormatName(imageType).next();
        ImageWriteParam param = writer.getDefaultWriteParam();
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(imageQuality);

        // 保存処理
        File destFile = new File(urlThumbnail);
        destFile.getParentFile().mkdirs();
        FileImageOutputStream fios = new FileImageOutputStream(destFile);
        writer.setOutput(fios);
        writer.write(null, new IIOImage(bsi, null, null), param);
        writer.dispose();
    }

}
