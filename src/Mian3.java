public class Mian3 {

}


class ArrayQueue{
    Object[] arr = new Object[16];
    int size =0;
    public void ensureCapacity(int n) {
        if(n>arr.length) {
            int length = n;
            Object[] newArr= new Object[n];
            System.arraycopy(arr,0,newArr,0,arr.length);
            arr= newArr;
        }
    }

    public Object poll() {
        if(size==0){
            return null;
        }
        Object obj = arr[0];
        System.arraycopy(arr,1,arr,0,size);
        size--;
        return obj;
    }

    public boolean offer(Object obj) {
        if(size==arr.length) {
            ensureCapacity(arr.length*2);
        }
        arr[size++] = obj;
        return true;
    }
}
