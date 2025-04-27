import java.io.IOException;
import java.io.OutputStream;

public class DecoratorStream extends OutputStream {
    private OutputStream stream;
    private String prefix;
    private boolean prefixWritten = false; // Flag pour suivre si le préfixe a été écrit

    public DecoratorStream(OutputStream stream, String prefix) {
        this.stream = stream;
        this.prefix = prefix;
    }

    @Override
    public void write(int b) throws IOException {
        // Convertit le int en tableau d'octets et délègue à write(byte[], int, int)
        byte[] singleByte = {(byte) b};
        write(singleByte, 0, 1);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        if (!prefixWritten) {
            // Écrit le préfixe en UTF-8 seulement au premier appel
            byte[] prefixBytes = prefix.getBytes("UTF-8");
            stream.write(prefixBytes);
            prefixWritten = true;
        }
        // Écrit toujours les données reçues
        stream.write(b, off, len);
    }
    
    @Override
    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }
    
    public static void main(String[] args) throws IOException {
        byte[] message = "Hello, world!".getBytes("UTF-8");
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            DecoratorStream decoratorStream = new DecoratorStream(baos, "First line: ");
            decoratorStream.write(message);
            
            System.out.println(baos.toString("UTF-8")); // Affiche "First line: Hello, world!"
        }
    }
}
