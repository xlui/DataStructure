package design_pattern.structural.proxy;

public class ProxyPatternDemo {
	public static void main(String[] args) {
		Image proxyImage = new ProxyImage("test100MB.jpg");

		proxyImage.display();
		System.out.println();
		proxyImage.display();
	}
}
