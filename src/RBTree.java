public class RBTree {

	private enum Color{
		RED,
		BLACK
	}

	public static class RBTElement {

		private Segment key;
		private RBTElement parent;
		private RBTElement left;
		private RBTElement right;
		private Color color;

		public RBTElement(Segment key) {
			this.key=key;
			this.parent=null;
			this.left=null;
			this.right=null;
		}

		public String toString(){
			return ""+key;
		}

		public Segment getKey(){
			return key;
		}
	}

	private RBTElement nil;

	private RBTElement root;



	public RBTree(){
		nil=new RBTElement(null);
		nil.color=Color.BLACK;
		nil.parent=nil;
		nil.left=nil;
		nil.right=nil;
		root=nil;

	}

	public RBTElement search(Segment key, double t) {
		RBTElement x=search(root,key,t);
		if(x==nil)
			return null;
		return x;

	}

	private RBTElement search(RBTElement x, Segment key, double t)
	{
		while(x!=nil && key!=x.key){
			if(key.lineIntersection(t)<x.key.lineIntersection(t))
				x=x.left;
			else
				x=x.right;
		}
		return x;
	}

	public RBTElement minimum() {
		RBTElement x=minimum(root);
		if(x==nil)
			return null;
		return x;
	}

	private RBTElement minimum(RBTElement x) {
		while(x.left!=nil){
			x=x.left;
		}
		return x;
	}

	public RBTElement maximum() {
		RBTElement x=maximum(root);
		if(x==nil)
			return null;
		return x;
	}

	private RBTElement maximum(RBTElement x) {
		while(x.right!=nil){
			x=x.right;
		}
		return x;
	}

	public RBTElement above(RBTElement x) {
		if(x.right!=nil)
			return minimum(x.right);
		RBTElement y=x.parent;
		while(y!=nil && x==y.right){
			x=y;
			y=y.parent;
		}
		return y;
	}

	public RBTElement below(RBTElement x) {
		if(x.left!=nil)
			return maximum(x.left);
		RBTElement y=x.parent;
		while(y!=nil && x==y.left){
			x=y;
			y=y.parent;
		}
		return y;
	}

	private void leftRotate(RBTElement x){
		RBTElement y=x.right;
		x.right=y.left;

		if(y.left!=nil)
			y.left.parent=x;
		y.parent=x.parent;

		if(x.parent==nil){
			root=y;
		}else if(x==x.parent.left)
			x.parent.left=y;
		else
			x.parent.right=y;

		y.left=x;
		x.parent=y;

		// aggiornare size per statistiche d'ordine o max per interval tree
	}

	private void rightRotate(RBTElement x){
		RBTElement y=x.left;
		x.left=y.right;

		if(y.right!=nil)
			y.right.parent=x;
		y.parent=x.parent;

		if(x.parent==nil){
			root=y;
		}else if(x==x.parent.right)
			x.parent.right=y;
		else
			x.parent.left=y;

		y.right=x;
		x.parent=y;

		// aggiornare size per statistiche d'ordine o max per interval tree
	}

	public void insert(RBTElement z, double t){
		RBTElement y=nil;
		RBTElement x=root;

		while(x!=nil){
			// aggiungere gestione size (pr gli antenati di z) per statistiche d'ordine
			y=x;
			if(z.key.lineIntersection(t)<x.key.lineIntersection(t)){
				x=x.left;
			}else{
				x=x.right;
			}
		}

		z.parent=y;
		if(y==nil)
			root=z;
		else if(z.key.lineIntersection(t)<y.key.lineIntersection(t))
			y.left=z;
		else
			y.right=z;

		z.left=nil;
		z.right=nil;
		z.color=Color.RED;
		// aggiungere gestione size (per z) per statistiche d'ordine
		// aggiungere gestione max (per z e per i suoi antenati) per interval tree
		insertFixUp(z);
	}

	private void insertFixUp(RBTElement z) {
		while(z.parent.color==Color.RED){
			if(z.parent==z.parent.parent.left){
				RBTElement y=z.parent.parent.right;
				if(y.color==Color.RED){
					z.parent.color=Color.BLACK;
					y.color=Color.BLACK;
					z.parent.parent.color=Color.RED;
					z=z.parent.parent;

				}else{
					if(z==z.parent.right){
						z=z.parent;
						leftRotate(z);
					}
					z.parent.color=Color.BLACK;
					z.parent.parent.color=Color.RED;
					rightRotate(z.parent.parent);
				}
			}else{
				RBTElement y=z.parent.parent.left;
				if(y.color==Color.RED){
					z.parent.color=Color.BLACK;
					y.color=Color.BLACK;
					z.parent.parent.color=Color.RED;
					z=z.parent.parent;

				}else{
					if(z==z.parent.left){
						z=z.parent;
						rightRotate(z);
					}
					z.parent.color=Color.BLACK;
					z.parent.parent.color=Color.RED;
					leftRotate(z.parent.parent);
				}
			}
		}
		root.color=Color.BLACK;
	}

	public void delete(RBTElement z) {
		RBTElement y=z;
		Color yOrigColor=y.color;
		RBTElement x;

		if(z.left==nil){
			x=z.right;
			rbTransplant(z,z.right);
		}else if(z.right==nil){
			x=z.left;
			rbTransplant(z,z.left);
		}else{
			y=minimum(z.right);
			yOrigColor=y.color;
			x=y.right;
			if(y.parent==z){
				x.parent=y;
			}
			else{
				rbTransplant(y,y.right);
				y.right=z.right;
				y.right.parent=y;
			}
			rbTransplant(z,y);
			y.left=z.left;
			y.left.parent=y;
			y.color=z.color;
		}

		// aggiornare size per statistiche d'ordine  e per interval tree

		if(yOrigColor==Color.BLACK)
			deleteFixUp(x);
	}

	private void deleteFixUp(RBTElement x) {
		while(x!=root && x.color==Color.BLACK){
			if(x==x.parent.left){
				RBTElement w=x.parent.right;
				if(w.color==Color.RED){
					w.color=Color.BLACK;
					x.parent.color=Color.RED;
					leftRotate(x.parent);
					w=x.parent.right;
				}
				if(w.left.color==Color.BLACK && w.right.color==Color.BLACK){
					w.color=Color.RED;
					x=x.parent;
				}else{
					if(w.right.color==Color.BLACK){
						w.left.color=Color.BLACK;
						w.color=Color.RED;
						rightRotate(w);
						w=x.parent.right;
					}
					w.color=x.parent.color;
					x.parent.color=Color.BLACK;
					w.right.color=Color.BLACK;
					leftRotate(x.parent);
					x=root;
				}
			}else{
				RBTElement w=x.parent.left;
				if(w.color==Color.RED){
					w.color=Color.BLACK;
					x.parent.color=Color.RED;
					rightRotate(x.parent);
					w=x.parent.left;
				}
				if(w.right.color==Color.BLACK && w.left.color==Color.BLACK){
					w.color=Color.RED;
					x=x.parent;
				}else{
					if(w.left.color==Color.BLACK){
						w.right.color=Color.BLACK;
						w.color=Color.RED;
						leftRotate(w);
						w=x.parent.left;
					}
					w.color=x.parent.color;
					x.parent.color=Color.BLACK;
					w.left.color=Color.BLACK;
					rightRotate(x.parent);
					x=root;
				}
			}
		}
		x.color=Color.BLACK;

	}

	private void rbTransplant(RBTElement u, RBTElement v){
		if(u.parent==nil)
			root=v;
		else if(u==u.parent.left){
			u.parent.left=v;
		}else{
			u.parent.right=v;
		}
		v.parent=u.parent;
	}

	public String toString(){
		return print(root);
	}

	private String print(RBTElement x){
		String s="";
		if(x!=nil){
			s+=print(x.left);
			s+=" "+x.key;
			s+=print(x.right);
		}
		return s;
	}

}
