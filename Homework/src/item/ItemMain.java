package item;

public class ItemMain {
	
	public static void main(String[] args) {
		ItemDAO dao = new ItemDAO();
		ItemService service = new ItemService(dao);
		ItemController controller = new ItemController(service);
		controller.run();
	}
}
