package oop;

public class GoodsInfo {
	String name; 	// 상품 이름
	double price;	// 상품 가격
	int stock;	// 상품 재고
	int limit_date;	// 유통기한
	int barcode;	// 상품코드
	
	// 상품정보 불러오기
	void loadGoodsInfo(){
		System.out.println("상품이름 : " + name);
		System.out.println("상품이름 : " + price);
		System.out.println("상품이름 : " + stock);
		System.out.println("상품이름 : " + limit_date);
	}

	// 상품정보 저장하기
	void saveGoodsInfo(){
		this.name = "맥심 모카골드 마일드";
		this.price = 3000;
		this.stock = 100;
		this.limit_date = 365;
		this.barcode = 1001;
	}
	
}
