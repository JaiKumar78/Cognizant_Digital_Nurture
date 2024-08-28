public class ProxyPattern {

    // Subject interface
    public interface Image {
        void display();
    }

    // Real Subject class
    public static class RealImage implements Image {
        private String imageName;

        public RealImage(String imageName) {
            this.imageName = imageName;
            loadImageFromServer();
        }

        private void loadImageFromServer() {
            System.out.println("Loading image: " + imageName);
        }

        @Override
        public void display() {
            System.out.println("Displaying image: " + imageName);
        }
    }

    // Proxy class
    public static class ProxyImage implements Image {
        private RealImage realImage;
        private String imageName;

        public ProxyImage(String imageName) {
            this.imageName = imageName;
        }

        @Override
        public void display() {
            if (realImage == null) {
                realImage = new RealImage(imageName);
            }
            realImage.display();
        }
    }

    // Main method to test the Proxy Pattern
    public static void main(String[] args) {
        // Create proxy image objects
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // Display images
        System.out.println("Displaying images:");
        image1.display(); // Should load image and display
        image1.display(); // Should only display (from cache)
        image2.display(); // Should load image and display
        image2.display(); // Should only display (from cache)
    }
}
