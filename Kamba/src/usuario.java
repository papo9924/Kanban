
public class usuario extends Thread {
public void run(){
	String name =Thread.currentThread().getName();
	System.out.println("running"+name);
	Task task =new Task();
	
}
}
