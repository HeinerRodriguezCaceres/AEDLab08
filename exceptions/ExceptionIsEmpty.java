package exceptions;

public class ExceptionIsEmpty extends Exception{
	public ExceptionIsEmpty() {
		super();
	}
	public ExceptionIsEmpty(String ms) {
		super(ms);
	}
}
