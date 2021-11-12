package cl.iromero.model;

public class Producto {
	private int idProducto;
	private String nombreProducto;
	private int precioProducto;
	private String descripcionProducto;
	private int idCategoria;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(int idProducto, String nombreProducto, int precioProducto, String descripcionProducto,
			int idCategoria) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
		this.descripcionProducto = descripcionProducto;
		this.idCategoria = idCategoria;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(int precioProducto) {
		this.precioProducto = precioProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", precioProducto="
				+ precioProducto + ", descripcionProducto=" + descripcionProducto + ", idCategoria=" + idCategoria
				+ "]";
	}
	
	
	
}
