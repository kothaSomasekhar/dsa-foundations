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
    public int removeTail(){
        if(size==0){
            throw new IllegalStateException("Cannot remove elements from an empty array.");
        }
        int deletedel=data[size-1];
        size--;
        if(size<(this.capacity/4) && this.capacity>2){
            shrink();
        }
        return deletedel;
    }
    private void shrink(){
        this.capacity/=2;
        int[] newarray=new int[this.capacity];
        for(int i=0;i<size;i++){
            newarray[i]=data[i];
            totalCopies++;
        }
        this.data=newarray;
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

        // 1. Fill the container up to 10 elements (capacity expands to 16)
        for (int i = 1; i <= 10; i++) {
            list.append(i * 10);
        }

        System.out.println("--- Initial State After Appends ---");
        System.out.println("Size: " + list.getSize());         // Output: 10
        System.out.println("Capacity: " + list.getCapacity()); // Output: 16

        // 2. Pop elements until size drops below 25% of 16 (which is < 4 elements)
        System.out.println("\n--- Removing Elements ---");
        for (int i = 0; i < 7; i++) {
            System.out.println("Popped: " + list.removeTail());
        }

        System.out.println("\n--- State After Memory Reclamation ---");
        System.out.println("Final Size: " + list.getSize());         // Output: 3
        System.out.println("Final Capacity: " + list.getCapacity()); // Output: 8 (Successfully halved from 16)
        System.out.println("Total Lifecyle Copies: " + list.getTotalCopies());
    }
}
