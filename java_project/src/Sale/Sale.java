package Sale;

import java.util.Objects;

public class Sale<K,V> {

	// 멤버변수 menu, price
		private K menu;
		private V price;
		
		public Sale() {
			
		}
		
		public Sale(K menu) {
			this.menu = menu;
		}
		
		public Sale(K menu, V price) {
			this.menu = menu;
			this.price = price;
		}

		// getter / setter
		public K getMenu() {
			return menu;
		}

		public void setMenu(K menu) {
			this.menu = menu;
		}

		public V getPrice() {
			return price;
		}

		public void setPrice(V price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "[ 메뉴: " + menu +" "+ price + " ]";
		}

		@Override
		public int hashCode() {
			return Objects.hash(menu);
		}


//		@Override
//		public boolean equals(Object obj) {
//			if (this == obj)
//				return true;
//			if (obj == null)
//				return false;
//			if (getClass() != obj.getClass())
//				return false;
//			Sale other = (Sale) obj;
//			return Objects.equals(menu, other.menu);
//		}
//		
		
}
