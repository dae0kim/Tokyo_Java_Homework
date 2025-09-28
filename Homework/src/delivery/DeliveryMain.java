package delivery;

public class DeliveryMain {

	public static void main(String[] args) {
		
		// 외부 파일
		String fileName = "DB/deliveryList.csv";
		DeliveryDAO dao = new DeliveryDAO(fileName);
		
		DeliveryService service = new DeliveryService(dao);
		DeliveryController controller = new DeliveryController(service);
		controller.run();
	}

}
