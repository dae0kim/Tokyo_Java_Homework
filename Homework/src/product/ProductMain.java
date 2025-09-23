package product;

/**
 * 상품관리 실행 메서드
 */
public class ProductMain {

	public static void main(String[] args) {
		
		ProductDAO dao = new ProductDAO();
		ProductService service = new ProductService(dao);
		ProductController controller = new ProductController(service);
		
		controller.run();
		
	}

}
