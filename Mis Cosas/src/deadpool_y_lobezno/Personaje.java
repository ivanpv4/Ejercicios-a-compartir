package deadpool_y_lobezno;

public class Personaje {
	
	private int vida;
	private boolean regeneracion;

	public Personaje() {
	}

	public Personaje(int vida) {
		this.vida = vida;
		this.regeneracion = false;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public boolean getRegeneracion() {
		return regeneracion;
	}
	
	public void setRegeneracion(boolean regeneracion) {
		this.regeneracion = regeneracion;
	}

	@Override
	public String toString() {
		return "Personaje [vida=" + vida + ", regeneracion=" + regeneracion + "]";
	}

	
	
	

}
