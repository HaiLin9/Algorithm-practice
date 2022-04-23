

public class ipToInt {

    public static long ipToInt(String ip){
        ThreadLocal<String> tl = new ThreadLocal<>();
        tl.set("123");
        tl.get();
        tl.remove();
        String[] fields = ip.split("\\.");
        System.out.println(ip);
        if(fields.length != 4){
            return 0L;
        }
        long result = 0L;
        for(int i=0; i<fields.length; i++){
            long num = Long.parseLong(fields[i]);
            num <<= (i*8);
            System.out.println(num);
            result += num;
        }
        return result;

    }

    public static void main(String[] args){
        System.out.println(ipToInt("255.255.255.255"));
    }
}
