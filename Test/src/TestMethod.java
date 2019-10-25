
class TestMethod extends Object {
	 private int id;
	 public TestMethod(int id) {
		 this.id = id;
		 System.out.println("TestMethod object "+id+" is created");
	 }
	protected void finalize() throws java.lang.Throwable {
		super.finalize();
		System.out.println("TestMethod object "+id+ " is disposed");
	}
}
