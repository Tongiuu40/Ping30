package JNIMethodes;


	 public class HelloWorld {

		    public static native String sayHello(String name); // 1.声明这是一个native函数，由本地代码实现
/*
		    public static void main(String[] args) {
		        String text = sayHello("yangxin");  // 3.调用本地函数
		        System.out.println(text);
		    }
*/
		   
	 }


