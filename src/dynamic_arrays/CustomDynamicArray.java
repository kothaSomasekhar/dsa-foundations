package dynamic_arrays;

public class CustomDynamicArray {
    private int[] data;
    private int size;
    private int capacity;
    private int totalCopies;
    public CustomDynamicArray(){
            this.capacity=2;
            this.data=new int[capacity];
            this.size=0;
            this.totalCopies=0;
    }
    public void append(int element){
        if(size==capacity){
            grow();
        }
        data[this.size]=element;
        this.size++;
    }
    private void grow(){
        int newcapacity=this.capacity*2;
        int[] newarray=new int[newcapacity];
        for(int i=0;i<this.capacity;i++){
            newarray[i]=data[i];
            totalCopies+=1;
        }
        this.data=newarray;
        this.capacity=newcapacity;

    }
    public int getTotalCopies() {
        return this.totalCopies;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public static void main(String[] args) {
        CustomDynamicArray list = new CustomDynamicArray();

        // Simulating heavy insertion payload
        for (int i = 1; i <= 10; i++) {
            list.append(i * 10);
        }

        System.out.println("Active Elements (Size): " + list.getSize());       // Expected: 10
        System.out.println("Allocated Memory (Capacity): " + list.getCapacity()); // Expected: 16 (2 -> 4 -> 8 -> 16)
        System.out.println("Total Element Copies: " + list.getTotalCopies());   // Let's audit this count
    }
}
