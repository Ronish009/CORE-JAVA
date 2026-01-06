class Thread3 {
    public void dosomething() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Error Occured");
        }
        System.out.println("Dosomething");
    }
}
void main() {
  var Thread14 =Thread.ofPlatform().name("t1");
  Thread14.start(()->{
      System.out.println("Run Taks1 in background");
  });
  var Thread2  =Thread.ofPlatform().name("t2");
  Thread2.start(()->{
     new Thread3().dosomething();
  });
    System.out.println("Program Completed");
}
