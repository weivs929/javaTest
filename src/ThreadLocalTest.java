public class ThreadLocalTest {
    private static ThreadLocal tl_1 = new ThreadLocal(){
        //���ر��̵߳����֣�����1
        protected Object initialValue() {
            return  "Thread name 1 : "+Thread.currentThread().getName();
        }
    };
    private static ThreadLocal tl_2 = new ThreadLocal(){
        //���ر��̵߳����֣�����2
        protected Object initialValue() {
            return  "Thread name 2 : "+Thread.currentThread().getName();
        }
    };
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable(){
                public void run() {
                    new ThreadLocalTest().prt();
                }
            }).start();
        }
    }
    //��ӡ���̵߳�����
    public void prt(){
        System.out.println(tl_1.get());
        System.out.println(tl_2.get());
    }
}