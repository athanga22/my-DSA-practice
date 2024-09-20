package Heap;

public class MinHeap {
    private int[] heap;
    private int maxSize;
    private int size;
    MinHeap(int maxSize){
        this.maxSize=maxSize;
        this.size=0;
        heap=new int[maxSize];
    }
    private int parent(int ind){
        return (ind-1)/2;
    }
    private int leftChild(int ind){
        return (2*ind)+1;
    }
    private int rightChild(int ind){
        return (2*ind)+2;
    }
    private boolean isLeaf(int ind){
        return ind>=(size/2) && ind<size;
    }
    private void swap(int i, int j){
        int temp=heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
    }
    public void insert(int ele){
        if(size>maxSize) return;
        heap[size]=ele;
        int curr=size++;
        while(curr>0 && heap[curr]<heap[parent(curr)]){
            swap(curr, parent(curr));
            curr=parent(curr);
        }
    }
    public static void main(String[] args) {

    }
}
