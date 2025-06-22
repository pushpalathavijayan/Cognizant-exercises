// ProxyPatternExample.java

// Step 2: Define Subject Interface
interface Image {
    void display();
}

// Step 3: Real Subject Class
class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromServer();
    }

    private void loadFromServer() {
        System.out.println("Loading image from server: " + fileName);
    }

    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
}

// Step 4: Proxy Class
class ProxyImage implements Image {
    private String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName); // Lazy initialization
        } else {
            System.out.println("Image already loaded. Using cached version.");
        }
        realImage.display();
    }
}

// Step 5: Test the Proxy Implementation
public class ProxyPatternExample {
    public static void main(String[] args) {
        Image img1 = new ProxyImage("sunrise.jpg");
        Image img2 = new ProxyImage("mountain.png");

        // First time - image loads from server
        img1.display();
        System.out.println();

        // Second time - cached
        img1.display();
        System.out.println();

        // New image - loads again
        img2.display();
    }
}
